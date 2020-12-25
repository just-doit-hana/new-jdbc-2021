package com.laptrinhweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
//dung de duy tri thong tin nguoi dung 
//	 putvalue:dung de duy tri thong tin nguoi dung 
//	remove value: thoat khoi thong tin nguoi dung 
//	getValue:lay thon tin ra 

//	private static SessionUtils sessionUtils = null;
//
////	ham tra ve session utils
//	public static SessionUtils getInstance() {
//		if (sessionUtils == null) {
//			sessionUtils = new SessionUtils();
//		}
//		return sessionUtils;
//	}
//
//	/*
//	 * Bc 1 bat buoc phai co httpservletrequest bc 2 phai co key va value
//	 */
//	public void putValue(HttpServletRequest request, String key, Object value) {
//		request.getSession().setAttribute(key, value);
//
//	}
//
////	khong biet get su lieu kieu gi thi de  object va se ep kieu thanh du lieu kieu dau ra mong muon  
//	public Object getValue(HttpServletRequest request, String key) {
//		return request.getSession().getAttribute(key);
//	}
//
//	public void removeValue(HttpServletRequest request, String key) {
//		request.getSession().removeAttribute(key);
//	}
	

    private static SessionUtils sessionUtil = null;

    public static SessionUtils getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new SessionUtils();
        }
        return sessionUtil;
    }

    public void putValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
	
}
