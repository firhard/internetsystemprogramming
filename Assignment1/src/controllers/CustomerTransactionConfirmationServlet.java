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
	
	public void init() throws ServletException {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertCreditCard();
	}
       
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
		HttpSession session = request.getSession();
		
		String address = "CustomerTransactionConfirmation.jsp";
		//int Price = Integer.parseInt(request.getParameter("Price"));
		int Price = 55;
		int color = 1;
		String cHolderName = request.getParameter("CardHolderName");
		String cType = request.getParameter("CardType");
		String cNumber = request.getParameter("CardNumber");
		String sCode = request.getParameter("SecurityCode");
		String eDate = request.getParameter("ExpirationDate");
		String billingAddress = request.getParameter("BillingAddress");
		String checkingAddress = request.getParameter("CheckingAddress");
		boolean transactionValue = TransactionsBean.verifyCreditCard(cHolderName, cType, cNumber, sCode, eDate);
		
		session.setAttribute("transactionValue", transactionValue);
		
		double AvailableBalance = TransactionsBean.availableBalance(cHolderName);
		if(transactionValue == false){
			color = 0;
		}
		
		if(AvailableBalance < Price && transactionValue == true){
			color = 2;
		}
		
		if(transactionValue == true){
			double deductCredit = TransactionsBean.deductCredit(Price, cNumber, sCode);
			System.out.println(deductCredit);
			session.setAttribute("deductCredit", deductCredit);
		}
		session.setAttribute("color", color);
		session.setAttribute("price", Price);
		session.setAttribute("cardHolderName", cHolderName);
		session.setAttribute("sCode", sCode);
		session.setAttribute("eDate", eDate);
		session.setAttribute("cNumber", cNumber);
		session.setAttribute("checkingAddress", checkingAddress);
		session.setAttribute("billingAddress", billingAddress);
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
