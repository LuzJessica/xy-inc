package br.com.xyinc.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import br.com.xyinc.dao.PontoDAO;
import br.com.xyinc.domain.Pontos;
import br.com.xyinc.factory.ConexaoFactory;
import junit.framework.Assert;

public class StringUnitTests {
	
	@Test
	public void sucessoConexao() throws SQLException {
		
		String USUARIO = "root";
		String SENHA = "root";
		String URL = "jdbc:mysql://localhost:3306/xyinc";
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		conexao = ConexaoFactory.conectar();
		assertTrue(true);
	}
	
	@Test
	public void cadastrarPonto() {
		Pontos ponto = new Pontos();
		ponto.setNome_ponto("Hospital");
		ponto.setCo_X(33L);
		ponto.setCo_Y(12L);
		
		PontoDAO pDAO = new PontoDAO();
		try {
			pDAO.cadastrar(ponto);
			assertTrue(true);
		}catch (SQLException e) {
			assertFalse(true);
		}
	}
	
	
}
