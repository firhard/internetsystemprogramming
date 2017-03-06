package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OrderItems;

/**
 * Servlet implementation class CancleOrderServlet
 */
public class CancleOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancleOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int orderItemsId = Integer.parseInt(request.getParameter("orderItemsId"));
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		OrderItems orderItem = (OrderItems)session.getAttribute("orderItem");
		String address = "CancelOrder.jsp";
		
		if(orderItem == null){
			orderItem = OrderItems.findOrderItembyOrderItemId(orderItemsId);
		}
		
		orderItem = OrderItems.findOrderItembyOrderItemId(orderItemsId);
		
		session.setAttribute("orderItemsId", orderItemsId);
		session.setAttribute("orderId", orderId);
		
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
