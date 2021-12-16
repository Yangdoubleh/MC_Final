package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.service.BasketService;
import com.example.demo.service.MemberMenuService;
import com.example.demo.vo.BasketVO;
import com.example.demo.vo.MemberMenuVO;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberMenuController {
	
	@Autowired
	MemberMenuService membermenuService;
	
	//식단 목록보기
	@RequestMapping("membermenuList")	
	public ModelAndView membermenuList() {
		
		List<MemberMenuVO> list=membermenuService.membermenuList();
		System.out.println("membermenuList : "+list.size());
		ModelAndView mav=new ModelAndView("membermenuList");
		mav.addObject("membermenuList", list);
		System.out.println(list);
		return mav;
		
	}
	
	//식단 입력하기
	@RequestMapping("membermenuWriteForm")	
	public String membermenuWriteForm() {			
		return "membermenuWriteForm";		
	}
	
	//식단 저장하기
	@RequestMapping("membermenuWrite")
	public RedirectView membermenuWrite(MemberMenuVO membermenuVO) {
		System.out.println(membermenuVO);
		membermenuService.membermenuWrite(membermenuVO);
		return new RedirectView("membermenuList"); 
	}

}
