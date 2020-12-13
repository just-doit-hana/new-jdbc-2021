package com.laptrinhweb.admin.api;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhweb.utils.HttpUtil;
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {

	/**
	 * 
	 */
	
	// client : co the mobile , reactjs , agularjs 
	// jsp truyen data len server (restfullapi) bang json 
	//API 
	 // model  trung gian giua client(cu the la jsp) va server(servlet)
	private static final long serialVersionUID = 1L; 
	// get -- select  , post -- them moi  , delete , put -- > cap nhat 
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		// ham them bai moi 
		request.setCharacterEncoding("UTF-8");// set  kieu chu de server biet dc tieng viet 
		response.setContentType("application/json"); // tra ve giong du lieu giong client 
		HttpUtil.of(request.getReader());
	}
//protected void doPut(HttpServletRequest request , HttpServletResponse response) {
//		
//	}
//protected void doDelete(HttpServletRequest request , HttpServletResponse response) {
//	
//}
}
