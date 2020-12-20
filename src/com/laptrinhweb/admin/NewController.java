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

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = { "/admin-new-list" })
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
		

//		lay tu servcevi ra 
	try {
		NewModel model = new NewModel();
		request.setAttribute(SystemConstant.MODEL, model);
		model.setListResultList(newService.finAll());
		model.setTotalPageItem(model.getListResultList().size());  // total item
		model.setTotalPage((int) Math.ceil((double) model.getTotalPageItem()/model.getMaxPageItem()));
		RequestDispatcher rd = request.getRequestDispatcher("/src1/main/webapp/views/admin/new/list.jsp");
		rd.forward(request, response);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
