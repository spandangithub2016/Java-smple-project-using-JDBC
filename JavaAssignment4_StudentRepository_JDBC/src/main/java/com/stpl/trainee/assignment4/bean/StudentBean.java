package com.stpl.trainee.assignment4.bean;

public class StudentBean {
    
	String id;
	String name;
	String sqlString;
	int result;
	boolean flag;
	
	
	public StudentBean() {
		this.flag = false;
	}
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getSqlString() {
		return sqlString;
	}
	public void setSqlString(String sqlString) {
		this.sqlString = sqlString;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
  
}
