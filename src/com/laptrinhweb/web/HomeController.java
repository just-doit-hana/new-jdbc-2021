package com.laptrinhweb.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.service.ICategoryService;
import com.laptrinhweb.service.INewService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( urlPatterns = { "/trang-chu"})
public class HomeController extends HttpServlet {
	
@Inject
	private  ICategoryService categoryService;

@Inject
private INewService newService;
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long category = 1L;
		request.setAttribute("news",newService.findByCategoryId(category));
		request.setAttribute("data",categoryService.findAll());
		
	RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/web/home.jsp");
	rd.forward(request, response);
		
	}
}
