package modelo.logicanegocio;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import modelo.accesodatos.Taxi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fran
 */
public class FachadaDeSesionTest {
    
    public FachadaDeSesionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultaListaTaxis method, of class FachadaDeSesion.
     */
    @Test
    public void testConsultaListaTaxis() throws Exception {
        System.out.println("consultaListaTaxis");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FachadaDeSesion instance = (FachadaDeSesion)container.getContext().lookup("java:global/classes/FachadaDeSesion");
        List expResult = null;
        List result = instance.consultaListaTaxis();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaEstadoTaxi method, of class FachadaDeSesion.
     */
    @Test
    public void testConsultaEstadoTaxi() throws Exception {
        System.out.println("consultaEstadoTaxi");
        Integer idTaxi = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FachadaDeSesion instance = (FachadaDeSesion)container.getContext().lookup("java:global/classes/FachadaDeSesion");
        String expResult = "";
        String result = instance.consultaEstadoTaxi(idTaxi);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultaInfoTaxi method, of class FachadaDeSesion.
     */
    @Test
    public void testConsultaInfoTaxi() throws Exception {
        System.out.println("consultaInfoTaxi");
        Integer idTaxi = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FachadaDeSesion instance = (FachadaDeSesion)container.getContext().lookup("java:global/classes/FachadaDeSesion");
        Taxi expResult = null;
        Taxi result = instance.consultaInfoTaxi(idTaxi);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarSolicitud method, of class FachadaDeSesion.
     */
    @Test
    public void testInsertarSolicitud() throws Exception {
        System.out.println("insertarSolicitud");
        String nombre = "";
        String direccion = "";
        String telefono = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FachadaDeSesion instance = (FachadaDeSesion)container.getContext().lookup("java:global/classes/FachadaDeSesion");
        Integer expResult = null;
        Integer result = instance.insertarSolicitud(nombre, direccion, telefono);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerTaxi method, of class FachadaDeSesion.
     */
    @Test
    public void testObtenerTaxi() throws Exception {
        System.out.println("obtenerTaxi");
        Integer idSolicitud = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FachadaDeSesion instance = (FachadaDeSesion)container.getContext().lookup("java:global/classes/FachadaDeSesion");
        Integer expResult = null;
        Integer result = instance.obtenerTaxi(idSolicitud);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enviarMensaje method, of class FachadaDeSesion.
     */
    @Test
    public void testEnviarMensaje() throws Exception {
        System.out.println("enviarMensaje");
        Integer idSolicitud = null;
        Integer idTaxi = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        FachadaDeSesion instance = (FachadaDeSesion)container.getContext().lookup("java:global/classes/FachadaDeSesion");
        boolean expResult = false;
        boolean result = instance.enviarMensaje(idSolicitud, idTaxi);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}