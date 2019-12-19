package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Member_List_Action {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/member/member_List.jsp";
	}

}
