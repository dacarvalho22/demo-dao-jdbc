package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;


public class DB {
	
	private static Connection conexao = null;
	
	public static Connection getConnection() {
		if(conexao == null) {
			try {
				Properties prop = loadProperties();
				String url = prop.getProperty("dburl");
				conexao = DriverManager.getConnection(url, prop);
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conexao;
	}
	
	public static void closeConection() {
		if(conexao != null) {
			try {
				conexao.close();
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}	
	}
	
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeStatementResultSet(Statement st, ResultSet rs) {
		if(st != null && rs != null) {
			try {
				rs.close();
				st.close();				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}	
	}
	
	/*
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}	
	}
	*/
}
