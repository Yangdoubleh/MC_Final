package com.example.demo.service;

//네이버 Papago Text Translation API 예제
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    @Value("${naverAi.clientId}")
    private String clientId;
    
    @Value("${naverAi.clientSecret}")
    private String clientSecret;

	public String translatekoen(String text) {
     try {
         text = URLEncoder.encode(text, "UTF-8");
         String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
         URL url = new URL(apiURL);
         HttpURLConnection con = (HttpURLConnection)url.openConnection();
         con.setRequestMethod("POST");
         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
         // post request
         String postParams = "source=ko&target=en&text=" + text;
         con.setDoOutput(true);
         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
         wr.writeBytes(postParams);
         wr.flush();
         wr.close();
         int responseCode = con.getResponseCode();
         BufferedReader br;
         if(responseCode==200) { // 정상 호출
             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
         } else {  // 오류 발생
             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
         }
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = br.readLine()) != null) {
             response.append(inputLine);
         }
         br.close();
         JSONObject jo1 = new JSONObject(response.toString());
         JSONObject jo2 = jo1.getJSONObject("message");
         JSONObject jo3 = jo2.getJSONObject("result");
         return (String)jo3.get("translatedText");
         
     } catch (Exception e) {
         return e.getMessage();
     }
 }
	
	public String translateenko(String text) {
	     String clientId = "xlxremy2rg";//애플리케이션 클라이언트 아이디값";
	     String clientSecret = "hO1AvZHlh4jDab6NLyhymUf4jhGFM148TCHYKHVw";//애플리케이션 클라이언트 시크릿값";
	     try {
	         text = URLEncoder.encode(text, "UTF-8");
	         String apiURL = "https://naveropenapi.apigw.ntruss.com/nmt/v1/translation";
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	         con.setRequestMethod("POST");
	         con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	         con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	         // post request
	         String postParams = "source=en&target=ko&text=" + text;
	         con.setDoOutput(true);
	         DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	         wr.writeBytes(postParams);
	         wr.flush();
	         wr.close();
	         int responseCode = con.getResponseCode();
	         BufferedReader br;
	         if(responseCode==200) { // 정상 호출
	             br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         } else {  // 오류 발생
	             br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	         }
	         String inputLine;
	         StringBuffer response = new StringBuffer();
	         while ((inputLine = br.readLine()) != null) {
	             response.append(inputLine);
	         }
	         br.close();
	         JSONObject jo1 = new JSONObject(response.toString());
	         JSONObject jo2 = jo1.getJSONObject("message");
	         JSONObject jo3 = jo2.getJSONObject("result");
	         return (String)jo3.get("translatedText");
	     } catch (Exception e) {
	         return e.getMessage();
	     }
	 }
}