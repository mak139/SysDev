package com.uow.cs.gpthirteen.bean;

public class ViewProjectBean {
	
	private String name;
    private String start_date;
    private String end_date;
	private int component_id;
	private int project_id;
	private String description;
	private String project_name;
	
	
    public void setName(String project_name) {
		this. project_name =  project_name;
	}
	public String getName() {
		return  project_name;
	}
	
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setProjectID(int project_id) {
		this.project_id = project_id;
	}
	public int getProjectID() {
		return project_id;
	}
	
	public void setProject_desc(String description) {
		this.description = description;
	}
	public String getProject_desc() {
		return description;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	
	public void setComponent_id(int component_id) {
		this.component_id = component_id;
	}
	public int getComponent_id() {
		return component_id;
	}

	public void setComponentName(String name) {
		this.name = name;
	}
	public String getComponentName() {
		return name;
	}
}
