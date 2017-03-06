package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ProductsBean;


/**
 * Servlet implementation class ProductSearchResultsServlet
 */
public class ProductSearchResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchResultsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    HttpSession session = request.getSession();
	    
		int productID = Integer.parseInt(request.getParameter("insert"));
		
		
	    ProductsBean prodBean = (ProductsBean)session.getAttribute("prodBean");
	    
	    if (prodBean == null) {		    
			prodBean = ProductsBean.findProductbyId(productID);
	    }

		prodBean = ProductsBean.findProductbyId(productID);
		System.out.println(prodBean.getEstimatedDeliveryDays());
		session.setAttribute("prodBean", prodBean);
		String address = "ViewProductDetails.jsp";
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
