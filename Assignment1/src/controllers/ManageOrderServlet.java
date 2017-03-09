package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OrderItems;
import models.OrdersBean;

/**
 * Servlet implementation class ManageOrderServlet
 */
public class ManageOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    
		int orderID = Integer.parseInt(request.getParameter("view"));
		
		OrdersBean manageOrderBean = OrdersBean.findOrderbyId(orderID);
		session.setAttribute("manageOrderBean", manageOrderBean);
		
		ArrayList<OrderItems> orderItemsList = new ArrayList<OrderItems>();
		orderItemsList.addAll(OrderItems.findOrderItemsbyOrderId(orderID));
		session.setAttribute("orderItemsList", orderItemsList);

		String address = "ManageOrder.jsp";
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(address);
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
