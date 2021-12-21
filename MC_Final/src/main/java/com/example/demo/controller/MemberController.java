package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.MemberService;
import com.example.demo.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("memberInsert")
	public String memberInsert(MemberVO memberVO) {
		//System.out.println(memberVO);
		try {
			memberService.memberInsert(memberVO);
			return "memberInsert_result";
		}catch(DataAccessException e) {
			return "error";
		}
	}
	
	@RequestMapping("memberSelect")
	@ResponseBody
	public String memberSelect(HttpSession session, MemberVO memberVO) {
		try {
			JSONObject jo = new JSONObject();
			MemberVO memberSelect = memberService.memberSelect(memberVO);
			jo.put("id", memberSelect.getId());
			jo.put("pw", memberSelect.getPw());
			jo.put("email", memberSelect.getEmail());
			jo.put("nickname", memberSelect.getNickname());
			jo.put("age", memberSelect.getAge());
			return jo.toJSONString();
		}catch(DataAccessException e) {
			return "error";
		}
	}
	
	@RequestMapping("memberUpdate")
	public String memberUpdate(HttpSession session, MemberVO memberVO) {
		System.out.println(memberVO);
		try {
			session.setAttribute("memberVO", memberVO);
			memberService.memberUpdate(memberVO);
			return "memberUpdate_result";
		}catch(DataAccessException e) {
			return "error";
		}
	}
	
	@RequestMapping("memberDelete")
	@ResponseBody
	public String memberDelete(HttpSession session, MemberVO memberVO) {
		JSONObject jo=new JSONObject();
		try {
			memberService.memberDelete(memberVO);
			session.invalidate();
			jo.put("msg", "ok");
			
		}catch(Exception e) {
			jo.put("msg", e.getMessage());
		}
		
		return jo.toJSONString();
	}
	
	
	@RequestMapping("idCheck")
	@ResponseBody
	public String idCheck(MemberVO memberVO) {		
		if (memberService.idCheck(memberVO)!=null) {
		return "아이디가 중복됩니다"; 
		}else{
			return "사용 가능한 아이디입니다.";
		}
	}
	
	
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpSession session,MemberVO memberVO) {
		//System.out.println(memberVO);	
		JSONObject jo=new JSONObject();
<<<<<<< HEAD
		if(memberVO.getId() ==null || memberVO.getId().equals("") || 
				memberVO.getPw()==null || memberVO.getPw().equals("")) {

			jo.put("msg", "id와 pw는 필수입니다");
			return jo.toJSONString();
		}
=======
>>>>>>> soohyun1
		try {
			MemberVO vo=memberService.login(memberVO);
			if(vo!=null) {
				session.setAttribute("memberVO", memberVO);	
				jo.put("id", vo.getId());
				
			}else {
				jo.put("msg", "id와 pw를 확인하세요");
				
			}
		}catch(DataAccessException e) {
			jo.put("msg", e.getMessage());
		}		
		
		return jo.toJSONString();
	}
	
	
	@RequestMapping("logout")
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
