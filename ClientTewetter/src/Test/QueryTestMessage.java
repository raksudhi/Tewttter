package Test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import mytools.DBUtil;
import model.Twitter;

public class QueryTestMessage {

	@Test
	public void testGetMessageAndName() {
		//fail("Not yet implemented");
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
				Twitter message = em.find(Twitter.class, (long)103);
				assertEquals(message.getMessage(), "Infosys");
			}
			catch(Exception e)
			{
				fail(e.getMessage());
			} finally
			{
				em.close();
				
			}
	}

}
