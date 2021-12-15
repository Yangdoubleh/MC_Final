package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.service.MemberMenuService;
import com.example.demo.vo.MemberMenuVO;

@Controller
public class MemberMenuController {
	
	@Autowired
	MemberMenuService menuService;
	
	//글목록 가져오기
	@RequestMapping("menuList")
	public ModelAndView menuList() {
		List<MemberMenuVO> list = menuService.menuList();
		ModelAndView mav=new ModelAndView("menuList");
		mav.addObject("menuList", list);
		return mav;
	}
	
	
	
}









