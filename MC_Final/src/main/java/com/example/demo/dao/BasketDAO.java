package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.demo.vo.BasketVO;
=======
import com.example.demo.vo.MenuVO;
>>>>>>> master

@Mapper
@Repository
public interface BasketDAO {
	
<<<<<<< HEAD
	public void insertBasket(BasketVO basketVO) throws DataAccessException;

=======
	public void insertBasket(MenuVO menuVO) throws DataAccessException;
	public MenuVO selectBasket(MenuVO menuVO) throws DataAccessException;
>>>>>>> master
}
