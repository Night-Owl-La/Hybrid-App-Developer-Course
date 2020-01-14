package vo;

public class CommentVo {
	// comment.
	int comment_idx;
	String comment_content;
	String comment_ip;
	String comment_regdate;

	// user.
	int user_idx;
	String user_name;

	// board.
	int board_idx;

	public CommentVo() {
	}

	public CommentVo(String comment_content, String comment_ip, int user_idx, String user_name, int board_idx) {
		this.comment_content = comment_content;
		this.comment_ip = comment_ip;
		this.user_idx = user_idx;
		this.user_name = user_name;
		this.board_idx = board_idx;
	}

	public int getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_ip() {
		return comment_ip;
	}

	public void setComment_ip(String comment_ip) {
		this.comment_ip = comment_ip;
	}

	public String getComment_regdate() {
		return comment_regdate;
	}

	public void setComment_regdate(String comment_regdate) {
		this.comment_regdate = comment_regdate;
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

	public int getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}

}
