package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MenuVO;

@Mapper
@Repository
public interface MemberMenuDAO {
	
	public List<MenuVO> membermenuList(MenuVO menuVO) throws DataAccessException;
	public void insertMemberMenu(MenuVO menuVO) throws DataAccessException;
	public MenuVO selectMemberMenu(MenuVO menuVO) throws DataAccessException;
	public void deleteMemberMenu(MenuVO menuVO) throws DataAccessException;
	public void membermenuWrite(MenuVO menuVO) throws DataAccessException;

}
