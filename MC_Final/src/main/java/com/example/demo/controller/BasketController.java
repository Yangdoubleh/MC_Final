package com.example.demo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.BasketService;
import com.example.demo.service.FoodService;
import com.example.demo.service.MemberMenuService;
import com.example.demo.vo.FoodVO;
import com.example.demo.vo.MenuVO;

@Controller
public class BasketController {

	@Autowired
	BasketService basketService;
	
	@Autowired
	FoodService foodService;
	
	@Autowired
	MemberMenuService memberMenuService;
	
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
	
	//장바구니 목록보기
	@RequestMapping("basketList")
	@ResponseBody
	public String membermenuList(MenuVO menuVO) {
		List<MenuVO> list=basketService.basketList(menuVO);
		JSONArray ja = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			JSONObject jo = new JSONObject();
			MenuVO str = list.get(i);
			String foodName = str.getFoodName();
			FoodVO foodVO = new FoodVO();
			foodVO.setFoodName(foodName);
			foodVO = foodService.foodSelect(foodVO);
			jo.put("foodName", foodName);
			jo.put("imageURL", foodVO.getImageURL());
			jo.put("recipeURL", foodVO.getRecipeURL());
			jo.put("kcal", foodVO.getKcal());
			jo.put("fat", foodVO.getFat());
			jo.put("prot", foodVO.getProt());
			jo.put("carb", foodVO.getCarb());
			ja.add(jo);
		}
		return ja.toJSONString();
	}
	
	//장바구니 삭제하기
	@RequestMapping("deleteBasket")
	@ResponseBody
	public String deleteBasket(MenuVO menuVO) {
		try {
			if(basketService.basketSelect(menuVO)!=null) {
				basketService.deleteBasket(menuVO);
				return "장바구니에서 삭제되었습니다.";
			}
		} catch(DataAccessException e) {
			return "장바구니 삭제에 오류가 생겼습니다.";
		}
		return "오류";
	}
	
}
