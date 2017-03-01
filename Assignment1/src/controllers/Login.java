package controllers;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Users;
import models.Utility;

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
		
		
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
			
			if (Utility.is_blank(fuserName)) {
				out.println("You didn't specify a username");
			} else if (Utility.is_blank(fpassWord)) {
				out.println("You didn't specify a password");
			} else {
				// Check whether the username exists or not
				if (!Users.validateUser(fuserName, propFilePath)) {			
					// Link-redirection
					response.sendRedirect("Registration.jsp");
				} else { // Check whether the password matches or not
					String pword = p.getProperty(fuserName);  
					if(!pword.equals(fpassWord)) {
						response.sendRedirect("Registration.jsp"); // Link-redirection
					} else {
					    HttpSession session=request.getSession();  
					    session.setAttribute("fuserName", fuserName); 
						response.sendRedirect("CustomerHomePage.jsp"); // Link-redirection
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
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
