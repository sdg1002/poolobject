/**
* @author Ana Salces Mansilla
* @author Santiago Diaz Gome-Guillamon
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
 * 
 * @author Ana Salces Mansilla
 * 
 * @author Santiago Gomez Diaz-Guillamon
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

		assertEquals(r1, null);
		assertEquals(r2, null);
		assertEquals(r3, null);


		try {

			r1 = pool1.acquireReusable();
			r2 = pool1.acquireReusable();
			assertTrue(r1 instanceof Reusable);
			assertTrue(r2 instanceof Reusable);

		} catch (Exception NotFreeInstanceException) {
			fail("No se adquieren instancias correctamente");
		}

		try {
			r3 = pool1.acquireReusable();
		} catch (Exception NotFreeInstanceException) {
			System.out.print("Se realiza correctamente testAcquireReusable");
		}

	}

	@Test

	public void testReleaseReusable() {
		assertEquals(r1, null);
		assertEquals(r2, null);
		
		

		try {
			r1 = pool1.acquireReusable();			
			assertNotEquals(r1, null);
			assertTrue(r1 instanceof Reusable);
			pool1.releaseReusable(r1);

			r2 = pool1.acquireReusable();
			assertNotEquals(r2, null);
			assertTrue(r2 instanceof Reusable);
			pool1.releaseReusable(r2);

		} catch (Exception DuplicatedInstanceException) {
			fail("No se liberan elementos correctamente");
		}

		try {
			assertNotEquals(r1, null);
			pool1.releaseReusable(r1);

		} catch (Exception DuplicatedInstanceException) {
			System.out.println("Se realiza correctamente testReleaseReusable");
		}

	}

}
