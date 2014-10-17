package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member_system.User;
import connect_database.SQL_SelectUser;
import connect_database.SelectUser;

/**
 * Servlet implementation class TestDatabase
 */
@WebServlet("/TestDatabase")
public class TestDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User("surapong", "123", "123456789", null);
		User temUser =null ;
		
		SelectUser selectUser = new SQL_SelectUser();
		ServletOutputStream out = response.getOutputStream();
		
		try 
		{
			temUser = selectUser.selectUser(user);
			System.out.print(temUser);
		}
		catch(Exception ex)
		{
			out.println(ex.getLocalizedMessage());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = new User("passakon", "123", "123456789", null);
		User temUser =null ;
		
		SelectUser selectUser = new SQL_SelectUser();
		ServletOutputStream out = response.getOutputStream();
		
		out.println("IN do post");
	
		try 
		{
			out.println(user.getUsername());
			temUser = selectUser.selectUser(user);
			
			if(temUser!=null)
			{
				out.println("Complete");
				out.println(temUser.getUsername());
				out.println(temUser.toString());
			}
			else
			{
				out.println("Error");
			}
					
			
			//System.out.print(temUser);
		}
		catch(Exception ex)
		{
			out.println(ex.toString());
			out.println(ex.getMessage());
			out.println(ex.getLocalizedMessage());
		}
		
		
	}

}
