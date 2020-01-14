package vo;

public class BoardVo {

	// 게시판.
	int board_idx;
	String board_title;
	String board_content;
	String board_ip;
	String board_regdate;
	int board_view_count;
	String board_use_yn;

	// 참조글 정보.
	int reference_idx; // 참조중인 게시글의 idx.
	int reference_depth; // 세로 깊이 [삽입 위치에 따라 변함].
	int reference_step; // 답변 순번 [일정하게 증가].

	// 사용자 정보,
	int user_idx;
	String user_name;

	// 댓글 정보.
	int comment_count;

	public BoardVo() {
	}

	// 삽입용
	public BoardVo(String board_title, String board_content, String board_ip, int user_idx, String user_name) {
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_ip = board_ip;
		this.user_idx = user_idx;
		this.user_name = user_name;
	}

	// 수정용
	public BoardVo(int board_idx, String board_title, String board_content, String board_ip) {
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_ip = board_ip;
	}

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_ip() {
		return board_ip;
	}

	public void setBoard_ip(String board_ip) {
		this.board_ip = board_ip;
	}

	public String getBoard_regdate() {
		return board_regdate;
	}

	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}

	public int getBoard_view_count() {
		return board_view_count;
	}

	public void setBoard_view_count(int board_view_count) {
		this.board_view_count = board_view_count;
	}

	public String getBoard_use_yn() {
		return board_use_yn;
	}

	public void setBoard_use_yn(String board_use_yn) {
		this.board_use_yn = board_use_yn;
	}

	public int getReference_idx() {
		return reference_idx;
	}

	public void setReference_idx(int reference_idx) {
		this.reference_idx = reference_idx;
	}

	public int getReference_depth() {
		return reference_depth;
	}

	public void setReference_depth(int reference_depth) {
		this.reference_depth = reference_depth;
	}

	public int getReference_step() {
		return reference_step;
	}

	public void setReference_step(int reference_step) {
		this.reference_step = reference_step;
	}

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

}
