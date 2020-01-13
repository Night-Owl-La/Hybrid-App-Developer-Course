package com.night_owl.spring_board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;
import util.MyConstant;
import util.Paging;
import vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpSession session;

	int nowPage = 1; // 현재 페이지.
	
	@RequestMapping("/board/list.do")
	public String list(Integer page, Model model) {
		
		String search = request.getParameter("search");
		String search_text = request.getParameter("search_text");
		// get page range.
		
		if (page != null) nowPage = page;

		int start = (nowPage - 1) * MyConstant.Board.BLOCKLIST + 1;
		int end = start + MyConstant.Board.BLOCKLIST - 1;

		Map map = new HashMap();
		
		if(search==null) search = "all";
		
		// 검색 조건 핸들링.
		if(!search.equals("all")) {
			if(search.equals("title_name_content")) {
				map.put("title", search_text);
				map.put("name", search_text);
				map.put("content", search_text);
				
				}else if (search.equals("title")) {
					map.put("title", search_text);
				}else if (search.equals("name")) {
					map.put("name", search_text);
				}else if (search.equals("content")) {
					map.put("content", search_text);
				}
		}
		
		map.put("start", start);
		map.put("end", end);
		
		int rowTotal = boardService.selectRowTotal(map);
		
		String search_filter = String.format("list.do?search=%s&search_text=%s", search, search_text);
		String pageMenu = Paging.getPaging(search_filter, nowPage, rowTotal, MyConstant.Board.BLOCKLIST, MyConstant.Board.BLOCKPAGE);
		
		
		// view_count init.
		session.removeAttribute("show");

		// get list.
		List<BoardVo> list = boardService.selectList(map);
		
		model.addAttribute("pageMenu", pageMenu);
		model.addAttribute("list", list);
		return "board/board_list";
	}

	@RequestMapping("/board/view.do")
	public String view(int idx, Model model) {

		BoardVo vo = boardService.selectOne(idx);

		// 새로고침으로 조회수 조작 방지.
		if (session.getAttribute("show") == null) {
			session.setAttribute("show", true);

			// 조회수 증가.
			int res = boardService.update_ViewCount(vo);
		}

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

		// 새글 삽입
		int res = boardService.insert(vo);

		return "redirect:list.do";
	}

	@RequestMapping("/board/reply_form.do")
	public String reply_Form() {
		return "board/board_reply_form";
	}

	@RequestMapping("/board/reply.do")
	public String reply(BoardVo vo, int page, String search, String search_text, Model model) {
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

		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		return "redirect:list.do";
	}

	@RequestMapping("/board/modify_form.do")
	public String modify_Form(int board_idx, Model model) {
		BoardVo vo = boardService.selectOne(board_idx);

		model.addAttribute("vo", vo);
		return "board/board_modify_form";
	}

	@RequestMapping("/board/modfiy.do")
	public String modfiy(BoardVo vo, int page, String search, String search_text, Model model) {
		int res = boardService.update(vo);
		
		model.addAttribute("idx", vo.getBoard_idx());
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		return "redirect:view.do";
	}

	@RequestMapping("/board/delete.do")
	public String delete(int board_idx, int page, String search, String search_text, Model model) {
		// 사용여부 'N' 설정
		int res = boardService.update_Use_YN(board_idx);
		
		model.addAttribute("page", page);
		model.addAttribute("search", search);
		model.addAttribute("search_text", search_text);
		return "redirect:list.do";
	}

}

