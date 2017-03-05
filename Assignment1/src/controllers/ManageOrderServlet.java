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
import models.ProductsBean;

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
		
	    OrdersBean manageOrderBean =
	      (OrdersBean)session.getAttribute("manageOrderBean");
	    
	    if (manageOrderBean == null) {		    
			manageOrderBean = new OrdersBean();
			session.setAttribute("manageOrderBean", manageOrderBean);
	    }
	    
		manageOrderBean = OrdersBean.findOrderbyId(orderID);
		//TODO: Implement findOrderbyId
		
		ArrayList<ProductsBean> prodOrderList = (ArrayList<ProductsBean>)session.getAttribute("prodOrderList");
				
		if (prodOrderList == null || prodOrderList.isEmpty()){
			prodOrderList = new ArrayList<ProductsBean>();
			session.setAttribute("prodOrderList", prodOrderList);
		}
		else {
			prodOrderList.clear();
		}
		
		prodOrderList.addAll(ProductsBean.findbyOrderId);
		


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
