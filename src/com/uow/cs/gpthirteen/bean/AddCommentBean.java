package com.uow.cs.gpthirteen.bean;

public class AddCommentBean {
	
	private int bug_id;
 
	private int user_id;

		
	private String date;

	private String comment_text;

	private int comment_id;
	
	
	public void setComment_ID(int comment_id) {
			this.comment_id = comment_id;
		}
	public int getComment_ID() {
			return comment_id;
		}
    public void setBug_ID(int bug_id) {
		this.bug_id = bug_id;
	}
	public int getBug_ID() {
		return bug_id;
	}
	
	public void setUser_ID(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_ID() {
		return user_id;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	
	public void setComment_Text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getComment_Text() {
		return comment_text;
	}
	
	
	
}
