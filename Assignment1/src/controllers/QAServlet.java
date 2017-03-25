package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.QuestionsBean;
import models.Users;

/**
 * Servlet implementation class QAServlet
 */
public class QAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
    	String fQuestion = request.getParameter("QuestionSend");
    	int fProductId = Integer.parseInt(request.getParameter("ProductIdSend"));
    	QuestionsBean addQuestion = new QuestionsBean();
    	
	    Users aUser = (Users)session.getAttribute("loggedInUser");
	    int user_id = 0;
	    if(aUser != null){
	    	user_id = aUser.getId();
	    }
	    addQuestion.setId((int)(Math.random()*1000000));
    	addQuestion.setProductId(fProductId);
    	addQuestion.setCustomerId(user_id);
    	addQuestion.setQuestion(fQuestion);
    	addQuestion.setAnswer(null);
    	
    	QuestionsBean.addQuestion(addQuestion);
    	

		@SuppressWarnings("unchecked")
		ArrayList<QuestionsBean> QuestionList = (ArrayList<QuestionsBean>)session.getAttribute("QuestionList");
		if (QuestionList == null || QuestionList.isEmpty()){
			QuestionList = new ArrayList<QuestionsBean>();
			session.setAttribute("QuestionList", QuestionList);
		}
		QuestionList.add(addQuestion);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
