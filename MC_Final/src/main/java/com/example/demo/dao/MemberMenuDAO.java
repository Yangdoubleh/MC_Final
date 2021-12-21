package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MenuVO;

@Mapper
@Repository
public interface MemberMenuDAO {
	
	public void insertMemberMenu(MenuVO menuVO) throws DataAccessException;
	public List<MenuVO> selectMemberMenu(MenuVO menuVO) throws DataAccessException;
}
