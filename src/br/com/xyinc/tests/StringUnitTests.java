package br.com.xyinc.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public void cadastrarPonto() throws SQLException {
		Pontos ponto = new Pontos();
		ponto.setNome_ponto("Hospital");
		ponto.setCo_X(27L);
		ponto.setCo_Y(12L);
		PontoDAO pDAO = new PontoDAO();
		pDAO.cadastrar(ponto);
		assertTrue(true);
		
	}
	
	@Test
	public void deletarPonto() throws SQLException {
		Pontos ponto = new Pontos();
		ponto.setIdPonto(65L);
		PontoDAO pDAO = new PontoDAO();
		pDAO.deletar(ponto);
		assertTrue(true);
	
	}
	
	@Test
	public void atualizarPonto() throws SQLException {
		Pontos ponto = new Pontos();
		ponto.setIdPonto(77L);
		ponto.setNome_ponto("Santa Casa");
		ponto.setCo_X(50L);
		ponto.setCo_Y(38L);
		
		PontoDAO pDAO = new PontoDAO();
		pDAO.atualizar(ponto);
		assertTrue(true);
	}
	
	@Test
	public void listarTodosPontos() throws SQLException{
		
		PontoDAO pDAO = new PontoDAO();
		ArrayList<Pontos> lista = pDAO.listar();
		System.out.println("LISTA DE TODOS");
		for(Pontos ponto : lista) {
			System.out.println(ponto);
		}
		assertTrue(true);
	}
	
	@Test
	public void listarPorProximidade() throws SQLException {
		
		PontoDAO pDAO = new PontoDAO();
		Pontos ponto = new Pontos();
		
		ponto.setCo_X_ref(20L);
		ponto.setCo_Y_ref(10L);
		ponto.setdMax(10L);
		
		ArrayList<Pontos> lista = pDAO.listarPorProximidade(ponto);
		System.out.println("LISTA POR PROXIMIDADE");
		for(Pontos pontos : lista) {
			
			System.out.println(pontos);
		}
		assertTrue(true);	
	}
	
	
	
}
