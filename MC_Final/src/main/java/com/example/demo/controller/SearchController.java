package com.example.demo.controller;

import java.util.List;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.example.demo.service.ReceipeSerachService;
import com.example.demo.service.TranslationService;

@Controller
public class SearchController {

	@Autowired
	TranslationService translationService;
	
	@Autowired
	ReceipeSerachService receipeSearchService;
	
	@RequestMapping("receipeSearch")
	@ResponseBody
	public String receipeSearch(String ingredient) throws ParseException {
		//외국 API를 사용하여 식재료를 영어로 변환 후 사용
		String strJson = receipeSearchService.ReceipeSearch(translationService.translatekoen(ingredient));
		JSONParser jsonParser= new JSONParser();
		Object obj = jsonParser.parse(strJson);
		JSONObject jo1 = (JSONObject)obj;
		JSONArray ja1 = (JSONArray)jo1.get("hits");
		for(int i=0; i<19; i++) {
			JSONObject jo2 = (JSONObject) ja1.getJSONObject(i);
			jo2.replace();
		}
		return ;
		
		//return => 음식 이름 / 사진 / 레시피 URL / kcal / 탄수화물 / 단백질 / 지방
	}
	
	@RequestMapping("translationEnKo")
	@ResponseBody
	public String translationEnKo(String foodName) {
		return translationService.translateenko(translationService.translateenko(foodName));
	}
}
