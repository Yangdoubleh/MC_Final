package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
	public String login(HttpSession session,MemberVO memberVO) {
		System.out.println(memberVO);	
		JSONObject jo=new JSONObject();
		
		if(memberVO.getMemberID() ==null || memberVO.getMemberID().equals("") || 
				memberVO.getPassword()==null || memberVO.getPassword().equals("")) {
			jo.put("msg", "id와 pw는 필수입니다");
			return jo.toJSONString();
		}
		
		try {
			MemberVO vo=memberService.login(memberVO);
			if(vo!=null) {
				session.setAttribute("memberVO", memberVO);			
				jo.put("memberID", vo.getMemberID());
			}else {
				jo.put("msg", "id와 pw를 확인하세요");
			}
		}catch(DataAccessException e) {
			jo.put("msg", e.getMessage());
		}		
		
		return jo.toJSONString();
	}
	
	@PostMapping("logout")
	@ResponseBody
	public String logout(HttpSession session) {
		JSONObject jo=new JSONObject();
		
		try {
			session.invalidate();
			
			jo.put("msg", "ok");
		}catch(Exception e) {
			jo.put("msg", e.getMessage());
		}
		
		return jo.toJSONString();
	}

}
