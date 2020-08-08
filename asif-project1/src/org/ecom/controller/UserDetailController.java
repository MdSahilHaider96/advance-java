package org.ecom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecom.constant.ProjectConstants;
import org.ecom.model.Address;
import org.ecom.model.User;
import org.ecom.service.AddressService;
import org.ecom.service.UserService;

public class UserDetailController extends HttpServlet {

	private static final long serialVersionUID = -7234965939251486114L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userIdStr = request.getParameter("userId");
		
		System.out.println("user detail do get userId: "+userIdStr);
		
		UserService userService = new UserService();
		
		try {
			long userId = Long.valueOf(userIdStr);
			User user = userService.findUserById(userId);
			
			if(user!=null) {
				
				//pass value to jsp 
				request.setAttribute("user", user);
				
				AddressService addressService = new AddressService();
				List<Address> addressList = addressService.findAddressByUserId(userId);
				request.setAttribute("addressList", addressList);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		String destination = ProjectConstants.JSP_FOLDER_PATH + "user-detail.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		requestDispatcher.forward(request, response); 
	}
	
}
