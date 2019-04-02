package br.com.xyinc.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	private static String URL = "jdbc:mysql://localhost:3306/xyinc";
	
	public static Connection conectar() throws SQLException {
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	
	public static void main (String[] args) {
		try {
			ConexaoFactory.conectar();
			System.out.println("Conectado com BD com sucesso");
		}catch(SQLException e) {
			System.out.println("Não foi possivel conectar ao BD!");
			e.printStackTrace();
		}
	}
	
}
