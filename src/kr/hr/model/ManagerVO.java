package kr.hr.model;

public class ManagerVO {
	private String dept;
	private String position;
	private String manager_id;
	private String manager_name;
	private int manager_pw;
	public ManagerVO() {
	}
	public ManagerVO(String manager_id, int manager_pw) {
		this.manager_id = manager_id;
		this.manager_pw = manager_pw;
	}
	public ManagerVO(String dept, String position, String manager_id, String manager_name, int manager_pw) {
		this.dept = dept;
		this.position = position;
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_pw = manager_pw;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public int getManager_pw() {
		return manager_pw;
	}
	public void setManager_pw(int manager_pw) {
		this.manager_pw = manager_pw;
	}
	@Override
	public String toString() {
		return "ManagerVO [dept=" + dept + ", position=" + position + ", manager_id=" + manager_id + ", manager_name="
				+ manager_name + ", manager_pw=" + manager_pw + "]";
	}
	
	
}
