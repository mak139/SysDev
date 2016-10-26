package com.uow.cs.gpthirteen.bean;

public class ViewBugDetailBean {
	
	private String bug_id;
 
	private int user_id;

	private int project_id;

	private int component_id;

	private int subscriber_group_id;

	private String reported_date;

	private String code;

	private String description;

	private String summary;
	
	private String priority;
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;

	private String comment;
	
	
    public void setBug_ID(String bug_id) {
		this.bug_id = bug_id;
	}
	public String getBug_ID() {
		return bug_id;
	}
	
	public void setUser_ID(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_ID() {
		return user_id;
	}
	public void setProjectID(int project_id) {
		this.project_id = project_id;
	}
	public int getProjectID() {
		return project_id;
	}
		
	public void setComponent_ID(int component_id) {
		this.component_id = component_id;
	}
	public int getComponent_ID() {
		return component_id;
	}

	public void setSubscriberGroupID(int subscriber_group_id) {
		this.subscriber_group_id = subscriber_group_id;
	}
	public int getSubscriberGroupID() {
		return subscriber_group_id;
	}
	
	public void setReported_Date(String reported_date) {
		this.reported_date = reported_date;
	}
	public String getReported_Date() {
		return reported_date;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSummary() {
		return summary;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
