

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fuserName = Utility.filter(request.getParameter("userName"));
		String fpassWord = Utility.filter(request.getParameter("passWord"));
		PrintWriter out = response.getWriter();
		
		if (Utility.is_blank(fuserName)) {
			out.println("You didn't specify a username");
		} else if (Utility.is_blank(fpassWord)) {
			out.println("You didn't specify a password");
		} else {
			if (Users.userExist(fuserName, fpassWord)) {		
			
				response.sendRedirect("CustomerHomePage.jsp");
			}
			else{
				response.sendRedirect("Registration.jsp");
			}
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
