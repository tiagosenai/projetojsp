package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBD {
	private static String banco = "jdbc:mysql://localhots:3306/projetojsp";
	//private static String banco = "jdbc:postgresql://localhots:5433/projetojsp";
	private static String usuario = "root";
	private static String senha = "root";
	private static Connection conn = null;
	
	public static Connection getConnection() {
		return conn;
	}
	
	static {
		conectar();
	}
	
	public SingleConnectionBD() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if (conn == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Versão 5 do Mysql
				//Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(usuario, senha, banco);
				conn.setAutoCommit(false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
