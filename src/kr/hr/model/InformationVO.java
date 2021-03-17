package kr.hr.model;

public class InformationVO {
	
	private String name;
	private String mil_id;
	private int pw;
	private String job;
	private String rank;
	private String s_date;
	private String manager_id;
	public InformationVO() {
		super();
	}
	public InformationVO(String name, String mil_id, int pw, String job, String rank, String s_date,
			String manager_id) {
		this.name = name;
		this.mil_id = mil_id;
		this.pw = pw;
		this.job = job;
		this.rank = rank;
		this.s_date = s_date;
		this.manager_id = manager_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMil_id() {
		return mil_id;
	}
	public void setMil_id(String mil_id) {
		this.mil_id = mil_id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	@Override
	public String toString() {
		return "InformationVO [name=" + name + ", mil_id=" + mil_id + ", pw=" + pw + ", job=" + job + ", rank=" + rank
				+ ", s_date=" + s_date + ", manager_id=" + manager_id + "]";
	}
	
	

}
