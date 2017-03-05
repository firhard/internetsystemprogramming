package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.DBAccessClass;
import models.ProductsBean;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertProducts();
	    HttpSession session = request.getSession();
	    
  
	    ProductsBean prodBean =
	      (ProductsBean)session.getAttribute("prodBean");
	    
	    int Price = prodBean.getPrice(); 
	    		//Integer.parseInt(request.getParameter()));
	    int ProductQuantity = Integer.parseInt(request.getParameter("ProductQuantity"));
	    
	    int overallPrice = Price * ProductQuantity;
	  
	    
	    String address = "View&CheckoutShoppingCart.jsp";
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
