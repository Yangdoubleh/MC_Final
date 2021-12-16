package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BasketDAO;
import com.example.demo.vo.BasketVO;

@Service
public class BasketService {
	
	@Autowired
	BasketDAO basketDAO;
	
	public void insertBasket(BasketVO basketVO) {
		basketDAO.insertBasket(basketVO);
	}
}