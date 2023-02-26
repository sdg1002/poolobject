/**
* @author Ana Salces Mansilla
* @author Santiago Diaz Gomez-Guillamon
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
 * Test de pruebas sobre la clase ReusablePool
 *
 * @author Ana Salces Mansilla
 * @author Santiago Gomez Diaz-Guillamon
 * 
 */

public class ReusablePoolTest {

	/**
	*Variales globales para el uso de los test
	*/
	ReusablePool pool1 = null;
	Reusable r1, r2, r3 = null;

	/**
	 * Metodo que se ejecuta antes de cada test, instanciando la variable pool1
	 * @throws java.lang.Exception
	 * 
	 */

	@Before
	public void setUp() throws Exception {
		pool1 = ReusablePool.getInstance();

	}

	/**
	 * Metodo que se ejecuta después de cada test, vacia todas las variables
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

		//comprueba que todas las variables estan a null
		assertEquals(r1, null);
		assertEquals(r2, null);
		assertEquals(r3, null);


		// comprueba que los objetos r1 y r2 son de tipo Reusable, si no es así, salta una exception
		try {

			r1 = pool1.acquireReusable();
			r2 = pool1.acquireReusable();
			assertTrue(r1 instanceof Reusable);
			assertTrue(r2 instanceof Reusable);

		} catch (Exception NotFreeInstanceException) {
			fail("No se adquieren instancias correctamente");
		}
		//Comrpueba que r3 no ha podido adquirir reusable para después añadir un mensaje de error
		try {
			r3 = pool1.acquireReusable();
		} catch (Exception NotFreeInstanceException) {
			System.out.print("Se realiza correctamente testAcquireReusable");
		}

	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#ReleaseReusable()}.
	 * 
	 */
	@Test
	public void testReleaseReusable() {
		//se comprueba que las variables estan a null
		assertEquals(r1, null);
		assertEquals(r2, null);
		
		//comprueba que r1 y r2 sea de tipo reusable y no nulo, , si no es así, salta una exception
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
		
		// comprueba que r1 no esta a nulo y que al hacer un nuevo "releaseReusable", esto resulta en que esta duplicado
		try {
			assertNotEquals(r1, null);
			pool1.releaseReusable(r1);

		} catch (Exception DuplicatedInstanceException) {
			System.out.println("Se realiza correctamente testReleaseReusable");
		}

	}

}
