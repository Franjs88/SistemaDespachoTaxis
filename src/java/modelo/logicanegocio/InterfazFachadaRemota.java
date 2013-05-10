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
    
    public Integer insertarSolicitud(String nombre, String direccion, String telefono);
    
    public Integer obtenerTaxi();
    
    public boolean enviarMensaje(Integer idSolicitud, Integer idTaxi);
    
}
