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
        return (String) em.createNamedQuery("Taxi.findEstadoByNumBastidor").
                setParameter("numBastidor", idTaxi).getSingleResult();
    }

    @Override
    public Taxi consultaInfoTaxi(Integer idTaxi) {
        return (Taxi) em.createNamedQuery("Taxi.findByNumBastidor").
                setParameter("numBastidor", idTaxi).getSingleResult();
    }

    @Override
    public Integer insertarSolicitud(String nombre, String direccion, String telefono) {
        Solicitud solicitud = new Solicitud(nombre, direccion, telefono, System.currentTimeMillis());
        //solicitud.setIdSolicitud(2);
        em.persist(solicitud);
        return solicitud.getIdSolicitud();
    }

    @Override
    public Integer obtenerTaxi(Integer idSolicitud) {
        List<Taxi> listaSolicitudes = em.createNamedQuery("Solicitud.findTaxis").getResultList();

        int numSolicitudes = listaSolicitudes.size();

        List<Integer> listaTaxis = consultaListaTaxis();
        int numTaxis = listaTaxis.size();

        ArrayList<Integer> taxisCandidatos = new ArrayList<Integer>();

        Integer taxiCandidato;

        if (numSolicitudes == 0) {
            taxiCandidato = listaTaxis.get(0);
            for (int i = 0; i < numTaxis; i++) {
                taxisCandidatos.add(listaTaxis.get(i));
            }
        } else {
            taxisCandidatos = generarCandidatos(numTaxis, listaSolicitudes, taxisCandidatos);
            taxiCandidato = taxisCandidatos.get(taxisCandidatos.size() - 1);

            List<Integer> copiaListaTaxis = listaTaxis;
            while (taxisCandidatos.size() < listaTaxis.size()) {
                taxiCandidato = copiaListaTaxis.get(0);
                if (!estaEnLista(taxisCandidatos, taxiCandidato)) {
                    taxisCandidatos.add(taxiCandidato);
                }
                copiaListaTaxis.remove(0);
            }

            boolean enviado = enviarMensaje(idSolicitud, taxiCandidato);

            while (taxisCandidatos.size() > 0 && !enviado) {
                taxisCandidatos.remove(taxiCandidato);
                taxiCandidato = taxisCandidatos.get(taxisCandidatos.size() - 1);
                enviado = enviarMensaje(idSolicitud, taxiCandidato);
            }
        }

        return taxiCandidato;
    }

    @Override
    public boolean enviarMensaje(Integer idSolicitud, Integer idTaxi) {

        Solicitud solicitud = (Solicitud) em.createNamedQuery("Solicitud.findByIdSolicitud").setParameter("idSolicitud", idSolicitud).getResultList().get(0);
        Taxi taxi = (Taxi) em.createNamedQuery("Taxi.findByNumBastidor").setParameter("numBastidor", idTaxi).getResultList().get(0);

        solicitud.setTaxiNumBastidor(taxi);


        return true;
    }

    private ArrayList<Integer> generarCandidatos(int numTaxis, List<Taxi> listaSolicitudes, ArrayList<Integer> taxisCandidatos) {
        int numSolicitudes = listaSolicitudes.size();
        Integer taxiCandidato;

        while (numTaxis > 0 && numSolicitudes > 0) {
            taxiCandidato = listaSolicitudes.get(numSolicitudes - 1).getNumBastidor();
            if (!estaEnLista(taxisCandidatos, taxiCandidato)) {
                taxisCandidatos.add(taxiCandidato);
                numTaxis--;
            }
            numSolicitudes--;
        }
        return taxisCandidatos;
    }

    private boolean estaEnLista(ArrayList lista, int id) {
        boolean encontrado = false;
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size() - 1; i++) {
                if (id == lista.get(i)) {
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }
}
