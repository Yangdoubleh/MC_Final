package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.BasketService;
import com.example.demo.vo.BasketVO;
import com.example.demo.vo.MemberVO;

@Controller
public class BasketController {
	
	@Autowired
	BasketService basketService;
	
	@RequestMapping("insertBasket")
	@ResponseBody
	public String insertBasket(HttpSession session, BasketVO basketVO) {
		System.out.println(basketVO);
		
		MemberVO memberVO=(MemberVO) session.getAttribute("memberVO");
		if(memberVO==null) {
			return "로그인부터 하세요";
		}
		
		String memberID=memberVO.getMemberID();
		basketVO.setMemberID(memberID);
		
		basketService.insertBasket(basketVO);
		
		return "장바구니 넣기 ok";
		
	}
}