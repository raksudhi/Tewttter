package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
//import com.sun.jmx.snmp.Timestamp;


import model.Twitter;
/**
 * Servlet implementation class postMessage
 */
@WebServlet("/postMessage")
public class postMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("employeename");
		
		String message = request.getParameter("message");
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		
		//System.out.println("Hello World");
		try
		{
			Date date= new Date();
			Timestamp postdate = new Timestamp(date.getTime());
			//Timestamp postdate = new Timestamp(date.getTime());
			model.Twitter messagingService= new model.Twitter();
		//	System.out.println("Hello World");
			messagingService.setName(name);
			messagingService.setMessage(message);
			messagingService.setPostdate(postdate);
			 
			em.persist(messagingService);
			
			trans.commit();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			trans.rollback();
		}
		finally
		{
			em.close();
		}
		
		
		List<Twitter> twitter = getMessageAndName();
		
		request.setAttribute("twitter", twitter);
		
		getServletContext()
		.getRequestDispatcher("/displayPost")
		.forward(request, response);
		
	}
	
	
	protected static List<Twitter> getMessageAndName()
	{
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p FROM  Twitter p";
		TypedQuery<Twitter> q = em.createQuery(qString, Twitter.class);
	//	q.setParameter("prodID", Long.parseLong(prodID));
		List<Twitter> i = null;
		try
		{
		
			i = q.getResultList();
			if(i == null || i.isEmpty())
			{
				i = null;
			}
		}
		catch(NoResultException e)
		{
			System.out.println(e);
		}
		
		finally 
		{
			em.close();
		}
	//	System.out.println(i);
		
		return i;
	}
	
	
	

}
