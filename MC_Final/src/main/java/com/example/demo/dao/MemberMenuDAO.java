package com.example.demo.dao;

<<<<<<< HEAD
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.example.demo.vo.MemberMenuVO;
=======
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MenuVO;
>>>>>>> master

@Mapper
@Repository
public interface MemberMenuDAO {
	
<<<<<<< HEAD
	public List<MemberMenuVO> membermenuList() throws DataAccessException;

	public void membermenuWrite(MemberMenuVO membermenuVO) throws DataAccessException;

=======
	public void insertMemberMenu(MenuVO menuVO) throws DataAccessException;
	public MenuVO selectMemberMenu(MenuVO menuVO) throws DataAccessException;
>>>>>>> master
}
