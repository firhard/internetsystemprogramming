package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DBAccessClass;
import models.OrdersBean;
import models.Users;

/**
 * Servlet implementation class ViewOrdersServlet
 */
public class ViewOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertOrders();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<OrdersBean> OrdersList = (ArrayList<OrdersBean>)session.getAttribute("OrdersList");
		
		if (OrdersList == null || OrdersList.isEmpty()){
			OrdersList = new ArrayList<OrdersBean>();
			session.setAttribute("OrdersList", OrdersList);
		}
		
	    Users aUser = (Users)session.getAttribute("loggedInUser");
	    System.out.println(aUser.getId());
		OrdersList.addAll(OrdersBean.findOrderbyCustomerId(aUser.getId()));
		System.out.println(OrdersList.get(0).getId());
			
		String address = "ViewOrders.jsp";
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
