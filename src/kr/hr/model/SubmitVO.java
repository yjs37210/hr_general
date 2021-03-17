package kr.hr.model;

public class SubmitVO {
	private int sub_date;
	private int end_date;
	private String reason;
	private String vac_type;
	private int sub_number;
	private String mil_id;
	// view
	private String rank;
	private String name;
	private String job;
	// view2
	private String yn;
	private String note;
	private String manager_id;
	public SubmitVO() {
		super();
	}
	public SubmitVO(int sub_date, int end_date, String reason, String vac_type, String mil_id) {
		super();
		this.sub_date = sub_date;
		this.end_date = end_date;
		this.reason = reason;
		this.vac_type = vac_type;
		this.mil_id = mil_id;
	}
	public SubmitVO(int sub_date, int end_date, String reason, String vac_type, int sub_number, String mil_id) {
		super();
		this.sub_date = sub_date;
		this.end_date = end_date;
		this.reason = reason;
		this.vac_type = vac_type;
		this.sub_number = sub_number;
		this.mil_id = mil_id;
	}
	public SubmitVO(int sub_date, String reason, String vac_type, String mil_id, String name, String yn, String note,
			String manager_id) {
		super();
		this.sub_date = sub_date;
		this.reason = reason;
		this.vac_type = vac_type;
		this.mil_id = mil_id;
		this.name = name;
		this.yn = yn;
		this.note = note;
		this.manager_id = manager_id;
	}
	public SubmitVO(int sub_date, int end_date, String reason, String vac_type, String mil_id,
			String rank, String name, String job) {
		super();
		this.sub_date = sub_date;
		this.end_date = end_date;
		this.reason = reason;
		this.vac_type = vac_type;
		this.mil_id = mil_id;
		this.rank = rank;
		this.name = name;
		this.job = job;
	}
	public SubmitVO(int sub_date, int end_date, String reason, String vac_type, int sub_number, String mil_id,
			String rank, String name, String job) {
		super();
		this.sub_date = sub_date;
		this.end_date = end_date;
		this.reason = reason;
		this.vac_type = vac_type;
		this.sub_number = sub_number;
		this.mil_id = mil_id;
		this.rank = rank;
		this.name = name;
		this.job = job;
	}
	public int getSub_date() {
		return sub_date;
	}
	public void setSub_date(int sub_date) {
		this.sub_date = sub_date;
	}
	public int getEnd_date() {
		return end_date;
	}
	public void setEnd_date(int end_date) {
		this.end_date = end_date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getVac_type() {
		return vac_type;
	}
	public void setVac_type(String vac_type) {
		this.vac_type = vac_type;
	}
	public int getSub_number() {
		return sub_number;
	}
	public void setSub_number(int sub_number) {
		this.sub_number = sub_number;
	}
	public String getMil_id() {
		return mil_id;
	}
	public void setMil_id(String mil_id) {
		this.mil_id = mil_id;
	}
	
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getYn() {
		return yn;
	}
	public void setYn(String yn) {
		this.yn = yn;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	@Override
	public String toString() {
		return "SubmitVO [sub_date=" + sub_date + ", end_date=" + end_date + ", reason=" + reason + ", vac_type="
				+ vac_type + ", sub_number=" + sub_number + ", mil_id=" + mil_id + ", rank=" + rank + ", name=" + name
				+ ", job=" + job + "]";
	}
	
	

}
