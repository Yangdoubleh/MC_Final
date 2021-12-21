package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	public void memberInsert(MemberVO memberVO) throws DataAccessException{
		memberDAO.insertMember(memberVO);
	}
	
	public MemberVO memberSelect(MemberVO memberVO) throws DataAccessException {
		return memberDAO.selectMember(memberVO);
	}
	
	public void memberUpdate(MemberVO memberVO) throws DataAccessException {
		memberDAO.updateMember(memberVO);
	}
	
	public void memberDelete(MemberVO memberVO) throws DataAccessException{
		memberDAO.deleteMember(memberVO);
	}
	
	public MemberVO login(MemberVO memberVO)  throws DataAccessException{
		return memberDAO.login(memberVO);
	}
	
	public MemberVO idCheck(MemberVO memberVO) throws DataAccessException{
		return memberDAO.idCheck(memberVO);
	}
}

