package kr.hr.model;

public class AllowVO {
	
	private String manager_id;
	private int sub_number;
	private String yn;
	private String note;
	public AllowVO() {
		super();
	}
	public AllowVO(String manager_id, int sub_number, String yn, String note) {
		super();
		this.manager_id = manager_id;
		this.sub_number = sub_number;
		this.yn = yn;
		this.note = note;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public int getSub_number() {
		return sub_number;
	}
	public void setSub_number(int sub_number) {
		this.sub_number = sub_number;
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
	@Override
	public String toString() {
		return "AllowVO [manager_id=" + manager_id + ", sub_number=" + sub_number + ", yn=" + yn + ", note=" + note
				+ "]";
	}
	

}
