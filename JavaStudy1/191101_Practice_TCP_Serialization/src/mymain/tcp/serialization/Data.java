package mymain.tcp.serialization;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
	public static final int IN 		= 1;
	public static final int OUT 	= 2;
	public static final int MSG 	= 3;
	public static final int LIST 	= 4;
	public static final int DRAW 	= 5;
	
	public int 			protocol;
	public String 		nick_name;
	public String 		message;
	public List<String> userList;
	
	public int x;
	public int y;
	public int thick;
	public int color;
	
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getUserList() {
		return userList;
	}
	public void setUserList(List<String> userList) {
		this.userList = userList;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getThick() {
		return thick;
	}
	public void setThick(int thick) {
		this.thick = thick;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	
}
