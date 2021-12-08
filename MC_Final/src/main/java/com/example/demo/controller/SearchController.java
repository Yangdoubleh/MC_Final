package com.example.demo.controller;

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
	
	@RequestMapping("translationKoEn")
	@ResponseBody
	public String translationKoEn(String ingredient) {
		return translationService.translatekoen(ingredient);
	}
	
	@RequestMapping("receipeSearch")
	@ResponseBody
	public String receipeSearch(String englishingred) {
		return receipeSearchService.ReceipeSearch(englishingred);
	}
}
