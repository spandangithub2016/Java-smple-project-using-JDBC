package com.stpl.trainee.assignment4.deletestudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.stpl.trainee.assignment4.bean.DeleteStudentBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;
import com.stpl.trainee.assignment4.preparedstatement.GetPreparedStatment;

public class DeleteStudent {

	private static final Logger LOGGER = LogManager.getFormatterLogger(DeleteStudent.class);
	private DeleteStudentAllDetails deleteStudentAllDetails = new DeleteStudentAllDetails();
	private DatabaseConection databaseConection = new DatabaseConection();
	private GetPreparedStatment getPreparedStatment = new GetPreparedStatment();
	private PreparedStatement preparedStatement;
	
	public DeleteStudent()
	    {
	    	// To fix sonar issue
	    }
	
	public Boolean deleteFromDataBase(DeleteStudentBean studentBean, String sql) throws SQLException
	{
		final Connection con = databaseConection.connect();
		
		try{

			preparedStatement = getPreparedStatment.getPreparedStatement(con, sql);
			preparedStatement.setString(Constants.ONE, studentBean.getId());
			studentBean.setStudentDeleteResult(preparedStatement.executeUpdate());

		} 
		finally {
			preparedStatement.close();
			con.close();
		}

		String getEmpId = studentBean.getId();
		String sql1 = "DELETE FROM STUDENT_MARKS WHERE STUDENT_ID=?";
		if ((studentBean.getStudentDeleteResult() != Constants.ZERO)
				&& (deleteStudentAllDetails.deleteAllDetails(getEmpId, sql1) != Constants.ZERO)) {

			studentBean.setFlag(Boolean.TRUE);
			LOGGER.info("Student and all other datils are deleted successfully..!");
		}
		else
		{
			LOGGER.info("Student's all other datils are not deleted successfully..!");
		}
		return studentBean.getFlag();
	}

	public Boolean deleteStudent(String id) throws SQLException {

		DeleteStudentBean deleteStudentBean = new DeleteStudentBean();
		
		deleteStudentBean.setFlag(Boolean.FALSE);
		deleteStudentBean.setId(id);
		
		String sql = "DELETE FROM STUDENT WHERE STUDENT_ID=?";
		return deleteFromDataBase(deleteStudentBean, sql);

		
	}
}
