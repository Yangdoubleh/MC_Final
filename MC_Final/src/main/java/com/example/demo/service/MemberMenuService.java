package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberMenuDAO;
import com.example.demo.vo.MemberMenuVO;

@Service
public class MemberMenuService {
	
	@Autowired
	MemberMenuDAO menuDAO;
	
	public List<MemberMenuVO> menuList() {
		return menuDAO.menuList();
	}
	
}

