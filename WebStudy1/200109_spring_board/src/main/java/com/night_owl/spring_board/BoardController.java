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
		
		session.removeAttribute("show");

		List<BoardVo> list = boardService.selectList();
				
		model.addAttribute("list", list);
		return "board/board_list";
	}

	@RequestMapping("/board/view.do")
	public String view(int idx, Model model) {
		
		BoardVo vo = boardService.selectOne(idx);
		
		// 새로고침으로 조회수 조작 방지.
		if(session.getAttribute("show")==null) {
			session.setAttribute("show", true);
			
			// 조회수 증가.
			int res = boardService.update_ViewCount(vo);
		}

		model.addAttribute("vo", vo);
		return "board/board_view";
	}
	
	@RequestMapping("/board/board_insert_form.do")
	public String insert_Form() { return "board/board_insert_form"; }

	@RequestMapping("/board/insert.do")
	public String insert(BoardVo vo) {
		String board_ip = request.getRemoteAddr();
		vo.setBoard_ip(board_ip);
		
		//새글 삽입
		int res = boardService.insert(vo); 
	
		return "redirect:list.do";
	}
	
	@RequestMapping("/board/reply_form.do")
	public String reply_Form() { return "board/board_reply_form"; }
	
	@RequestMapping("/board/reply.do")
	public String reply(BoardVo vo) {
		// 현재 보고있는 게시글 정보 얻기.
		BoardVo baseVo = boardService.selectOne(vo.getBoard_idx());
		// 답글 삽입위치 이전 게시글 step 처리.
		int res = boardService.update_Step(baseVo);
		
		// 답글 참조정보 처리.
		vo.setReference_idx(baseVo.getReference_idx());
		vo.setReference_step(baseVo.getReference_step() + 1);
		vo.setReference_depth(baseVo.getReference_depth() + 1);
		
		vo.setBoard_ip(request.getRemoteAddr());
		
		// 답글 삽입.
		res = boardService.insert_Reply(vo);
		
		return "redirect:list.do";
	}

	@RequestMapping("/board/modify_form.do")
	public String modify_Form(int board_idx, Model model) { 
		BoardVo vo = boardService.selectOne(board_idx);
		
		model.addAttribute("vo", vo);
		return "board/board_modify_form"; 
		}

	@RequestMapping("/board/modfiy.do")
	public String modfiy(BoardVo vo) {
		System.out.println(vo.getBoard_idx());
		int res = boardService.update(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("/board/delete.do")
	public String delete(int board_idx) {
		//사용여부 'N' 설정
		int res = boardService.update_Use_YN(board_idx);
		
		return "redirect:list.do";
	}

}
