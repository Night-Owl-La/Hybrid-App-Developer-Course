package com.night_owl.spring_board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;
import vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService; 
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;

	@RequestMapping("/board/list.do")
	public String list(Model model) {
		
		List<BoardVo> list = boardService.selectList();
		
		model.addAttribute("list", list);

		return "board/board_list";
	}

	@RequestMapping("/board/view.do")
	public String view(int idx, Model model) {
		
		BoardVo vo = boardService.selectOne(idx);
		
		// 조회수 증가.
		vo.setBoard_view_count( vo.getBoard_view_count() + 1);
		int res = boardService.update_ViewCount(vo);

		model.addAttribute("vo", vo);
		
		return "board/board_view";
	}
	
	@RequestMapping("/board/board_insert_form.do")
	public String insert_Form() {
		return "board/board_insert_form";
	}
	

	@RequestMapping("/board/insert.do")
	public String insert(BoardVo vo) {
		String board_ip = request.getRemoteAddr();
		vo.setBoard_ip(board_ip);
		
		int res = boardService.insert(vo); 
	
		return "redirect:list.do";
	}
	
	

}
