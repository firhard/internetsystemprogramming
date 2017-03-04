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
import models.Users;

/**
 * Servlet implementation class ProductSearchQuery
 */
public class ProductSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init() throws ServletException {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.insertProducts();
	}
	
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
		
		HttpSession session = request.getSession();
		
		String search = request.getParameter("Search");
		int category = Integer.parseInt(request.getParameter("Category"));
		
		
		boolean emptyFields = false;
		
		if( search==null || search.trim().equals("") || search.trim().equals("Missing")) {
			emptyFields = true;
			search = "Missing";
	    } 
		
		session.setAttribute("search", search);
		
		@SuppressWarnings("unchecked")
		ArrayList<ProductsBean> ListName = (ArrayList<ProductsBean>)session.getAttribute("ListName");
		
		String address = "ProductSearchResults.jsp";
		if(emptyFields == true){
		 address = "CustomerHomePage.jsp";
		} else {
			
			if (ListName == null || ListName.isEmpty()){
				ListName = new ArrayList<ProductsBean>();
				session.setAttribute("ListName", ListName);
			}
			else {
				ListName.clear();
			}
			
			ListName.addAll(ProductsBean.findProductbyNameandCategory(search, category));

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
