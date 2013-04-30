/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logicanegocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InfoTaxi consultaInfoTaxi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertarSolicitud(String nombre, String direccion, String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer obtenerTaxi(Integer idSolicitud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean enviarMensaje(Integer idSolicitud, Integer idTaxi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
