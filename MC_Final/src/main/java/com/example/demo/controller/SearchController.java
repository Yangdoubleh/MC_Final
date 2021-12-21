package com.example.demo.controller;

import java.util.List;

import org.json.simple.*;
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
	public String receipeSearch(String ingredient) {
		//외국 API를 사용하여 식재료를 영어로 변환 후 사용
		String strJson = receipeSearchService.ReceipeSearch(translationService.translatekoen(ingredient));
		
		JSONArray jaResult = new JSONArray();
		JSONParser jsonParser= new JSONParser();
		JSONObject jo1 = new JSONObject();
		try {
			jo1 = (JSONObject)jsonParser.parse(strJson);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray ja1 = (JSONArray)jo1.get("hits");
		for(int i=0; i<19; i++) {
			JSONObject joResult = new JSONObject();
			JSONObject jo2 = (JSONObject)ja1.get(i);
			JSONObject jo3 = (JSONObject)jo2.get("recipe");
			JSONObject jo4 = (JSONObject)jo3.get("images");
			if ((JSONObject)jo4.get("REGULAR")!=null) {
				JSONObject jo5 = (JSONObject)jo4.get("REGULAR");
				joResult.put("foodImage", (String)jo5.get("url"));
			}
			JSONObject jo6 = (JSONObject)jo3.get("totalNutrients");
			JSONObject joKcal = (JSONObject)jo6.get("ENERC_KCAL");
			JSONObject joCarb = (JSONObject)jo6.get("CHOCDF");
			JSONObject joProt = (JSONObject)jo6.get("PROCNT");
			JSONObject joFat = (JSONObject)jo6.get("FAT");
			String foodName = (String)jo3.get("label");
			String foodNameKr = translationService.translateenko(foodName);
			joResult.put("foodName", foodNameKr);
			joResult.put("url", (String)jo3.get("url"));
			joResult.put("foodKcal", (Double)joKcal.get("quantity"));
			joResult.put("foodFat", (Double)joFat.get("quantity"));
			joResult.put("foodProt", (Double)joProt.get("quantity"));
			joResult.put("foodCarb", (Double)joCarb.get("quantity"));
			jaResult.add(joResult);
		}
		return jaResult.toJSONString();
		
		//return => 음식 이름 / 사진 / 레시피 URL / kcal / 탄수화물 / 단백질 / 지방
	}
}