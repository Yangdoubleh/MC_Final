package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return receipeSearchService.ReceipeSearch(translationService.translatekoen(ingredient));
		//return => 음식 이름 / 사진 / 레시피 URL / kcal / 탄수화물 / 단백질 / 지방
	}
	
	@RequestMapping("translationEnKo")
	@ResponseBody
	public String translationEnKo(String foodName) {
		return translationService.translateenko(translationService.translateenko(foodName));
	}
}
