package com.company.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.company.Spring_MVC_Board.board.BoardDAO;
import com.company.Spring_MVC_Board.board.BoardDO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("전체 게시글 목록 보기");
		
		String searchField = ""; // 검색 대상(제목 또는 작성자)
		String searchText = ""; // 검색 텍스트 객체 레퍼런스 변수

		if (request.getParameter("searchCondition") != "" 
				&& request.getParameter("searchKeyword") != "") { // &&(and)

			searchField = request.getParameter("searchCondition");
			searchText = request.getParameter("searchKeyword");
		}
		// BoardDAO 클래스 객체 생성
		BoardDO boardDO = new BoardDO();
		BoardDAO boardDAO = new BoardDAO();

		List<BoardDO> boardList = boardDAO.getBoardList(searchField, searchText);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		
		return mav;
	}

}
