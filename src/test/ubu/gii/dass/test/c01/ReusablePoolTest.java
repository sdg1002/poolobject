/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
		  ReusablePool pool;
		  pool = ReusablePool.getInstance();
		  assertNotEquals(pool, null);
		  
	}

     	/ ** Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
     	 *
    	 */
	@Test
	public void testAcquireReusable() {

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

