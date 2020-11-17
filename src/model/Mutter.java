package model;

import java.io.Serializable;

//MUTTERテーブルのレコードを表すクラス
public class Mutter implements Serializable {
	private int id;			//id
	private String userId;		//ユーザーID
	private String text;		//独り言内容
	private String dateTime	;	//投稿時刻

	public Mutter() {}

	public Mutter(String userId, String text, String dateTime) {
		this.userId = userId;
		this.text = text;
		this.dateTime = dateTime;
	}

	public Mutter(int id, String userId, String text, String dateTime ) {
		this.id = id;
		this.userId = userId;
		this.text = text;
		this.dateTime = dateTime;
	}

	public int getId() { return this.id; }
	public String getUserId() { return this.userId; }
	public String getText() { return this.text; }
	public String getDateTime() { return this.dateTime; }
}