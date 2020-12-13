package com.laptrinhweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
 private String value;
	public HttpUtil(String value) {
		this.value =value;
	}
	// la giong nhu 1 kieu du lieu String , interger , double 
	// chua json -- http Utils
	public static HttpUtil of(BufferedReader reader)  {
		StringBuilder json = new StringBuilder();
		try {
			
			String line; 
			while ((line=reader.readLine())!=null) {
				json.append(line);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return new HttpUtil(json.toString());
		
	}
}
