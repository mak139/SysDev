package com.uow.cs.gpthirteen.bean;

public class TeamMemberBean {
	private int projId;
	private int teamId;
	private String teamName;
	private String teamURL;
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamURL() {
		return teamURL;
	}
	public void setTeamURL(String teamURL) {
		this.teamURL = teamURL;
	}
}
