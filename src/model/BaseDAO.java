package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	protected Connection connection;
	static {
		try{
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public BaseDAO(){
		connection = null;
		
		try{
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/coursera", "postgres",
					"dan");

		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}
}
