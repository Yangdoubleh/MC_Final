package com.example.demo.service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> master
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberMenuDAO;
<<<<<<< HEAD
import com.example.demo.vo.MemberMenuVO;

@Service
public class MemberMenuService {
	
	@Autowired
	MemberMenuDAO membermenuDAO;
	
	public List<MemberMenuVO> membermenuList(){
		return membermenuDAO.membermenuList();
	}
	
	public void membermenuWrite(MemberMenuVO membermenuVO) throws DataAccessException{
		membermenuDAO.membermenuWrite(membermenuVO);
	}

=======
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
>>>>>>> master
}
