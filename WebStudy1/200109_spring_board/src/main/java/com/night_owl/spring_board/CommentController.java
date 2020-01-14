package com.night_owl.spring_board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CommentService;
import util.MyConstant;
import util.Paging;
import vo.CommentVo;

@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	HttpServletRequest request;
	
	int nowPage = 1;
	
	@RequestMapping("/comment/list.do")
	public String list(int board_idx, Integer page, Model model) {
		
		// -- paging. --
		if(page != null) nowPage = page;
				
		int rowTotal = commentService.selectRowTotal(board_idx);
		String pageMenu = Paging.getCommentPaging(nowPage, rowTotal, MyConstant.Comment.BLOCKLIST, MyConstant.Comment.BLOCKPAGE);
		
		// -- get comment list. --
		Map searchOption_Map = new HashMap();
		int start = (nowPage - 1) * MyConstant.Comment.BLOCKLIST + 1;
		int end = start + MyConstant.Comment.BLOCKLIST - 1;
		
		searchOption_Map.put("start", start);
		searchOption_Map.put("end", end);
		searchOption_Map.put("board_idx", board_idx);
		List<CommentVo> list = commentService.selectList(searchOption_Map);
		
		// -- binding. --
		model.addAttribute("pageMenu", pageMenu);
		model.addAttribute("list", list);
		return "board/board_comment_list";
	}
	
	@RequestMapping("/comment/insert.do")
	@ResponseBody
	public Map insert(CommentVo vo) {
		
		String comment_ip = request.getRemoteAddr();
		vo.setComment_ip(comment_ip);
		
		int res = commentService.insert(vo);
		
		String result = (res==1) ? "success" : "fail";
		Map map = new HashMap();
		map.put("result", result);
		
		return map;
	}
	
	@RequestMapping("/comment/delete.do")
	@ResponseBody
	public Map delete(int comment_idx) {
		
		int res = commentService.delete(comment_idx);
		
		String result = (res==1) ? "success" : "fail";
		Map map = new HashMap();
		map.put("result", result);
		
		return map;
	}

}
