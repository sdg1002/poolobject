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
 * @author Ana Salces Mansilla
 * @author Santiago Diaz Gomez-Guillamon
 *
 */
public class ReusablePoolTest {
	
	ReusablePool pool1 = null;
	Reusable r1, r2, r3 = null;

	/**
	 * 
	 * @throws java.lang.Exception
	 * 
	 */

	@Before

	public void setUp() throws Exception {
		pool1 = ReusablePool.getInstance();

	}

	/**
	 * 
	 * @throws java.lang.Exception
	 * 
	 */

	@After

	public void tearDown() throws Exception {
		pool1 = null;
		r1 = null;
		r2 = null;
		r3 = null;

	}
	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 * 
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
	 * 
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * 
	 * @throws NotFreeInstanceException
	 * 
	 */

	@Test

	public void testAcquireReusable() {

		r1 = null;
		r2 = null;
		r3 = null;

		assertEquals(r1, null);
		assertEquals(r2, null);
		assertEquals(r3, null);

		try {
			r1 = pool1.acquireReusable();
			r2 = pool1.acquireReusable();
			assertTrue(r1 instanceof Reusable);
			assertTrue(r2 instanceof Reusable);

		} catch (Exception NotFreeInstanceException) {
			fail(" No se adquieren correctamente los reutilizables");
		}

		try {
			r3 = pool1.acquireReusable();
		} catch (Exception NotFreeInstanceException) {
			System.out.print(" Test AcquireReusable se realiza correctamente");
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
		    	System.out.println("Test ReleaseReusable se realiza correctamente");
		    }
	}
}
