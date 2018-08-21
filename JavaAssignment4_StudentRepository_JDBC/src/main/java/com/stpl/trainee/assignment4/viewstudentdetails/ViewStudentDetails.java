package com.stpl.trainee.assignment4.viewstudentdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment4.bean.MarkslDetailsBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;

public class ViewStudentDetails {

	private static final Logger LOGGER = LogManager.getFormatterLogger(ViewStudentDetails.class);
	private final DatabaseConection dbconnectionObject = new DatabaseConection();
	private static final String LINE = "----------------------------------------";
	
	private PreparedStatement stmt;
	private PreparedStatement statement;
	private ResultSet rs;
	private ResultSet rs1;
	
	public ViewStudentDetails()
    {
    	// To fix sonar issue
    }

	public void displayStudentDetails(MarkslDetailsBean addMarkslDetailsBean, String sql)
			throws SQLException {

		final Connection conn = dbconnectionObject.connect();
		

		try{
			
			statement = conn.prepareStatement(sql);

			statement.setString(Constants.ONE, addMarkslDetailsBean.getId());
			rs = statement.executeQuery();

			if (rs.next()) {

				LOGGER.info("*********** Student Details ***********");
				LOGGER.info(LINE);

				String id = rs.getString(Constants.ONE);

				LOGGER.info("Id: " + id.replaceAll("\r\n", ""));
				LOGGER.info("Name: " + rs.getString(Constants.TWO).replaceAll("\r\n", ""));

				LOGGER.info("-----------  MARKS  ------------");
				LOGGER.info("Math: " + rs.getString(Constants.THREE).replaceAll("\r\n", ""));
				LOGGER.info("English: " + rs.getString(Constants.FOUR).replaceAll("\r\n", ""));

				LOGGER.info(LINE);
				LOGGER.info("Total: " + rs.getString(Constants.FIVE).replaceAll("\r\n", ""));

				LOGGER.info(LINE);

			} 
			else {

				LOGGER.info("-----------  0: Rows Found  ------------");

			}
		} 
		finally {
			rs.close();
			statement.close();
			conn.close();
		}

	}

	public boolean isDataFromDataBase(MarkslDetailsBean markslDetailsBean, String sql) throws SQLException {
		
		final Connection con = dbconnectionObject.connect();
		

		try{
			
			stmt = con.prepareStatement(sql);
			stmt.setString(Constants.ONE, markslDetailsBean.getId());
			rs1 = stmt.executeQuery();

			if (rs1.next()) {

				displayStudentDetails(markslDetailsBean, "SELECT * FROM STUDENT_MARKS WHERE STUDENT_ID = ?");
			} 
			else {
				markslDetailsBean.setFlag(Boolean.FALSE);
				LOGGER.info("Student Id doesn't exist, please add student first");
			}
		} 
		finally {
			rs1.close();
			stmt.close();
			con.close();
		}
		return markslDetailsBean.getFlag();
	}


	public boolean hasStudentDetails(String id) throws SQLException {

		MarkslDetailsBean addMarkslDetailsBean = new MarkslDetailsBean();
		addMarkslDetailsBean.setFlag(Boolean.FALSE);
		addMarkslDetailsBean.setId(id);

		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
		return isDataFromDataBase(addMarkslDetailsBean, sql);
	}
}
