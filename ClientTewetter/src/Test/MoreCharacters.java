package Test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Twitter;

import org.junit.Test;

public class MoreCharacters {

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
	//	fail("Not yet implemented");
		String message = "Facebook was created by Mark Zuckerberg. Neelima will create a company of hers and employ Rakshit Kota. I love Maria Sharapova. She is extremely beautiful and also a good tennis player. She will be playing Serena Williams tomorrow in the Wimbledon Quarter Finals. Maria Sharapova won her first Wimbledon in 2004 against Serena Williams at the age of 18. I also like Roger Federer; He has the best range of shots. Neelima loves her kids. She has two kids and they are twins named Aditya Vishwanath and Rudra Vishwanath. Lets interview Neelima about her intentions of joining Infosys: She wants to get rid of her housewife tag and boredom at home. She wants to be an independent woman. She drives a Mercedees Benz and she is extremely rash.adhasldhsaiohdsaioudghsaoihdsaoihdaiohsd";
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		
		try
		{
		
			Twitter testmessage = em.find(Twitter.class, (long)103);
			
			trans.begin();

			testmessage.setMessage(message);
			em.merge(testmessage);
	
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			trans.rollback();
		}
		finally
		{
			em.close();
		}
	}

}
