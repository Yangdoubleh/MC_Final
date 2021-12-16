package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FoodDAO;
import com.example.demo.vo.FoodVO;
import com.example.demo.vo.MemberVO;

@Service
public class FoodService {
	
	@Autowired
	FoodDAO foodDAO;
	
	public void foodInsert(FoodVO foodVO) throws DataAccessException{
		foodDAO.insertFood(foodVO);
	}
	
	public FoodVO foodSelect(FoodVO foodVO) throws DataAccessException{
		return foodDAO.selectFood(foodVO);
	}

}
