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
import models.ProductsBean;

/**
 * Servlet implementation class ProductSearchQuery
 */
public class ProductSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertProducts();
		HttpSession session = request.getSession();
		
		ProductsBean productsBean = (ProductsBean)session.getAttribute("productsBean");
		String search = request.getParameter("Search");
		
		boolean emptyFields = true;
		
		if((search!=null) && (!search.trim().equals(""))) {
			emptyFields = false;
	    } 

		
		ArrayList<ProductsBean> ListName = (ArrayList<ProductsBean>)session.getAttribute("ListName");
		if (ListName == null){
			ListName = new ArrayList<ProductsBean>();
			session.setAttribute("ListName", ListName);
		}
		
		ListName = ProductsBean.search(search);
		String address = "ProductSearchResults.jsp";
		if(emptyFields == true){
		 address = "CustomerHomePage.jsp";
		}
		
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
