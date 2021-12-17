package com.example.demo.service;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ReceipeSerachService {

	@Value("${recipe.clientId}")
    private String app_id;
    
    @Value("${recipe.clientSecret}")
    private String app_key;
    
	public String ReceipeSearch(String text){
		try {
			String ingredient = URLEncoder.encode(text, "UTF-8");
			String apiURL = "https://api.edamam.com/api/recipes/v2?q="+ ingredient + "&app_id=" + app_id + "&app_key=" + app_key +"&type=public";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(3000);
			con.setReadTimeout(3000);
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
