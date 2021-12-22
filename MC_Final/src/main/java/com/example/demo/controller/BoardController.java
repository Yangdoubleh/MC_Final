package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.service.BasketService;
import com.example.demo.service.BoardService;

import com.example.demo.vo.BoardVO;
import com.example.demo.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("boardList")	
	public ModelAndView boardList() {
		
		List<BoardVO> list=boardService.boardList();
		System.out.println("boardList : "+list.size());
		ModelAndView mav=new ModelAndView("boardList");
		mav.addObject("boardList", list);
		return mav;
		
	}
	
	
	@RequestMapping("boardWriteForm")	
	public String boardWriteForm() {			
		return "boardWriteForm";		
	}

	
	  @RequestMapping("boardWrite")
		public RedirectView boardWrite(BoardVO boardVO, MultipartFile file) {
			
			String fileName = file.getOriginalFilename(); 
			if (!fileName.equals("")) {
				 boardVO.setFileName(fileName);
				 try {
					 File dir = new File("~/0jes/upload");
					 if(!dir.exists()) {
					      //Creating the directory
					      boolean bool = dir.mkdir();
					      if(bool){
					         System.out.println("Directory created successfully");
					         
					      }else{
					         System.out.println("Sorry couldn’t create specified directory");
					      }
					 }
					file.transferTo(new File("~/0jes/upload/" + fileName));
				 }
				catch (IllegalStateException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			
				System.out.println(boardVO);
				boardService.boardWrite(boardVO);
			 
			
			return new RedirectView("boardList");

 
		}
	  
	  @RequestMapping("viewArticle")	
		public ModelAndView viewArticle(int articleNO) {
			System.out.println(articleNO+"번 글 보기");
			BoardVO boardVO = boardService.viewArticle(articleNO);
			ModelAndView mav = new ModelAndView();
			mav.setViewName("viewArticle");
			mav.addObject("article", boardVO);
			return mav;
		}

	
	  
	  @RequestMapping("updateArticleForm")
	   public String updateForm() {
	      return "updateArticleForm";
	   }
	   
	   @RequestMapping("updateArticle")
	   @ResponseBody
	   public String update(BoardVO updateVO,HttpSession session) {
	      System.out.println(updateVO);
	     //MemberVO memberVO= (MemberVO) session.getAttribute("memberVO");
	  	//if(memberVO!=null) {
	  		boardService.update(updateVO);
	  		return "저장이 완료되었습니다."; 
	  //	}else {
	  //		return "login~!!!";
	  //	}
		
	   }

	   @RequestMapping("delete")
	   @ResponseBody
	   public String delete(BoardVO boardVO,HttpSession session) {
		   BoardVO boardID = boardService.selectArticleID(boardVO);
		   BoardVO parentVO=(BoardVO) session.getAttribute("article");
		  // System.out.println("delete호출");
		   boardService.delete(boardVO);
			return "게시글 삭제 완료"; 
}
	   @RequestMapping("selectArticleID")
	   @ResponseBody
	   public String selectArticleID(BoardVO boardVO , @CookieValue String memberID,@CookieValue("memberID") String id) {
		   BoardVO boardID = boardService.selectArticleID(boardVO);
		   if (id.equals(boardID.getMemberID())) {
			   return "ok";
		   } else {
			   return "다른 사람의 게시글은 수정이 불가능 합니다.";
		   }
	   }
}
