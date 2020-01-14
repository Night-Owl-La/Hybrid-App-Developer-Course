package util;

/*
        nowPage:현재페이지
        rowTotal:전체데이터갯수
        blockList:한페이지당 게시물수
        blockPage:한화면에 나타낼 페이지 목록수
 */
public class Paging {
	public static String getPaging(String pageURL, int nowPage, int rowTotal, int blockList, int blockPage) {

		int totalPage; // 전체페이지수 
		int startPage; // 시작페이지번호
		int endPage; // 마지막페이지번호

		boolean isPrevPage = false;
		boolean isNextPage = false;

		// 전체 페이지 수 구하기
		totalPage = (rowTotal / blockList);
		if (rowTotal % blockList != 0) totalPage++;

		// _abnormal: (현재 페이지  > 전체 페이지 수) then 현재 페이지 수 = 전체 페이지 수.
		if (nowPage > totalPage) nowPage = totalPage;

		// 시작 페이지와 마지막 페이지를 구함.
		startPage = ((nowPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1; //

		// _abnormal: (마지막 페이지 수 > 전체 페이지 수) then 마지막 페이지 = 전체 페이지 수.
		if (endPage > totalPage) endPage = totalPage;

		// 다음 페이징 조건 : 마지막페이지 < 전체페이지.
		if (endPage < totalPage) isNextPage = true;
		// 이전 페이징 조건 : 시작페이지 > 1.
		if (startPage > 1) isPrevPage = true;

		StringBuffer sb = new StringBuffer(); // 작업 완료된 페이지 HTML코드를 저장할 곳
//-----그룹페이지처리 이전 --------------------------------------------------------------------------------------------		
		if (isPrevPage) {
			sb.append("<a href ='" + pageURL + "&page=");
			sb.append(startPage - 1);
			sb.append("'>◀</a>");
		} else
			sb.append("◀");

//------페이지 목록 출력 -------------------------------------------------------------------------------------------------
		sb.append("|");
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) break;
			if (i == nowPage) { // 현재 있는 페이지
				sb.append("&nbsp;<b><font color='red'>");
				sb.append(i);
				sb.append("</font></b>");
			} else {// 현재 페이지가 아니면
				sb.append("&nbsp;<a href='" + pageURL + "&page=");
				sb.append(i);
				sb.append("'>");
				sb.append(i);
				sb.append("</a>");
			}
		} // end for

		sb.append("&nbsp;|");

//-----그룹페이지처리 다음 ----------------------------------------------------------------------------------------------
		if (isNextPage) {
			sb.append("<a href='" + pageURL + "&page=");
			sb.append(endPage + 1);
			sb.append("'>▶</a>");
		} else
			sb.append("▶");
//---------------------------------------------------------------------------------------------------------------------	    

		return sb.toString();
	}
}