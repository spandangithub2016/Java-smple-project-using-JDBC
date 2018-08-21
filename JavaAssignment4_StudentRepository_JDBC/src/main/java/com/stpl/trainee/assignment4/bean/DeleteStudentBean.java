package com.stpl.trainee.assignment4.bean;

public class DeleteStudentBean {

    String id;
    
    int studentDeleteResult;
    int studentAllDetailsDeleteResult;

    String sql;
    Boolean flag;
    
    
	public String getId() {
		return id;
	}
	public void setId(String empId) {
		this.id = empId;
	}
	public int getStudentDeleteResult() {
		return studentDeleteResult;
	}
	public void setStudentDeleteResult(int studentDeleteResult) {
		this.studentDeleteResult = studentDeleteResult;
	}
	public int getStudentAllDetailsDeleteResult() {
		return studentAllDetailsDeleteResult;
	}
	public void setStudentAllDetailsDeleteResult(int studentAllDetailsDeleteResult) {
		this.studentAllDetailsDeleteResult = studentAllDetailsDeleteResult;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
    
   
    
}
