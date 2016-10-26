package com.uow.cs.gpthirteen.bean;

public class ViewCommentBean {
	
	private String name;
    private String start_date;
    private String end_date;
	private int component_id;
	private int project_id;
	private String description;
	private int comment_id;
	private int user_id;
	private String comment_text;
	private String date;
	private String bug_id;
	
	
    public void setComment_ID(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getComment_ID() {
		return comment_id;
	}
	
	public void setUser_ID(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_ID() {
		return user_id;
	}
	
	public void setComment_Text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getComment_Text() {
		return comment_text;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setBug_ID(String bug_id) {
		this.bug_id = bug_id;
	}
	public String getBug_ID() {
		return bug_id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
