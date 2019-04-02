package br.com.xyinc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.xyinc.domain.Pontos;
import br.com.xyinc.factory.ConexaoFactory;

public class PontoDAO {

	public void cadastrar(Pontos ponto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO pontos_de_interesse ");
		sql.append("(nome_ponto, co_x, co_y) ");
		sql.append("VALUES (? , ? , ?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());

		ps.setString(1, ponto.getNome_ponto());
		ps.setString(2, ponto.getCo_X());
		ps.setString(3, ponto.getCo_Y());
		ps.executeUpdate();
	}

	public void deletar(Pontos ponto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM pontos_de_interesse ");
		sql.append("WHERE idPonto = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ps.setLong(1, ponto.getIdPonto());
		ps.executeUpdate();
	}
	
	public void atualizar (Pontos ponto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE pontos_de_interesse ");
		sql.append("SET nome_ponto = ?, co_x = ?, co_y = ?");
		sql.append("WHERE idPonto = ?");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ps.setString(1, ponto.getNome_ponto());
		ps.setString(2, ponto.getCo_X());
		ps.setString(3, ponto.getCo_Y());
		ps.setLong(4, ponto.getIdPonto());
		ps.executeUpdate();
	}

	public static void main(String[] args) {

		PontoDAO pDAO = new PontoDAO();
		Pontos p = new Pontos();

		/*
		 * TESTE INSERÇÃO
		 * 
		 * 
		 * 
		 * 
		 * try {
		 * 
		 * p.setNome_ponto("Lanchonete"); p.setCo_X("27"); p.setCo_Y("12");
		 * pDAO.cadastrar(p); System.out.println("Ponto cadastrado com sucesso!");
		 * }catch (SQLException e) {
		 * System.out.println("Não foi possivel cadastrar o ponto!");
		 * e.printStackTrace(); } }
		 */

		/*
		 * TESTE REMOÇÃO
		 * 
		 * p.setIdPonto(9L); try { pDAO.deletar(p);
		 * System.out.println("Ponto deletado com sucesso!"); }catch (SQLException e) {
		 * System.out.println("Não foi possível deletar o ponto!"); e.printStackTrace();
		 * } // TODO: handle exception }
		 * 
		 */
		
		//TESTE ATUALIZAÇÃO
		
		p.setIdPonto(1L);
		p.setNome_ponto("Posto");
		p.setCo_X("31");
		p.setCo_Y("18");
		
		try{
			pDAO.atualizar(p);
			System.out.println("Ponto atualizado com sucesso!");
			
		}catch(SQLException e) {
			System.out.println("Ponto não pode ser atualizado!");
			e.printStackTrace();
		}
		

	}
}
