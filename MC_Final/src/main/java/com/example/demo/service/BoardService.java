package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO boardDAO;
	
	public List<BoardVO> boardList(){
		return boardDAO.boardList();
	}
	
	public void boardWrite(BoardVO boardVO) throws DataAccessException{
		boardDAO.boardWrite(boardVO);
	}
	public BoardVO viewArticle(int articleNO) {		
		return boardDAO.viewArticle(articleNO);
	}
	
	
	public void update(BoardVO boardVO) {
	      boardDAO.update(boardVO);
	   }
	
	public void delete(BoardVO boardVO) {
		boardDAO.delete(boardVO);
		
	}
}
