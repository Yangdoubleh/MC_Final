package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.BasketService;
import com.example.demo.service.FoodService;
import com.example.demo.vo.FoodVO;
import com.example.demo.vo.MenuVO;

@Controller
public class BasketController {

	@Autowired
	BasketService basketService;
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping("basketInsert")
	@ResponseBody
	public String basketInsert(FoodVO foodVO) {
		MenuVO menuVO = new MenuVO();
		menuVO.setMemberID("aaa");
		menuVO.setFoodName(foodVO.getFoodName());
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		menuVO.setFoodDate(formatedNow);
		try {
			if(foodService.foodSelect(foodVO)==null) {
				foodService.foodInsert(foodVO);
			}
			if(basketService.basketSelect(menuVO)==null) {
				basketService.basketInsert(menuVO);
				return "장바구니에 추가되었습니다.";
			} else {
				return "이미 장바구니에 있습니다.";
			}
		} catch(DataAccessException e) {
			return "장바구니 추가에 오류가 생겼습니다.";
		}
	}
	
	
}
