package com.laptrinhweb.admin.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhweb.model.NewModel;
import com.laptrinhweb.service.INewService;
import com.laptrinhweb.utils.HttpUtil;
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

	/**
	 * 
	 */
	@Inject
	private INewService newService;
	// client : co the mobile , reactjs , agularjs 
	// jsp truyen data len server (restfullapi) bang json 
	//API 
	 // model  trung gian giua client(cu the la jsp) va server(servlet)
	private static final long serialVersionUID = 1L; 
	// get -- select  , post -- them moi  , delete , put -- > cap nhat 
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
		// ham them bai moi 
		ObjectMapper mapper = new  ObjectMapper();
		request.setCharacterEncoding("UTF-8");// set  kieu chu de server biet dc tieng viet 
		response.setContentType("application/json"); // tra ve giong du lieu giong client 
		NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newModel=newService.save(newModel);
		System.out.println(newModel);
		mapper.writeValue(response.getOutputStream(), newModel);// tra ve cho client tu phia server 
	}
protected void doPut(HttpServletRequest request , HttpServletResponse response) throws IOException {
	ObjectMapper mapper = new  ObjectMapper();// luon luon phai co 
	request.setCharacterEncoding("UTF-8");// set  kieu chu de server biet dc tieng viet 
	response.setContentType("application/json"); // tra ve giong du lieu giong client 
	NewModel updateNews = HttpUtil.of(request.getReader()).toModel(NewModel.class);
	updateNews=newService.update(updateNews);
	System.out.println(updateNews);
	mapper.writeValue(response.getOutputStream(), updateNews);// tra ve cho client tu phia server 
	}

    protected void doDelete(HttpServletRequest request , HttpServletResponse response) throws IOException {
    	ObjectMapper mapper = new  ObjectMapper();// luon luon phai co 
    	request.setCharacterEncoding("UTF-8");// set  kieu chu de server biet dc tieng viet 
    	response.setContentType("application/json"); // tra ve giong du lieu giong client 
    	NewModel newModel = HttpUtil.of(request.getReader()).toModel(NewModel.class);
    	newService.delete(newModel.getIds());
    	mapper.writeValue(response.getOutputStream(), "{}");
         }

}
