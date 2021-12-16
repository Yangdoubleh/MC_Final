package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.FoodService;
import com.example.demo.service.MemberMenuService;
import com.example.demo.vo.FoodVO;
import com.example.demo.vo.MenuVO;

@Controller
public class MenuController {

	@Autowired
	FoodService foodService;
	
	@Autowired
	MemberMenuService memberMenuService;
	
	@RequestMapping("menuInsert")
	@ResponseBody
	public String foodInsert(FoodVO foodVO) {
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
				memberMenuService.memberMenuInsert(menuVO);
				return "내가 먹은 메뉴에 추가되었습니다.";
		} catch(DataAccessException e) {
			return "메뉴 추가에 오류가 생겼습니다.";
		}
	}
}
