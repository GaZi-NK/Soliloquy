package model;

public class UpdateMutter {
	private int id;			//id
	private String userId;		//ユーザーID
	private String text;		//独り言内容
	private String dateTime	;	//投稿時刻
	private String toText;		//編集後の独り言

	public UpdateMutter(String userId, String text, String dateTime, String toText) {
		this.userId = userId;
		this.text = text;
		this.dateTime = dateTime;
		this.toText = toText;
	}

	public UpdateMutter(int id, String userId, String text, String dateTime, String toText ) {
		this.id = id;
		this.userId = userId;
		this.text = text;
		this.dateTime = dateTime;
		this.toText = toText;
	}

	public int getId() { return this.id; }
	public String getUserId() { return this.userId; }
	public String getText() { return this.text; }
	public String getDateTime() { return this.dateTime; }
	public String getToText() {return this.toText;}

}
