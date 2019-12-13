package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MyLocationCollector;
import vo.LocationItem;

@WebServlet("/search.do")
public class SearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재 자신의 위치정보 얻기
		String s_lat = request.getParameter("latitude");
		String s_lon = request.getParameter("longitude");
		String search = request.getParameter("search");
		double latitude = 0, longitude=0;
		
		List<LocationItem> list = null;
		
		//검색반경
		int range = 10000;
		
		if(search!=null && !search.isEmpty() && !s_lat.isEmpty()  && !s_lon.isEmpty()){
			latitude =  Double.parseDouble(s_lat);
			longitude = Double.parseDouble(s_lon);
			
			list = MyLocationCollector.getLocationItems(search, latitude, longitude, range); //주소 검색.
			
		}
		
		//System.out.println(list.size());
		//request binding
		request.setAttribute("list", list);
		
		
		//forward
		request.getRequestDispatcher("local_list.jsp")
		       .forward(request, response);
		
		
	}

}
