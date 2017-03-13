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
import models.OrderItems;
import models.OrdersBean;
import models.ProductsBean;
import models.TransactionsBean;
import models.Users;

/**
 * Servlet implementation class CustomerTransactionConfirmationServlet
 */
public class CustomerTransactionConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionConfirmationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	
		String address = "CustomerTransactionConfirmation.jsp";
		int Price = (Integer)session.getAttribute("TotalPrice");
		@SuppressWarnings("unchecked")
		ArrayList<Integer> requestedQuantity = (ArrayList<Integer>)session.getAttribute("RequestedQuantityList");
		@SuppressWarnings("unchecked")
		ArrayList<ProductsBean> Products = (ArrayList<ProductsBean>)session.getAttribute("ShoppingCart");
		int color = 1;
		String cHolderName = request.getParameter("CardHolderName");
		String cType = request.getParameter("CardType");
		String cNumber = request.getParameter("CardNumber");
		String sCode = request.getParameter("SecurityCode");
		String eDate = request.getParameter("ExpirationDate");
		String billingAddress = request.getParameter("BillingAddress");
		String shippingAddress = request.getParameter("ShippingAddress");
		boolean transactionValue = TransactionsBean.verifyCreditCard(cHolderName, cType, cNumber, sCode, eDate);
		session.setAttribute("transactionValue", transactionValue);
		
		double AvailableBalance = TransactionsBean.availableBalance(cHolderName);
		if(transactionValue == false){
			color = 0;
		}
		
		if(AvailableBalance < Price && transactionValue == true){
			color = 2;
		}
		
		if(transactionValue == true && color!=2){
			double deductCredit = TransactionsBean.deductCredit(Price, cNumber, sCode);
			for(int i = 0; i < requestedQuantity.size(); i++){
				ProductsBean.deleteRequestedQuantity(requestedQuantity.get(i), Products.get(i).getId());
			}
			session.setAttribute("deductCredit", deductCredit);
			session.setAttribute("Session", session);
			
			int TotalPrice = (Integer)session.getAttribute("TotalPrice");
		    SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");            
		    Calendar c = Calendar.getInstance();        
		    String EstimatedDeliveryTime = (String)(formattedDate.format(c.getTime()));

			OrdersBean ordBeanInit = new OrdersBean();
		    Users aUser = (Users)session.getAttribute("loggedInUser");
		    ordBeanInit.setId((int)(Math.random()*1000000));
			ordBeanInit.setCustomerId(aUser.getId());
			ordBeanInit.setTotalCost(TotalPrice);
			ordBeanInit.setOrderDate(EstimatedDeliveryTime);
			ordBeanInit.setBillingAddress(billingAddress);
			ordBeanInit.setCrediCardNumber(cNumber);
			ordBeanInit.setShippingAddress(shippingAddress);
			OrdersBean.addOrder(ordBeanInit);
			session.setAttribute("Orders", ordBeanInit);
			@SuppressWarnings("unchecked")
			ArrayList<OrdersBean> OrdersList = (ArrayList<OrdersBean>)session.getAttribute("OrdersList");
			if(OrdersList == null){
				OrdersList = new ArrayList<OrdersBean>();
				session.setAttribute("OrdersList", OrdersList);
			}
			
			OrdersList.add(ordBeanInit);
			
			@SuppressWarnings("unchecked")
			ArrayList<ProductsBean> ShoppingCart = (ArrayList<ProductsBean>)session.getAttribute("ShoppingCart");
			@SuppressWarnings("unchecked")
			ArrayList<Integer> RequestedQuantityList = (ArrayList<Integer>)session.getAttribute("RequestedQuantityList");

			@SuppressWarnings("unchecked")
			ArrayList<OrderItems> OrderItemsList = (ArrayList<OrderItems>)session.getAttribute("OrderItemsList");
			if(OrderItemsList == null){
				OrderItemsList = new ArrayList<OrderItems>();
				session.setAttribute("OrderItemsList", OrderItemsList);
			}
			
			for (int i=0; i<ShoppingCart.size(); i++) {
				OrderItems ordItem = new OrderItems();
				
				ordItem.setOrderId(ordBeanInit.getId());
				ordItem.setSellerId(ShoppingCart.get(i).getSellerId());
				ordItem.setProductId(ShoppingCart.get(i).getId());
				ordItem.setProductPrice(ShoppingCart.get(i).getPrice());
				ordItem.setQuantity(RequestedQuantityList.get(i));
				ordItem.setShippingStatus((byte) 1);
				ordItem.setShippingRefNo(1000*(int) Math.random());
				ordItem.setStatus((byte) 1);
				OrderItems.addOrderItem(ordItem);
				OrderItemsList.add(ordItem);
		    }
		}
			
		
		session.setAttribute("color", color);
		session.setAttribute("price", Price);
		session.setAttribute("cardHolderName", cHolderName);
		session.setAttribute("sCode", sCode);
		session.setAttribute("eDate", eDate);
		session.setAttribute("cNumber", cNumber);
		session.setAttribute("ShippingAddress", shippingAddress);
		session.setAttribute("billingAddress", billingAddress);
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
