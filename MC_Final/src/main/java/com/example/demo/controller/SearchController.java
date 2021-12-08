package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.TranslationService;

@Controller
public class SearchController {

	@Autowired
	TranslationService TranslationService;
	
	@RequestMapping("translationKoEn")
	@ResponseBody
	public String translationKoEn(String ingredient) {
		return TranslationService.translatekoen(ingredient);
	}
	
}
