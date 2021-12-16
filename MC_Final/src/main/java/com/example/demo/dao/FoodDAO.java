package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.FoodVO;

@Mapper
@Repository
public interface FoodDAO {
	
	public void insertFood(FoodVO foodVO) throws DataAccessException;
	public FoodVO selectFood(FoodVO foodVO) throws DataAccessException;
}
