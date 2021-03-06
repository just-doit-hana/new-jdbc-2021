package com.laptrinhweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
// private String value;
//	public HttpUtil(String value) {
//		this.value =value;
//	}
//	// tra ve mot model 
//	//tim hieu ham readValue
//	public <T> T toModel(Class<T> tClass) {
//		try {
//			return new ObjectMapper().readValue(value,tClass);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return null;
//		
//	}
//	
//	// la giong nhu 1 kieu du lieu String , interger , double 
//	// chua json -- http Utils
//	public static HttpUtil of(BufferedReader reader)  {
//		StringBuilder json = new StringBuilder();
//		try {
//			
//			String line; 
//			while ((line=reader.readLine())!=null) {
//				json.append(line);
//
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//		}
//		
//		return new HttpUtil(json.toString());
//		
//	}
	
private String value;
	
	public HttpUtil (String value) {
		this.value = value;
	}
	
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
	public static HttpUtil of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
}
