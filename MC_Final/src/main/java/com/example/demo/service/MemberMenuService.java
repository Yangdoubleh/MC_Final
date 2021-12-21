package com.example.demo.service;

import java.util.List;

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
	
	public MenuVO selectMemberMenu(MenuVO menuVO) throws DataAccessException{
		return memberMenuDAO.selectMemberMenu(menuVO);
	}
	
	public List<MenuVO> membermenuList(MenuVO menuVO) throws DataAccessException{
		return memberMenuDAO.membermenuList(menuVO);
	}
	
	public void deleteMemberMenu(MenuVO menuVO) throws DataAccessException{
		memberMenuDAO.deleteMemberMenu(menuVO);
	}

	public void membermenuWrite(MenuVO menuVO) throws DataAccessException {
		memberMenuDAO.membermenuWrite(menuVO);
	}
	
	

}
