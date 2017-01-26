

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fuserName = Utility.filter(request.getParameter("userName"));
		String fpassWord[] = (request.getParameterValues("passWord"));
		PrintWriter out = response.getWriter();

		if (Utility.is_blank(fuserName) || Utility.is_blank(fpassWord[0]) || Utility.is_blank(fpassWord[1])){
			out.println("You didn't specify the username and/or password");
		} else if(!fpassWord[0].equals(fpassWord[1])){
			out.println("\nPassword fields are different");
			out.println("\nFirst password: " + fpassWord[0]);
			out.println("\nSecond password: " + fpassWord[1]);
		} else if(Users.usernameTaken(fuserName)){
			out.println("\nThis username is already taken");
		} else{
			new Users(fuserName, fpassWord[0]);
			
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
