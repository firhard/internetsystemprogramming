package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax. servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		ProductsBean productsBean = new ProductsBean();
		String search = request.getParameter("Search");
		if((search!=null) && (!search.trim().equals(""))) {
	      	productsBean.setProductName(search);
	    }
		ArrayList<ProductsBean> ListName = (ArrayList<ProductsBean>)session.getAttribute("ListName");
		if (ListName == null){
			ListName = new ArrayList<ProductsBean>();
			session.setAttribute("ListName", ListName);
		}
		ListName.add(productsBean);
	    String address = "ProductSearchResults.jsp";
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
