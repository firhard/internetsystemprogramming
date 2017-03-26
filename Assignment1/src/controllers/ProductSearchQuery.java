package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ProductsBean;
import models.QuestionsBean;
import models.ReviewBean;

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
		
		String search = request.getParameter("Search");
		int category = Integer.parseInt(request.getParameter("Category"));
		
		
		boolean emptyFields = false;
		
		if( search==null || search.trim().equals("") || search.trim().equals("Missing")) {
			emptyFields = true;
			search = "Missing";
	    } 
		
		session.setAttribute("search", search);
		session.setAttribute("category", category);
		
		@SuppressWarnings("unchecked")
		ArrayList<ProductsBean> ListName = (ArrayList<ProductsBean>)session.getAttribute("ListName");
		ArrayList<ReviewBean> ReviewList = new ArrayList<ReviewBean>();
		ArrayList<QuestionsBean> QuestionList = new ArrayList<QuestionsBean>();
		
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
			
			ArrayList<ProductsBean> prodBeanList = ProductsBean.findProductbyNameandCategory(search, category);
			ListName.addAll(prodBeanList);
			if(!prodBeanList.isEmpty()){
				ReviewList.addAll(ReviewBean.findReviewsbyProductID(prodBeanList.get(0).getId()));
				QuestionList.addAll(QuestionsBean.findQuesetionsbyProductId(prodBeanList.get(0).getId()));
				session.setAttribute("ReviewList", ReviewList);
				session.setAttribute("QuestionList", QuestionList);
			}

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
