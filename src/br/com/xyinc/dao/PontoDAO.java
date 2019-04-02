package br.com.xyinc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Pontos> listar(Pontos ponto) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idPonto, nome_ponto, co_x, co_y ");
		sql.append("FROM pontos_de_interesse ");
		sql.append("WHERE co_x LIKE ?" );
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ps.setString(1, ponto.getCo_X());
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Pontos> lista = new ArrayList<Pontos>();
		
		while(rs.next()) {
			Pontos p = new Pontos();
			p.setIdPonto(rs.getLong("idPonto"));
			p.setNome_ponto(rs.getString("nome_ponto"));
			p.setCo_X(rs.getString("co_x"));
			p.setCo_Y(rs.getString("co_y"));
			
			lista.add(p);
		}
		return lista;
		
	}

	public static void main(String[] args) {

		PontoDAO pDAO = new PontoDAO();
		Pontos p = new Pontos();

		/*
		 * TESTE INSER��O
		 * 
		 * 
		 * 
		 * 
		 * try {
		 * 
		 * p.setNome_ponto("Lanchonete"); p.setCo_X("27"); p.setCo_Y("12");
		 * pDAO.cadastrar(p); System.out.println("Ponto cadastrado com sucesso!");
		 * }catch (SQLException e) {
		 * System.out.println("N�o foi possivel cadastrar o ponto!");
		 * e.printStackTrace(); } }
		 */

		/*
		 * TESTE REMO��O
		 * 
		 * p.setIdPonto(9L); try { pDAO.deletar(p);
		 * System.out.println("Ponto deletado com sucesso!"); }catch (SQLException e) {
		 * System.out.println("N�o foi poss�vel deletar o ponto!"); e.printStackTrace();
		 * } // TODO: handle exception }
		 * 
		 */
		
		/* TESTE ATUALIZA��O
		
		p.setIdPonto(1L);
		p.setNome_ponto("Posto");
		p.setCo_X("31");
		p.setCo_Y("18");
		
		try{
			pDAO.atualizar(p);
			System.out.println("Ponto atualizado com sucesso!");
			
		}catch(SQLException e) {
			System.out.println("Ponto n�o pode ser atualizado!");
			e.printStackTrace();
		}
		
		*/
		
		//TESTE LISTAR
		
		p.setCo_X("31");
		try {
			ArrayList<Pontos>lista = pDAO.listar(p);
			for(Pontos ponto : lista) {
			System.out.println(ponto);
			}
			
		}catch (SQLException e) {
			System.out.println("N�o foi possivel listar!");
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
