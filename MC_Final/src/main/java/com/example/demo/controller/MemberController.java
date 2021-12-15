package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("login")
	@ResponseBody
	public String login(MemberVO memberVO) {
		System.out.println(memberVO);
		MemberVO memberVO = memberService.login(memberVO);
		JSONObject jo=new JSONObject();
		if(memberVO!=null) {
			jo.put("id", memberVO.getId());
		}
		return jo.toJSONString();
	}
	
	@PostMapping("logout")
	@ResponseBody
	public void logout(HttpSession session) {
		session.invalidate();		
	}

}
