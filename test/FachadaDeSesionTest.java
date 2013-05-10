

import javax.ejb.embeddable.EJBContainer;
import modelo.logicanegocio.FachadaDeSesion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.naming.Context;

/**
 *
 * @author fran
 */
public class FachadaDeSesionTest {
     private static EJBContainer ejbContainer;
        private static Context ctx; 
    
    public FachadaDeSesionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ejbContainer = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        System.out.println("Starting the container");
        ctx = ejbContainer.getContext();
        //org.objectweb.asm.ClassReader
    }
    
    @AfterClass
    public static void tearDownClass() {
        ejbContainer.close();
         System.out.println("Closing the container");
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
        FachadaDeSesion  fachadaDeSesion = (FachadaDeSesion)ctx.lookup("java:global/classes/FachadaDeSesion");
        assertEquals(1, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}