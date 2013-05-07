/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logicanegocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.accesodatos.Solicitud;
import modelo.accesodatos.Taxi;

/**
 *
 * @author fran
 */
@Stateless
@LocalBean
public class FachadaDeSesion implements InterfazFachadaRemota {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Integer> consultaListaTaxis() {
        return (List<Integer>) em.createNamedQuery("Taxi.findAllByNumBastidor").getResultList();
    }

    @Override
    public String consultaEstadoTaxi(Integer idTaxi) {
        return (String) em.createNamedQuery("Taxi.findEstadoByNumBastidor").setParameter("numBastidor", idTaxi).getResultList().get(0);
    }

    @Override
    public InfoTaxi consultaInfoTaxi(Integer idTaxi) {
        return (new InfoTaxi((String) em.createNamedQuery("Taxi.findEstadoByNumBastidor").setParameter("numBastidor", idTaxi).getResultList().get(0), (String) em.createNamedQuery("Taxi.findUbicacionByNumBastidor").setParameter("numBastidor", idTaxi).getResultList().get(0), idTaxi));
    }

    @Override
    public boolean insertarSolicitud(String nombre, String direccion, String telefono) {
         Solicitud solicitud = new Solicitud(nombre, direccion, telefono, System.currentTimeMillis());
         em.persist(solicitud);
         return true;
    }

    @Override
    public Integer obtenerTaxi(Integer idSolicitud) {
        List<Taxi> listaSolicitudes = em.createNamedQuery("Solicitud.findTaxis").getResultList();
        int numSolicitudes = listaSolicitudes.size();
        List<Integer> listaTaxis = consultaListaTaxis();
        int numTaxis = listaTaxis.size();
        
        ArrayList<Integer> ultimosTaxis = new ArrayList<Integer>();
        Integer idTaxi = null;
        
        if (numSolicitudes == 0) {
            idTaxi = listaTaxis.get(0);
            for (int i = 0; i < numTaxis; i++) {
                ultimosTaxis.add(listaTaxis.get(i));
            }
        }
                
        while (numTaxis > 0 && numSolicitudes > 0){
            idTaxi = listaSolicitudes.get(numSolicitudes - 1).getNumBastidor();
            if (!estaEnLista(ultimosTaxis, idTaxi)) {
                ultimosTaxis.add(idTaxi);
                numTaxis--;
            }
           numSolicitudes--;
        }
        
        List<Integer> copiaListaTaxis = listaTaxis;
        while (ultimosTaxis.size() < listaTaxis.size()) {
            idTaxi = copiaListaTaxis.get(0);
            if (!estaEnLista(ultimosTaxis, idTaxi)) {
                ultimosTaxis.add(idTaxi);
            }
            copiaListaTaxis.remove(0);
        }
        
        boolean enviado = enviarMensaje(idSolicitud, idTaxi); 
        
        while (ultimosTaxis.size() > 0 && !enviado) {
            ultimosTaxis.remove(idTaxi);
            idTaxi = ultimosTaxis.get(ultimosTaxis.size()-1);
            enviado = enviarMensaje(idSolicitud, idTaxi);
        }
        
        return idTaxi;
    }

    @Override
    public boolean enviarMensaje(Integer idSolicitud, Integer idTaxi) {
        
        Solicitud solicitud = (Solicitud) em.createNamedQuery("Solicitud.findByIdSolicitud").setParameter("idSolicitud", idSolicitud).getResultList().get(0);
        Taxi taxi = (Taxi) em.createNamedQuery("Taxi.findByNumBastidor").setParameter("numBastidor", idTaxi).getResultList().get(0);
        
        solicitud.setTaxiNumBastidor(taxi);

        
        return true;
    }
    
    
    protected boolean estaEnLista (ArrayList lista, int id) {
        boolean encontrado = false;
        if (!lista.isEmpty()){
            for (int i = 0; i < lista.size()-1; i++) {
                if (id == lista.get(i)) {
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }

}
