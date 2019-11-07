package br.com.unip.conexao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ConnectionFactory {

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("C:\\Properties\\acesso_banco.txt");
		props.load(file);
		return props;

	}

	public ConnectionFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Connection conectar() {

		Connection connection = null;

		try {
			Properties prop = getProp();

			String username = "admin";
			String password = "admin";
			String url = "jdbc:sqlserver://localhost:1433;databaseName=bancoAPS";
			String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

			Class.forName(drivername).newInstance();

			connection = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return connection;
	}

	public static void desconectar(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getClass());
			e.printStackTrace();
		}
	}

	public static void desconectar(Connection conn, PreparedStatement pstm) {
		try {
			if (pstm != null) {
				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			System.out.println("Exceção, causa:" + e.getClass());
			e.printStackTrace();
		}
	}

	public static void desconectar(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {

			if (rs != null) {
				rs.close();
			}

			if (pstm != null) {
				pstm.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			System.out.println("Exceção, causa:" + e.getClass());
			e.printStackTrace();

		}
	}

}
