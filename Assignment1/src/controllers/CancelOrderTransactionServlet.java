package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OrderItems;
import models.TransactionsBean;

/**
 * Servlet implementation class CancelOrderTransactionServlet
 */
public class CancelOrderTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrderTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		int OrderItemId = Integer.parseInt(request.getParameter("ConfirmSubmit"));
		int cancelNumber = 1;
		double ProductPrice = Integer.parseInt(request.getParameter(OrderItems.getProductPrice()));
//		OrderItems orderItems = ;
//		session.setAttribute(, arg1);
		
		OrderItems dropNumber = OrderItems.dropOrderItembyOrderItemId(OrderItemId);
		double addCredit = TransactionsBean.addCreditafterCancellation(ProductPrice, OrderItemId);
		String address = "CancellationConfirmation.jsp";
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
