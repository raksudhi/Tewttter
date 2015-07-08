package model;

import java.io.IOException;
import java.sql.Timestamp;
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

/**
 * Servlet implementation class newPostMessage
 */
@WebServlet("/newPostMessage")
public class newPostMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newPostMessage() {
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
		
		String tableInfo_1 = " ";
		String tableInfo_2 = " ";
		//System.out.println("Hello World");
		try
		{
			
			System.out.println(twitter.get(0).getName());
		
			tableInfo_1 = "Name: " + twitter.get(0).getName();
			tableInfo_2 = "Post: # " + twitter.get(0).getMessage() + " # ";
			
			request.setAttribute("tableInfo1", tableInfo_1);
			request.setAttribute("tableInfo2", tableInfo_2);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		getServletContext()
		.getRequestDispatcher("/newPostDisplay.jsp")
		.forward(request, response);
	}
	
	protected static List<Twitter> getMessageAndName()
	{
		
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT p FROM  Twitter p  order by p.slid desc";
		TypedQuery<Twitter> q = em.createQuery(qString, Twitter.class);
	
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

		
		return i;
	}

}
