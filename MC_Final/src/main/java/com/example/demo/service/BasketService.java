package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BasketDAO;
import com.example.demo.vo.MenuVO;

@Service
public class BasketService {

	@Autowired
	BasketDAO basketDAO;
	
	public void basketInsert(MenuVO menuVO) throws DataAccessException{
		basketDAO.insertBasket(menuVO);
	}
	
	public MenuVO basketSelect(MenuVO menuVO) throws DataAccessException{
		return basketDAO.selectBasket(menuVO);
	}
}
