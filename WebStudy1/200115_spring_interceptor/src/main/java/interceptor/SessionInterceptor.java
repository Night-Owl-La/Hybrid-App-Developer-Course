package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{

	public SessionInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		HttpSession session = request.getSession();
		
		if(uri.contains("admin") || uri.contains("adult")){
			Object user = session.getAttribute("user");
			if(user==null) {
				System.out.println("ggg");
				response.sendRedirect("../member/login_form.do");
				return false;
			}
		}
		
		return super.preHandle(request, response, handler);
	}
	
	

}
