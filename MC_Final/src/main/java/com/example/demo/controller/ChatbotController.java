package com.example.demo.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.ChatbotService;
import com.example.demo.service.TTS_Service;

@Controller
public class ChatbotController {

	
	@Autowired
	TTS_Service ttsService;
	
	@Autowired
	ChatbotService chatbotService;
	
	
	
	@PostMapping("chatbot")
	@ResponseBody
	public String chatbot(String inputData) {
		System.out.println(inputData);
		String jsonData=chatbotService.chatbot(inputData);
		System.out.println(jsonData);
		// data.bubbles[0].data.description;
		JSONParser jsonParser = new JSONParser();
		JSONObject jo1=new JSONObject();
		try {
			jo1 = (JSONObject)jsonParser.parse(jsonData);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray arr=(JSONArray) jo1.get("bubbles");
		JSONObject jo2=(JSONObject) arr.get(0);
		JSONObject jo3=(JSONObject) jo2.get("data");
		String data=(String) jo3.get("description");
		if(data==null) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
		}
		
		String mp3FileName=ttsService.tts(data);
		jo1.put("fileName", mp3FileName);
		
		return jo1.toString();
		
	}
}
