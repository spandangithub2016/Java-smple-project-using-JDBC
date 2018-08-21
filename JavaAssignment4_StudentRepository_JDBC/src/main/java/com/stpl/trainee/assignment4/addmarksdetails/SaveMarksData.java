package com.stpl.trainee.assignment4.addmarksdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stpl.trainee.assignment4.bean.MarkslDetailsBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;
import com.stpl.trainee.assignment4.preparedstatement.GetPreparedStatment;

public class SaveMarksData {

	private DatabaseConection databaseConection = new DatabaseConection();
	private GetPreparedStatment getPreparedStatment = new GetPreparedStatment();
	private PreparedStatement stmt1;
	
	public SaveMarksData()
	{
		// TO fix sonar issue
	}
	    
	public void saveMarksData(MarkslDetailsBean addMarkslDetailsBean, String sql) throws SQLException {
		
		final Connection conn = databaseConection.connect();
		
		try {
			stmt1 = getPreparedStatment.getPreparedStatement(conn, sql);
		

			stmt1.setString(Constants.ONE, addMarkslDetailsBean.getId());
			stmt1.setString(Constants.TWO, addMarkslDetailsBean.getName());
			stmt1.setInt(Constants.THREE, addMarkslDetailsBean.getMath());
			stmt1.setInt(Constants.FOUR, addMarkslDetailsBean.getEnglish());
			stmt1.setInt(Constants.FIVE, addMarkslDetailsBean.getTolat_marks());

			addMarkslDetailsBean.setResult(stmt1.executeUpdate());
			addMarkslDetailsBean.setFlag(Boolean.TRUE);

		}
		finally {
			stmt1.close();
			conn.close();
		}
	}
}