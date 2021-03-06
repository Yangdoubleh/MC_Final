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
							file.transferTo(new File("C:\\0jes\\workspace\\MC_Final\\src\\main\\webapp\\uploadImg\\" + fileName));
						} catch (IllegalStateException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
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
			System.out.println(articleNO+"??? ??? ??????");
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
	  		return "????????? ?????????????????????."; 
	  //	}else {
	  //		return "login~!!!";
	  //	}
		
	   }

	   @RequestMapping("delete")
	   @ResponseBody
	   public String delete(BoardVO boardVO,HttpSession session) {
		   BoardVO boardID = boardService.selectArticleID(boardVO);
		   BoardVO parentVO=(BoardVO) session.getAttribute("article");
		  // System.out.println("delete??????");
		   boardService.delete(boardVO);
			return "????????? ?????? ??????"; 
}
	   @RequestMapping("selectArticleID")
	   @ResponseBody
	   public String selectArticleID(BoardVO boardVO , @CookieValue String memberID,@CookieValue("memberID") String id) {
		   BoardVO boardID = boardService.selectArticleID(boardVO);
		   if (id.equals(boardID.getMemberID())) {
			   return "ok";
		   } else {
			   return "?????? ????????? ???????????? ????????? ????????? ?????????.";
		   }
	   }
}
