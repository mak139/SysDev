package com.uow.cs.gpthirteen.bean;

public class ViewPatchBean {
	
	
 
	private int patch_id;
	private String patch_version;
	private String bug_id;
	private int user_id;
	private String file;
	private String review_status;
	
	
    public void setPatch_ID(int patch_id) {
		this.patch_id = patch_id;
	}
	public int getPatch_ID() {
		return patch_id;
	}
	
	public void setPatch_Version(String patch_version) {
		this.patch_version = patch_version;
	}
	public String getPatch_Version() {
		return patch_version;
	}
	
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
	public void setFile(String file) {
		this.file = file;
	}
	public String getFile() {
		return file;
	}
	public void setReview_Status(String review_status) {
		this.review_status = review_status;
	}
	public String getReview_Status() {
		return review_status;
	}

}
