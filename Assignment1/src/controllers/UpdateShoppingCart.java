package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    
		ArrayList<ProductsBean> ShoppingCart = (ArrayList<ProductsBean>)session.getAttribute("ShoppingCart");
		if(ShoppingCart == null){
		    ShoppingCart = new ArrayList<ProductsBean>();
		    session.setAttribute("ShoppingCart", ShoppingCart);
		}
		
		ArrayList<Integer> RequestedQuantityList = (ArrayList<Integer>)session.getAttribute("RequestedQuantityList");
		if(RequestedQuantityList == null){
			RequestedQuantityList = new ArrayList<Integer>();
			session.setAttribute("RequestedQuantityList", RequestedQuantityList);
		}
		
		ArrayList<Integer> TotalsList = (ArrayList<Integer>)session.getAttribute("TotalsList");
		if(TotalsList == null){
			TotalsList = new ArrayList<Integer>();
			session.setAttribute("TotalsList", TotalsList);
		}
		
		ArrayList<String> DateList = (ArrayList<String>)session.getAttribute("DateList");
		if(DateList == null){
			DateList = new ArrayList<String>();
			session.setAttribute("DateList", DateList);
		}
		//HashMap<Integer, Integer> QuantityPerProduct
		
	    ProductsBean prodBean = (ProductsBean)session.getAttribute("prodBean");
		
	    int RequestedQuantity = 0;
	    int AvailableQuantity = 0;
	    int removeProductIndex = -1;

	    boolean newBean = true;
	    if(request.getParameter("remove") != null)
	    {
		    removeProductIndex = Integer.parseInt(request.getParameter("remove"));
	    } else if(RequestedQuantity == 0){
	    	RequestedQuantity = Integer.parseInt(request.getParameter("ProductQuantity"));
		    AvailableQuantity = prodBean.getAvailableQuantity();
		    
		    for (int i=0; i<ShoppingCart.size(); i++) {
			    if(prodBean.getId() == ShoppingCart.get(i).getId()){
			    	RequestedQuantity += RequestedQuantityList.get(i);
				    if (RequestedQuantity <= AvailableQuantity){
				    	RequestedQuantityList.set(i, RequestedQuantity);
					    TotalsList.set(i, RequestedQuantity*prodBean.getPrice());
				    	newBean = false;
				    }
			    }

		    }
	    }

	    session.setAttribute("RequestedQuantity", RequestedQuantity);
	    
	    String address = "View&CheckoutShoppingCart.jsp";
	    
	    if(removeProductIndex != -1){
	    	ShoppingCart.remove(removeProductIndex);
			TotalsList.remove(removeProductIndex);
			RequestedQuantityList.remove(removeProductIndex);
			System.out.println("Got here");
		    int total = 0;
		    for (Integer temp : TotalsList) {
		    	   total = total + temp;
		    }
		     
			session.setAttribute("TotalPrice", total);
	    } else if (RequestedQuantity > AvailableQuantity || RequestedQuantity == 0){
		    	address = "ViewProductDetails.jsp";	
	    } else if(newBean == false){
	    	
		    int total = 0;
		    for (Integer temp : TotalsList) {
		    	   total = total + temp;
		    }
		    
			session.setAttribute("TotalPrice", total);

	    } else{
	    
		    SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
		    Calendar c = Calendar.getInstance();        
		    c.add(Calendar.DATE, prodBean.getEstimatedDeliveryDays());    
		    String EstimatedDeliveryTime = (String)(formattedDate.format(c.getTime()));
		    
		    DateList.add(EstimatedDeliveryTime);
		    ShoppingCart.add(prodBean);
		    TotalsList.add(RequestedQuantity*prodBean.getPrice());
		    RequestedQuantityList.add(RequestedQuantity);

		    int total = 0;
		    for (Integer temp : TotalsList) {
		    	   total = total + temp;
		    }
		    
			session.setAttribute("TotalPrice", total);
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
