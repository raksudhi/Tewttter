package model;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displayPost
 */
@WebServlet("/displayPost")
public class displayPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayPost() {
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
		
		List<Twitter> twitter = getMessageAndName();
		
		
		
		try
		{
			
		
			
			int numberOfElements = twitter.size();
			System.out.println(numberOfElements);
			
			
			request.setAttribute("twitter", twitter);
	
		}
		catch(Exception e)
		{
			request.setAttribute("message", "<div class='alert alert-danger' role='alert'>Error! Danger Will Robinson Danger! " + e + "</div>");
		}
		
		
		
		
		getServletContext()
		.getRequestDispatcher("/firstdisplay.jsp")
		.forward(request, response);
	}

	
	protected static List<Twitter> getMessageAndName()
	{
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p FROM  Twitter p order by p.postdate desc";
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
		System.out.println(i);
		
		return i;
	}
	
}
