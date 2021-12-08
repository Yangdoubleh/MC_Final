package com.example.demo.service;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class ReceipeSerachService {

	public String ReceipeSearch(String text){
		String app_id = "6b2b03b4";
		String app_key = "be191f1feafba8f1c83ecabadadfb742";
		try {
			String ingredient = URLEncoder.encode(text, "UTF-8");
			String apiURL = "https://api.edamam.com/api/recipes/v2?q="+ ingredient + "&app_id=" + app_id + "&app_key=" + app_key +"&type=public";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(30000);
			con.setReadTimeout(30000);
			try (InputStream in = con.getInputStream();BufferedReader br=new BufferedReader(new InputStreamReader(in));
			) {
				String inputLine;
				if(br != null) {
	                StringBuffer response = new StringBuffer();
	                while ((inputLine = br.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                br.close();
	                return response.toString();
	            }
			}
			con.disconnect();
		} catch (Exception e) {
			return e.getMessage();
		}
		return null;
	}
}
