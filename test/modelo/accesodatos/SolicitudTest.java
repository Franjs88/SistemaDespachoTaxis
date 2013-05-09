package modelo.accesodatos;

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
public class SolicitudTest {
    
    public SolicitudTest() {
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
     * Test of getIdSolicitud method, of class Solicitud.
     */
    @Test
    public void testGetIdSolicitud() {
        System.out.println("getIdSolicitud");
        Solicitud instance = new Solicitud();
        Integer expResult = null;
        Integer result = instance.getIdSolicitud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdSolicitud method, of class Solicitud.
     */
    @Test
    public void testSetIdSolicitud() {
        System.out.println("setIdSolicitud");
        Integer idSolicitud = null;
        Solicitud instance = new Solicitud();
        instance.setIdSolicitud(idSolicitud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreCliente method, of class Solicitud.
     */
    @Test
    public void testGetNombreCliente() {
        System.out.println("getNombreCliente");
        Solicitud instance = new Solicitud();
        String expResult = "";
        String result = instance.getNombreCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreCliente method, of class Solicitud.
     */
    @Test
    public void testSetNombreCliente() {
        System.out.println("setNombreCliente");
        String nombreCliente = "";
        Solicitud instance = new Solicitud();
        instance.setNombreCliente(nombreCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaSolicitud method, of class Solicitud.
     */
    @Test
    public void testGetFechaSolicitud() {
        System.out.println("getFechaSolicitud");
        Solicitud instance = new Solicitud();
        long expResult = 0L;
        long result = instance.getFechaSolicitud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaSolicitud method, of class Solicitud.
     */
    @Test
    public void testSetFechaSolicitud() {
        System.out.println("setFechaSolicitud");
        long fechaSolicitud = 0L;
        Solicitud instance = new Solicitud();
        instance.setFechaSolicitud(fechaSolicitud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccionDestino method, of class Solicitud.
     */
    @Test
    public void testGetDireccionDestino() {
        System.out.println("getDireccionDestino");
        Solicitud instance = new Solicitud();
        String expResult = "";
        String result = instance.getDireccionDestino();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccionDestino method, of class Solicitud.
     */
    @Test
    public void testSetDireccionDestino() {
        System.out.println("setDireccionDestino");
        String direccionDestino = "";
        Solicitud instance = new Solicitud();
        instance.setDireccionDestino(direccionDestino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class Solicitud.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Solicitud instance = new Solicitud();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class Solicitud.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Solicitud instance = new Solicitud();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaxiNumBastidor method, of class Solicitud.
     */
    @Test
    public void testGetTaxiNumBastidor() {
        System.out.println("getTaxiNumBastidor");
        Solicitud instance = new Solicitud();
        Taxi expResult = null;
        Taxi result = instance.getTaxiNumBastidor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaxiNumBastidor method, of class Solicitud.
     */
    @Test
    public void testSetTaxiNumBastidor() {
        System.out.println("setTaxiNumBastidor");
        Taxi taxiNumBastidor = null;
        Solicitud instance = new Solicitud();
        instance.setTaxiNumBastidor(taxiNumBastidor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Solicitud.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Solicitud instance = new Solicitud();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Solicitud.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Solicitud instance = new Solicitud();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Solicitud.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Solicitud instance = new Solicitud();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}