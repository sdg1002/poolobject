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
	 * 	public static ReusablePool getInstance(){
		if (instance == null)
			instance = new ReusablePool(2);
		return instance; 
	}
	 */
	@Test
	public void testGetInstance() {
		//fail("Not yet implemented");
		  ReusablePool pool;
		  pool = ReusablePool.getInstance();
		  assertNotEquals(pool, null);
		  }

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 * 	public Reusable acquireReusable() throws NotFreeInstanceException{
		if (reusables.size()>0){
			Reusable r=(Reusable)reusables.lastElement();
			reusables.remove(r);
			return r;			
		}
		else{
			throw(new NotFreeInstanceException());
		}

	}
	 */
	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 	
	 	public void releaseReusable(Reusable r) throws DuplicatedInstanceException {
		if (reusables.contains(r)==false){
			reusables.add(r);
		}
		else{
			throw(new DuplicatedInstanceException());
		}
	}
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
