package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ReviewBean;
import models.Users;

/**
 * Servlet implementation class CustomerReviewServlet
 */
public class CustomerReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
    	String fReview = request.getParameter("ReviewSend");
    	Byte fRating = Byte.parseByte(request.getParameter("RatingSend"));
    	int fProductId = Integer.parseInt(request.getParameter("ProductIdSend"));
    	ReviewBean addReview = new ReviewBean();
    	
	    Users aUser = (Users)session.getAttribute("loggedInUser");
	    SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
	    Calendar c = Calendar.getInstance();        
	    String date = (String)(formattedDate.format(c.getTime()));
	    int user_id = 0;
	    if(aUser != null){
	    	user_id = aUser.getId();
	    }
	    
	    addReview.setId((int)(Math.random()*1000000));
    	addReview.setProductId(fProductId);
    	addReview.setCustomerId(user_id);
    	addReview.setReviewDate(date);
    	addReview.setRating(fRating);
    	addReview.setReview(fReview);
    	
    	ReviewBean.addReview(addReview);
    	
		@SuppressWarnings("unchecked")
		ArrayList<ReviewBean> ReviewList = (ArrayList<ReviewBean>)session.getAttribute("ReviewList");
		if (ReviewList == null || ReviewList.isEmpty()){
			ReviewList = new ArrayList<ReviewBean>();
			session.setAttribute("ReviewList", ReviewList);
		}
		ReviewList.add(addReview);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
