package com.laptrinhweb.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.model.UserModel;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.service.IUserService;
import com.laptrinhweb.utils.FormUtill;
import com.laptrinhweb.utils.SessionUtils;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( urlPatterns = { "/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
	
	// context dependency injection (CDI) trong servlet
	// tim hieu ve @inject la gi 
	// cong dung hay cua tk servlet weld la dependency 
@Inject
	private  ICategoryService categoryService;

//@Inject
//private INewService newService;
@Inject 
private IUserService userService;
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// debub chay thu NewsItems
		// du lieu dung de test thu 
//		String tileString  = "bai viet quang huy";
//		String contentString="bai viet quang huy";
//		Long cateID = 1L;
//		NewModel newModel = new NewModel();
//		newModel.setTitle(tileString);
//		newModel.setContents(contentString);
//		newModel.setCategoryId(cateID);
//		newService.save(newModel);
//		try {
//			String action = request.getParameter("action");
//			if (action != null && action.equals("login"))
//			{
//				RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/login.jsp");
//				rd.forward(request, response);
//			}
//			else if (action != null &&action.equals("logout")) 
//			{
//				SessionUtils.getInstance().removeValue(request, "USERMODEL");
//				response.sendRedirect( request.getContextPath()+"/trang-chu");
//			} 
//			else 
//			{
//				request.setAttribute("data",categoryService.findAll());
//				RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/web/home.jsp");
//				rd.forward(request, response);
//			}
//				
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
//		ResourceBundle resourceBundle = ResourceBundle.getBundle("name properties");
//		request.setAttribute("message", resourceBundle.getString(""));
		try {
			String action = request.getParameter("action");
			if (action != null && action.equals("login")) {
				String alert = request.getParameter("alert");
				String message = request.getParameter("message");
				if (message != null && alert != null) {
					request.setAttribute("message", message);
					request.setAttribute("alert", alert);
				}
				RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/login.jsp");
				rd.forward(request, response);
			} else if (action != null && action.equals("logout")) {
				SessionUtils.getInstance().removeValue(request, "USERMODEL");
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			} else {
				request.setAttribute("data", categoryService.findAll());
				RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/web/home.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
//		try {
//			String action = request.getParameter("action");
//			
//			if (action != null &&action.equals("login")) {
////				Can fix bug
//				    UserModel user= FormUtill.toModel(UserModel.class, request);
//					user= userService.finByUserNameAndPasswordAndStatus(user.getUserName(), user.getPassword(), 1);
//					if (user != null) {
//						SessionUtils.getInstance().putValue(request, "USERMODEL", user);
//						if (user.getRole().getCode().equals("USER")) {
////							response.sendRedirect("http://localhost:8080/new-jdbc-2021/trang-chu");
////							
//							response.sendRedirect("http://localhost:8080/new-jdbc-2021/trang-chu");
//						}
//						else if (user.getRole().getCode().equals("ADMIN")) {
//						response.sendRedirect(request.getContextPath()+"/admin-home");
////							response.sendRedirect("http://localhost:8080/new-jdbc-2021/admin-home");
//						}
//						
//						else {
////							getContextPath giong nhu localhost
//							response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
//						}
//					}
//				} 
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
		
			String action = request.getParameter("action");
			if (action != null && action.equals("login")) {
				UserModel model = FormUtill.toModel(UserModel.class, request);
				try {
					model = userService.finByUserNameAndPasswordAndStatus(model.getUserName(),model.getPassword(),1);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (model != null) {
					SessionUtils.getInstance().putValue(request, "USERMODEL", model);
					if (model.getRole().getCode().equals("USER")) {
						response.sendRedirect(request.getContextPath()+"/trang-chu");
					} else if (model.getRole().getCode().equals("ADMIN")) {
						response.sendRedirect(request.getContextPath()+"/admin-home");
					}
				} else {
					response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=Invalid User &alert=danger");
				}
			}
		} 
		
		
		}
	

