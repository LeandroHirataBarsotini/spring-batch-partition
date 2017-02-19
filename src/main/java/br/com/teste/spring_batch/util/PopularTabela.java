package br.com.teste.spring_batch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class PopularTabela {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String STR_CONN = "jdbc:mysql://localhost:3306/teste-spring-batch";
	private static final String USER = "root";
	private static final String PASS = "Teste123@";

	public static void main(String[] argv) {

		try {

			popular(100);

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

	private static void popular(int qtLinha) throws Exception {

		Connection conn = null;
		Statement stm = null;

		try {

			conn = getConn();
			stm = conn.createStatement();

			for (int i = 1; i <= qtLinha; i++) {

				String sql = "INSERT INTO `teste-spring-batch`.usuario (id_usuario, nom_usuario, des_email) VALUES (':id',':name',':email');";

				sql = sql.replaceAll(":id", String.valueOf(i));
				sql = sql.replaceAll(":name", "usuario_" + i);
				sql = sql.replaceAll(":email", "usuario_" + i + "@vixi.com");

				//System.out.println(sql);

				stm.addBatch(sql);

			}

			stm.executeBatch();

			System.out.println("Cabo");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		} finally {

			if (stm != null) {
				stm.close();
			}

			if (conn != null) {
				conn.close();
			}

		}

	}

	private static Connection getConn() {

		Connection conn = null;

		try {

			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			conn = DriverManager.getConnection(STR_CONN, USER, PASS);

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return conn;

	}
	
}
