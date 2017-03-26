package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TransactionsBean;

/**
 * Servlet implementation class BankServlet
 */
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int color = 1;
		String cHolderName = request.getParameter("CardHolderName");
		String cType = request.getParameter("CardType");
		String cNumber = request.getParameter("CardNumber");
		String sCode = request.getParameter("SecurityCode");
		String eDate = request.getParameter("ExpirationDate");
		int Price = Integer.parseInt(request.getParameter("TotalPrice"));
		boolean transactionValue = TransactionsBean.verifyCreditCard(cHolderName, cType, cNumber, sCode, eDate);
		
		double AvailableBalance = TransactionsBean.availableBalance(cHolderName);
		if(transactionValue == false){
			color = 0;
		}
		
		if(AvailableBalance < Price && transactionValue == true){
			color = 2;
		}
		
		if(transactionValue == true && color!=2){
			TransactionsBean.deductCredit(Price, cNumber, sCode);
			color = 3;
		}

	    PrintWriter out = response.getWriter(); 
		out.println(color);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
