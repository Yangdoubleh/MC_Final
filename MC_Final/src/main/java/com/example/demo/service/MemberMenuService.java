package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberMenuDAO;
import com.example.demo.vo.MenuVO;

@Service
public class MemberMenuService {

	@Autowired
	MemberMenuDAO memberMenuDAO;
	
	public void memberMenuInsert(MenuVO menuVO) throws DataAccessException{
		memberMenuDAO.insertMemberMenu(menuVO);
	}
	
	public MenuVO memberMenuSelect(MenuVO menuVO) throws DataAccessException{
		return memberMenuDAO.selectMemberMenu(menuVO);
	}
}