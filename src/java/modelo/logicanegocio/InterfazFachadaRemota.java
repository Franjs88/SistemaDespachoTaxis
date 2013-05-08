/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logicanegocio;

import java.util.List;
import modelo.accesodatos.Taxi;

/**
 *
 * @author fran
 */
public interface InterfazFachadaRemota {
    
    public List<Integer> consultaListaTaxis();
    
    public String consultaEstadoTaxi(Integer idTaxi);
    
    public Taxi consultaInfoTaxi(Integer idTaxi);
    
    /**
     *
     * @param nombre
     * @param direccion
     * @param telefono
     */
    public Integer insertarSolicitud(String nombre, String direccion, String telefono);
    
    public Integer obtenerTaxi(Integer idSolicitud);
    
    public boolean enviarMensaje(Integer idSolicitud, Integer idTaxi);
    
}
