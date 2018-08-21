package com.stpl.trainee.assignment4.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetPreparedStatment {
	
	public PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException
	{
		return connection.prepareStatement(sql);
	}

}
