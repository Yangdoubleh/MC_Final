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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	
	//식단 목록보기
	@RequestMapping("membermenuList")
	@ResponseBody
	public String membermenuList(MenuVO menuVO) {
		List<MenuVO> list=memberMenuService.membermenuList(menuVO);
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
			jo.put("foodDate", str.getFoodDate());
			ja.add(jo);
		}
		System.out.println(menuVO.getFoodDate());
		return ja.toJSONString();
	}
	
	//식단 삭제하기
	@RequestMapping("deleteMemberMenu")
	@ResponseBody
	public String deleteMemberMenu(MenuVO menuVO) {
		try {
			if(memberMenuService.selectMemberMenu(menuVO)!=null) {
				memberMenuService.deleteMemberMenu(menuVO);
				return "내가 먹은 메뉴에서 삭제되었습니다.";
			}
		} catch(DataAccessException e) {
			return "메뉴 삭제에 오류가 생겼습니다.";
		}
		return "오류";
	}
	
	//식단 입력 화면 제공
	@RequestMapping("membermenuWriteForm")	
	public String membermenuWriteForm() {			
		return "membermenuWriteForm";
	}
		
	//식단 등록
	@RequestMapping("membermenuWrite")
	public RedirectView membermenuWrite(MenuVO menuVO) {
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		menuVO.setFoodDate(formatedNow);
		System.out.println(menuVO);
		memberMenuService.membermenuWrite(menuVO);
		return new RedirectView("menu.html");
	}
}
