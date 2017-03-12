package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DBAccessClass;
import models.Users;
import models.Utility;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public void init() throws ServletException {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertUsers();
		db.insertProducts();
		db.insertOrders();
		db.insertCreditCard();
		db.insertOrderItems();
	}
	
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
				if (Users.validateUser(fuserName, fpassWord)) {			
				    HttpSession session=request.getSession();
				    session.setAttribute("fuserName", fuserName);
				    session.setAttribute("loggedInUser", Users.userInfo(fuserName,fpassWord));
					session.setAttribute("isUserLoggedIn",true);
				    response.sendRedirect("CustomerHomePage.jsp"); // Link-redirection
					
				} else {
					response.sendRedirect("Registration.jsp"); // Link-redirection
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
