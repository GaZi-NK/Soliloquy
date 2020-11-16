package model;

import java.io.Serializable;

//MUTTERテーブルのレコードを表すクラス
public class Mutter implements Serializable {
	private int id;			//id
	private String userId;	//ユーザーID
	private String text;		//つぶやき内容

	public Mutter() {}

	public Mutter(String userId, String text) {
		this.userId = userId;
		this.text = text;
	}

	public Mutter(int id, String userId, String text) {
		this.id = id;
		this.userId = userId;
		this.text = text;
	}

	public int getId() { return this.id; }
	public String getUserName() { return this.userId; }
	public String getText() { return this.text; }
}
