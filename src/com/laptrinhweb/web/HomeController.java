package com.laptrinhweb.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( urlPatterns = { "/trang-chu"})
public class HomeController extends HttpServlet {
	
	// context dependency injection (CDI) trong servlet
	// tim hieu ve @inject la gi 
	// cong dung hay cua tk servlet weld la dependency 
@Inject
	private  ICategoryService categoryService;

@Inject
private INewService newService;

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
		try {
			request.setAttribute("data",categoryService.findAll());
			RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/web/home.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
}
