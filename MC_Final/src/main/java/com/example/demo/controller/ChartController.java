package com.example.demo.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.FoodService;
import com.example.demo.service.MemberMenuService;
import com.example.demo.vo.FoodVO;
import com.example.demo.vo.MenuVO;

@Controller
public class ChartController {

	@Autowired
	MemberMenuService memberMenuService;
	
	@Autowired
	FoodService foodService;
	
	@RequestMapping("updateChart1")
	@ResponseBody
	public String updateChart1(MenuVO menuVO) {
		int kcal=0, carb=0, prot=0, fat=0;
		JSONObject jo = new JSONObject();  //빈 제이슨 
		FoodVO foodsearch = new FoodVO(); // 빈 푸드 vo
		List list = memberMenuService.membermenuList(menuVO); 
		if(list.size()<3) {
			for (int i=0; i<list.size(); i++) {
				MenuVO lastmenu = (MenuVO)list.get(i);
				System.out.println(list);		
				foodsearch.setFoodName(lastmenu.getFoodName()); 
				foodsearch = foodService.foodSelect(foodsearch);
				kcal = kcal+foodsearch.getKcal();
				carb = carb+foodsearch.getCarb();
				prot = prot+foodsearch.getProt();
				fat = fat+foodsearch.getFat();
			}
		} else {
			for (int i=list.size()-3; i<list.size(); i++) {
				MenuVO lastmenu = (MenuVO)list.get(i);
				System.out.println(list);		
				foodsearch.setFoodName(lastmenu.getFoodName()); 
				foodsearch = foodService.foodSelect(foodsearch);
				kcal = kcal+foodsearch.getKcal();
				carb = carb+foodsearch.getCarb();
				prot = prot+foodsearch.getProt();
				fat = fat+foodsearch.getFat();
			}
		}
		jo.put("kcal", kcal);
		jo.put("carb", carb);
		jo.put("prot", prot);
		jo.put("fat", fat);
		return jo.toString();
	}
}
