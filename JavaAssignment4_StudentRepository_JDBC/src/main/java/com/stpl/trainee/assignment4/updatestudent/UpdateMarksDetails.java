package com.stpl.trainee.assignment4.updatestudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment4.bean.MarkslDetailsBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;

public class UpdateMarksDetails {

    private static final Logger LOGGER = LogManager.getFormatterLogger(UpdateMarksDetails.class);
    private MarkslDetailsBean updateDetailsBean = new MarkslDetailsBean();
    private PreparedStatement stmt;
    private PreparedStatement stmt1;
    private ResultSet rs;
    
    public UpdateMarksDetails()
    {
    	// To fix sonar issue
    }

    public boolean updateStudentDetails(String id, String name, int math, int english) throws SQLException {

        updateDetailsBean.setFlag(Boolean.FALSE);
                
        updateDetailsBean.setId(id);
        updateDetailsBean.setName(name.toUpperCase(Locale.ENGLISH));
        updateDetailsBean.setMath(math);
        updateDetailsBean.setEnglish(english);
        
        int totalMarks = math + english ;
		updateDetailsBean.setTolat_marks(totalMarks);

        DatabaseConection dbConectionObject = new DatabaseConection();
        final Connection con = dbConectionObject.connect();
        
        
		try{
			stmt = con.prepareStatement("SELECT * FROM STUDENT WHERE STUDENT_ID = ?");
			stmt1 = con.prepareStatement("UPDATE STUDENT_MARKS SET STUDENT_NAME=?, "
						+ "MATH=?, ENGLISH=?, TOTAL_MARKS=? WHERE STUDENT_ID= ?");

			stmt.setString(Constants.ONE, updateDetailsBean.getId());

			rs = stmt.executeQuery();

				if (rs.next()) {

					stmt1.setString(Constants.ONE, updateDetailsBean.getName());
					stmt1.setInt(Constants.TWO, updateDetailsBean.getMath());
					stmt1.setInt(Constants.THREE, updateDetailsBean.getEnglish());
					stmt1.setInt(Constants.FOUR, updateDetailsBean.getTolat_marks());
					stmt1.setString(Constants.FIVE, updateDetailsBean.getId());

					updateDetailsBean.setResult(stmt1.executeUpdate());
					updateDetailsBean.setFlag(Boolean.TRUE);
					stmt1.close();

					LOGGER.info("Student Details are upated successfully");

				} 
				else {
					updateDetailsBean.setFlag(Boolean.FALSE);
					LOGGER.info("Student id doesn't exist, please add student first");
				}
		}
		finally {
			
			rs.close();
			stmt.close();
			stmt1.close();
			con.close();
			
		}
		return updateDetailsBean.getFlag();
	}

}
