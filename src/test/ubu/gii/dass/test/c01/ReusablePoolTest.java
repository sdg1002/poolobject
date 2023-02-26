/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {		  
		  pool1 = ReusablePool.getInstance();
		  // Tras la instanciación comprobamos que el valor no sea null
		  assertNotEquals(pool1, null);
		  // Seguros de que no vale null, comprobamos ahora que la creación haya sido correcta
		  assertTrue(pool1 instanceof ReusablePool);	  
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * 	
	 */
	@Test
	public void testAcquireReusable() {
		//fail("Not yet implemented");
		ReusablePool pool = ReusablePool.getInstance(); 
		//
		Reusable r1,r2,r3;
		try {
			r1 = pool.acquireReusable();
			r2 = pool.acquireReusable();
			r3 = pool.acquireReusable();
		}catch(Exception NotFreeInstanceException){
			System.out.println("Todo correcto");
		}
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 *
	 */
	@Test
	public void testReleaseReusable() {
		//fail("Not yet implemented");
		ReusablePool pool,pool2;
	    pool = ReusablePool.getInstance();
	    pool2 = ReusablePool.getInstance();
	    Reusable r1,r2;
	    try {
		    r1 = pool.acquireReusable();
			r2 = pool.acquireReusable();
	    }catch(Exception DuplicatedInstanceException){
	    	fail("Deberían existir más instancias");
	    }
	    try {
		    r1 = pool2.acquireReusable();
			r1 = pool2.acquireReusable();
		    }catch(Exception DuplicatedInstanceException){
		    	System.out.println("Todo correcto");
		    }
	}
}
