package com.test.studentapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HttpRequest {
	
	public static String request(String url, String methodType, String requestBody) throws IOException {
	    URL urlForGetRequest = new URL(url);
	    HttpURLConnection conn = (HttpURLConnection) urlForGetRequest.openConnection();
	    conn.setRequestMethod(methodType);
	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
	    conn.setRequestProperty("Accept", "application/json");
	  //add request header
	    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
	    conn.setDoOutput(true);
	   // int responseCode = conn.getResponseCode();
	    try(OutputStream os = conn.getOutputStream()) {
	        byte[] input = requestBody.getBytes("utf-8");
	        os.write(input, 0, input.length);			
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	    StringBuilder response = new StringBuilder();
	    String responseLine = "";
	    while ((responseLine = br.readLine()) != null) {
	        response.append(responseLine.trim());
	    }
	    
	    int responseCode = conn.getResponseCode();
	    System.out.println(response.toString());
	    return response.toString();
	
	}
	
	public static String GetRequest(String url) throws IOException {
	    URL urlForGetRequest = new URL(url);
	    HttpURLConnection conn = (HttpURLConnection) urlForGetRequest.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Content-Type", "application/json; utf-8");
	    conn.setRequestProperty("Accept", "application/json");
	  //add request header
	    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
	    conn.setDoOutput(true);
	   
	    int responseCode = conn.getResponseCode();
	    
	    StringBuilder response = new StringBuilder();
	    try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	    
	    String responseLine = "";
	    while ((responseLine = br.readLine()) != null) {
	        response.append(responseLine.trim());
	    }
	    }catch(Exception e){
	    	e.printStackTrace();
	    	response.append("[]");
	    }
	    
	   System.out.println(response.toString());
	    return response.toString();
	
	}
}
