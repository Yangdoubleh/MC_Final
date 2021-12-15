package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.example.demo.vo.MemberMenuVO;

@Mapper
@Repository
public interface MemberMenuDAO {
	
	public List<MemberMenuVO> menuList() throws DataAccessException;

}
