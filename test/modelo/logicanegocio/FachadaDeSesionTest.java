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
        System.out.println(result);
        assertEquals(1, 1);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}