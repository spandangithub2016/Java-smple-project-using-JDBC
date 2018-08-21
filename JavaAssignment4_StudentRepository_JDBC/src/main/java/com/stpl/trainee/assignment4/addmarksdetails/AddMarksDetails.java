package com.stpl.trainee.assignment4.addmarksdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment4.bean.MarkslDetailsBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;

public class AddMarksDetails {

	private static final Logger LOGGER = LogManager.getFormatterLogger(AddMarksDetails.class);
	private DatabaseConection dbconnectionObject = new DatabaseConection();
	private MarkslDetailsBean addMarkslDetailsBean = new MarkslDetailsBean();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public AddMarksDetails() {
		// TO fix sonar issue
	}

	public boolean addMarksDetails(String id, int math, int english) throws SQLException {

		addMarkslDetailsBean.setFlag(Boolean.FALSE);
		addMarkslDetailsBean.setId(id);
		addMarkslDetailsBean.setMath(math);
		addMarkslDetailsBean.setEnglish(english);

		int totalMarks = math + english;
		addMarkslDetailsBean.setTolat_marks(totalMarks);
		
		
		final Connection con = dbconnectionObject.connect();
		
		
		try {
			stmt = con.prepareStatement("SELECT * FROM STUDENT WHERE STUDENT_ID = ?");

			stmt.setString(Constants.ONE, addMarkslDetailsBean.getId());
			rs = stmt.executeQuery();

			if (rs.next()) {

				String sql = "INSERT INTO STUDENT_MARKS"
						+ "(STUDENT_ID, STUDENT_NAME, MATH, ENGLISH, TOTAL_MARKS) VALUES(?, ?, ?, ?, ?)";

				addMarkslDetailsBean.setName(rs.getString(Constants.TWO));

				SaveMarksData saveMarksData = new SaveMarksData();
				saveMarksData.saveMarksData(addMarkslDetailsBean, sql);

				addMarkslDetailsBean.setFlag(Boolean.TRUE);
				LOGGER.info("Student marks details are added sucessfully");
			}
			else {

				LOGGER.info("Student id doesn't exist, please add Student first");
			}
		} 
		finally {
			
			rs.close();
			stmt.close();
			con.close();
			
		}

		return addMarkslDetailsBean.getFlag();
	}
}
