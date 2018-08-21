package com.stpl.trainee.assignment4.addstudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment4.bean.StudentBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;
import com.stpl.trainee.assignment4.preparedstatement.GetPreparedStatment;

public class AddStudent {

    private static final Logger LOGGER = LogManager.getFormatterLogger(AddStudent.class);
    private DatabaseConection dbconnectionObject = new DatabaseConection();
    private GetPreparedStatment getPreparedStatment = new GetPreparedStatment();
    private PreparedStatement stmt;
    
    public AddStudent()
    {
    	// TO fix sonar issue
    }
    
    public boolean storeStudentData(StudentBean studentBean, String sql) throws SQLException{

    	boolean flag = false;
    	final Connection con = dbconnectionObject.connect();
    	
		
    	try {
    		stmt = getPreparedStatment.getPreparedStatement(con, sql);
    		
            stmt.setString(Constants.ONE, studentBean.getId());
            stmt.setString(Constants.TWO, studentBean.getName());

            studentBean.setResult(stmt.executeUpdate());
            
            LOGGER.info("Student added successfully..!");
            flag = true;
        } 
    	
        catch (SQLException e) {
            LOGGER.info("Student Id: " + studentBean.getId() + " is already exist, Error: " + e);
        }
    	finally {
			
				stmt.close();
				con.close();
			 
		}
        return flag;
    	
    }

    public boolean addStudent(String id, String name) throws SQLException {

    		StudentBean addStudentBean = new StudentBean();
    	
            addStudentBean.setId(id);
            addStudentBean.setName(name);
            
            String sql = "INSERT INTO STUDENT VALUES (?, ?)";
            return storeStudentData(addStudentBean, sql);
    }
    
    
}
