package org.muthaka.dairy.Generators;
import java.sql.*;

/**
 * Created by MUTHAKA on 3/19/2015.
 */


public class CowId {

	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String cow="";
	int cw=0, c;
	public String cowid() throws Exception {


		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyFarm?user=root&password=root");

			// Statements allow to issue SQL queries to the database
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT COUNT(*) FROM cowregistration");

			while (resultSet.next()) {
				cw = resultSet.getInt(1);

			}
		}

		catch (Exception e)

		{
			e.printStackTrace();

		}

		c = cw+1;
		cow = ("D00")+c;
		return (cow);
		}
}




