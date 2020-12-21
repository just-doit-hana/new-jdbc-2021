package com.laptrinhweb.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.constant.SystemConstant;
import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.utils.FormUtill;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	private INewService newService;
    public NewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		NewModel model = new NewModel();
//		lay tu servcevi ra 
//		thay the ham de ham HomeUtils lam cho nguyen cai doan code nay 
//	try {
//		String pageStr = request.getParameter("page");
//		String maxPageItem = request.getParameter("maxPageItem");
//		if (pageStr != null) {
//			model.setPage(Integer.parseInt(pageStr));
//		}
//		else {
//			model.setPage(1);
//		}
//		
//		if (maxPageItem != null) {
//			model.setMaxPageItem(Integer.parseInt(maxPageItem));
//		}
		try {
			NewModel model =FormUtill.toModel(NewModel.class,request);
			Integer offset=(model.getPage()-1) * model.getMaxPageItem();
			
			model.setListResultList(newService.finAll(offset,model.getMaxPageItem()));
			
		    model.setTotalItem(newService.getTotalitem());  // total item
			
		    model.setTotalPage((int) Math.ceil((double) model.getTotalItem()/model.getMaxPageItem()));
		    	
			
			request.setAttribute(SystemConstant.MODEL, model);
			
			RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/admin/new/list.jsp");
			
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	
	
//	get maxpage  lay param tu input ben file list.jsp
//	
	
//		model  la trung gian controle va view --> tra data ve views  la  model   -- tat ca controler khi tra ve view deu co bien la model   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
