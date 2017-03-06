package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DBAccessClass;
import models.OrderItems;
import models.ProductsBean;
import models.Users;

/**
 * Servlet implementation class UpdateShoppingCart
 */
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    
		ArrayList<ProductsBean> ShoppingCart = (ArrayList<ProductsBean>)session.getAttribute("ShoppingCart");
		if(ShoppingCart == null){
		    ShoppingCart = new ArrayList<ProductsBean>();
		    session.setAttribute("ShoppingCart", ShoppingCart);
		}
		
	    ProductsBean prodBean =
	      (ProductsBean)session.getAttribute("prodBean");
	    
	    int RequestedQuantity = Integer.parseInt(request.getParameter("ProductQuantity"));
	    String address = "View&CheckoutShoppingCart.jsp";
	    int AvailableQuantity = prodBean.getAvailableQuantity();
	    session.setAttribute("RequestedQuantity", RequestedQuantity);
	    session.setAttribute("AvailableQuantity", AvailableQuantity);
	    if (RequestedQuantity > AvailableQuantity){
	    	address = "ViewProductDetails.jsp";
	    }
	    
	    ShoppingCart.add(prodBean);
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
