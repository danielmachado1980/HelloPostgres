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
			System.out.println("Onde est� seu PostgreSQL JDBC Driver? "
					+ "Inclua-o ao Build Path!");
			e.printStackTrace();
		}
	}
	
	public BaseDAO(){
		connection = null;
		System.out.println("-------- PostgreSQL "
				+ "JDBC Teste de Conex�o ------------");
				
		System.out.println("PostgreSQL JDBC Driver Registrado!");

		try{
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/coursera", "postgres",
					"dan");

		} catch (SQLException e) {
			System.out.println("Conex�o falhou! Verifique a sa�da no console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("Tudo pronto para trabalhar!");
		} else {
			System.out.println("Falha ao tentar conex�o!");
		}
	}
}
