package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CookiesUtilities;
import models.LongLivedCookie;

/**
 * Servlet implementation class ClientAccessCount
 */
public class ClientAccessCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientAccessCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String countString = CookiesUtilities.getCookieValue(request,"accessCount","1");
		int count = 1;
		try {
			count = Integer.parseInt(countString); 
		} catch(NumberFormatException nfe) {
		} 
		LongLivedCookie c = new LongLivedCookie("accessCount", String.valueOf(count+1));
		session.setAttribute("countString", countString);
		session.setAttribute("c", c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
