package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {
	
	public MemberVO login(MemberVO memberVO) throws DataAccessException;
	public MemberVO idCheck(MemberVO memberVO) throws DataAccessException;
	public void insertMember(MemberVO memberVO) throws DataAccessException;
	public MemberVO selectMember(MemberVO memberVO) throws DataAccessException;
	public void updateMember(MemberVO memberVO) throws DataAccessException;
	public void deleteMember(MemberVO memberVO) throws DataAccessException;

}
