package com.example.demo.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
>>>>>>> master
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
<<<<<<< HEAD
	public MemberVO login(MemberVO memberVO) {
		return memberDAO.login(memberVO);
	}
}
=======
	public void memberInsert(MemberVO memberVO) throws DataAccessException{
		memberDAO.insertMember(memberVO);
	}
	
	public MemberVO login(MemberVO memberVO)  throws DataAccessException{
		return memberDAO.login(memberVO);
	}
}

>>>>>>> master
