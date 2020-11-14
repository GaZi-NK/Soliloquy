package model;

import java.io.Serializable;

//ユーザーに関する情報を持つJavaBeans
public class User implements Serializable {
	private String userId; //ユーザー名
	private String pass; //パスワード

	public User() {}
	public User(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() { return this.userId; }
	public String getPass() { return this.pass; }
}