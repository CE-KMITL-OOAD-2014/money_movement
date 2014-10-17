package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member_system.Profile;
import member_system.RegisterManager;
import member_system.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = (String)request.getParameter("username");
		String email = (String)request.getParameter("email");
		String password = (String)request.getParameter("password");
		String confirmPassword = (String)request.getParameter("confirmPassword");	
		String name = (String)request.getParameter("name");
		boolean check = false;
		
		if(name==null)
		{
			RequestDispatcher dis = request.getRequestDispatcher("adddetailLogup.jsp");
			dis.forward(request, response);
			return ;
		}	
		else
		{
			String age = (String)request.getParameter("age");
			String birthDay = (String)(request.getParameter("birthDay"));
			String inlineRadioOptions =(String)(request.getParameter("inlineRadioOptions"));
			String job = (String)(request.getParameter("job"));
			String province = (String)(request.getParameter("province"));
			
			
			Profile profile = new Profile(name, Integer.parseInt(age) , job, inlineRadioOptions, email, province);
			User user = new User(username, password, null,profile);
			//ServletOutputStream out = response.getOutputStream();
			
			try
			{
				String resultMessage;
				RegisterManager register = new RegisterManager();
				if( register.register(user)!=null)
				{
					resultMessage = "Complete Register";
				}
				else
				{
					resultMessage = "Error";
				}
				//out.println(resultMessage);
				
				request.setAttribute("result",resultMessage);
				RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
				dis.forward(request, response);
			}
			catch(Exception ex)
			{
				String errorMessage = ex.toString() + ex.getMessage() + ex.getLocalizedMessage();
				request.setAttribute("result",errorMessage);
			//	out.println(errorMessage);
				RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
				dis.forward(request, response);
				
			}
		}
	}

}
