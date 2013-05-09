package modelo.accesodatos;

import java.util.Collection;
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
public class TaxiTest {
    
    public TaxiTest() {
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
     * Test of getNumBastidor method, of class Taxi.
     */
    @Test
    public void testGetNumBastidor() {
        System.out.println("getNumBastidor");
        Taxi instance = new Taxi();
        Integer expResult = null;
        Integer result = instance.getNumBastidor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumBastidor method, of class Taxi.
     */
    @Test
    public void testSetNumBastidor() {
        System.out.println("setNumBastidor");
        Integer numBastidor = null;
        Taxi instance = new Taxi();
        instance.setNumBastidor(numBastidor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Taxi.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Taxi instance = new Taxi();
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Taxi.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Taxi instance = new Taxi();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUbicacion method, of class Taxi.
     */
    @Test
    public void testGetUbicacion() {
        System.out.println("getUbicacion");
        Taxi instance = new Taxi();
        String expResult = "";
        String result = instance.getUbicacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUbicacion method, of class Taxi.
     */
    @Test
    public void testSetUbicacion() {
        System.out.println("setUbicacion");
        String ubicacion = "";
        Taxi instance = new Taxi();
        instance.setUbicacion(ubicacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDestino method, of class Taxi.
     */
    @Test
    public void testGetDestino() {
        System.out.println("getDestino");
        Taxi instance = new Taxi();
        String expResult = "";
        String result = instance.getDestino();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDestino method, of class Taxi.
     */
    @Test
    public void testSetDestino() {
        System.out.println("setDestino");
        String destino = "";
        Taxi instance = new Taxi();
        instance.setDestino(destino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSolicitudCollection method, of class Taxi.
     */
    @Test
    public void testGetSolicitudCollection() {
        System.out.println("getSolicitudCollection");
        Taxi instance = new Taxi();
        Collection expResult = null;
        Collection result = instance.getSolicitudCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSolicitudCollection method, of class Taxi.
     */
    @Test
    public void testSetSolicitudCollection() {
        System.out.println("setSolicitudCollection");
        Collection<Solicitud> solicitudCollection = null;
        Taxi instance = new Taxi();
        instance.setSolicitudCollection(solicitudCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Taxi.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Taxi instance = new Taxi();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Taxi.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Taxi instance = new Taxi();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Taxi.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Taxi instance = new Taxi();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}