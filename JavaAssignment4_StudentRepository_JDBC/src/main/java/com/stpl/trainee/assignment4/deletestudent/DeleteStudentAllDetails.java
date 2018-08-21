package com.stpl.trainee.assignment4.deletestudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stpl.trainee.assignment4.bean.DeleteStudentBean;
import com.stpl.trainee.assignment4.connection.DatabaseConection;
import com.stpl.trainee.assignment4.constants.Constants;

public class DeleteStudentAllDetails {

    private DeleteStudentBean deleteStudentBean = new DeleteStudentBean();
    private PreparedStatement stmt;
    
    public DeleteStudentAllDetails()
    {
    	// To fix sonar issue
    }

    public int deleteAllDetails(String id, String sql) throws SQLException {

        DatabaseConection dbConectionObject = new DatabaseConection();
        final Connection con = dbConectionObject.connect();
		
        try{
        	stmt = con.prepareStatement(sql);
            stmt.setString(Constants.ONE, id);
            deleteStudentBean.setStudentAllDetailsDeleteResult(stmt.executeUpdate());

        }
        finally {
        	stmt.close();
			con.close();
		}
        return deleteStudentBean.getStudentAllDetailsDeleteResult();
    }

}
