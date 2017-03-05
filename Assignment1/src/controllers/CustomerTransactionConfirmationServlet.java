package controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DBAccessClass;
import models.TransactionsBean;

/**
 * Servlet implementation class CustomerTransactionConfirmationServlet
 */
public class CustomerTransactionConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertProducts();
		HttpSession session = request.getSession();
		String address = "CustomerTransactionConfirmation.jsp";
		int Price = Integer.parseInt(request.getParameter("Price"));
		String cHolderName = request.getParameter("CardHolderName");
		String cType = request.getParameter("CardType");
		String cNumber = request.getParameter("CardNumber");
		String sCode = request.getParameter("SecurityCode");
		DateFormat formatter = new SimpleDateFormat("MM-yyyy");
		Date eDate = null;
		try {
			eDate = formatter.parse(request.getParameter("ExpirationDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		boolean transactionValue = TransactionsBean.verifyCreditCard(cHolderName, cType, cNumber, sCode, eDate);
		
		session.setAttribute("transactionValue", transactionValue);
		
		double AvailableBalance = TransactionsBean.availableBalance(cHolderName);
		if (AvailableBalance < Price){
			
		}
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
