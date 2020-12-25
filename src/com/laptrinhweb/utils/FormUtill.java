package com.laptrinhweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtill {

//	ham nay dung de map tat ca cac model lai voi nhau  khi co nhieu cai parameter cung thi nos giam tai tu dong mapper cacs parameter
//	clinent no gui vo tk server thi no se tu dong mapper voi tk model 
//	Note name cua cai thuoc tinhs html phair trung voi cais filed trong model 
//	@SuppressWarnings({ "deprecation" })
//	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
//		T object = null;
//		try {
//			object = clazz.newInstance();
////			Can fix bug
//			BeanUtils.populate(object, request.getParameterMap());
//		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
//			System.out.print(e.getMessage());
//		}
//		return object;
//	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
		T object = null;
		try {
			object = clazz.newInstance();
			BeanUtils.populate(object, request.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.print(e.getMessage());
		}
		return object;
	}
}
