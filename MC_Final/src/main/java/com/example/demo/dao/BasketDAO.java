package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MenuVO;

@Mapper
@Repository
public interface BasketDAO {
	
	public void insertBasket(MenuVO menuVO) throws DataAccessException;
	public MenuVO selectBasket(MenuVO menuVO) throws DataAccessException;
}
