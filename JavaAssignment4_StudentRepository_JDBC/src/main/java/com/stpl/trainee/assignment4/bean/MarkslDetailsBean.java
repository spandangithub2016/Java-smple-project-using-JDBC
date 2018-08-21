package com.stpl.trainee.assignment4.bean;

public class MarkslDetailsBean {

    String id;
    String name;
    int english;
    int math;
    int tolat_marks;
    
    String sql;
    int result;
    Boolean flag = false;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTolat_marks() {
		return tolat_marks;
	}
	public void setTolat_marks(int tolat_marks) {
		this.tolat_marks = tolat_marks;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
    
    
 
}
