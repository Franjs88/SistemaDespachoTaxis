package modelo.logicanegocio;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
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
public class FachadaDeSesionTest {@BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private FachadaDeSesion instance;
    
    @Before
    public void setUp() {
        
        instance = new FachadaDeSesion();
//        instance.em = mock(EntityManager.class);
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
        
//        List expResult = null;
//        List result = instance.consultaListaTaxis();
//        System.out.println(result);
//        System.out.println("container" + container);
//        assertEquals(1, 1);
//        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}