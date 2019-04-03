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
		ps.setLong(2, ponto.getCo_X());
		ps.setLong(3, ponto.getCo_Y());
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

	public void atualizar(Pontos ponto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE pontos_de_interesse ");
		sql.append("SET nome_ponto = ?, co_x = ?, co_y = ? ");
		sql.append("WHERE idPonto = ?");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		ps.setString(1, ponto.getNome_ponto());
		ps.setLong(2, ponto.getCo_X());
		ps.setLong(3, ponto.getCo_Y());
		ps.setLong(4, ponto.getIdPonto());
		ps.executeUpdate();
	}

	public ArrayList<Pontos> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idPonto, nome_ponto, co_x, co_y ");
		sql.append("FROM pontos_de_interesse ");
		sql.append("ORDER BY idPonto ASC");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		ArrayList<Pontos> lista = new ArrayList<Pontos>();

		while (rs.next()) {
			Pontos p = new Pontos();
			p.setIdPonto(rs.getLong("idPonto"));
			p.setNome_ponto(rs.getString("nome_ponto"));
			p.setCo_X(rs.getLong("co_x"));
			p.setCo_Y(rs.getLong("co_y"));

			lista.add(p);
		}
		return lista;

	}

	public ArrayList<Pontos> listarPorProximidade(Pontos ponto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idPonto, nome_ponto, co_x, co_y ");
		sql.append("FROM pontos_de_interesse ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement ps = conexao.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();
		ArrayList<Pontos> lista = new ArrayList<Pontos>();

		while (rs.next()) {
			Pontos p = new Pontos();
			p.setIdPonto(rs.getLong("idPonto"));
			p.setNome_ponto(rs.getString("nome_ponto"));
			p.setCo_X(rs.getLong("co_x"));
			p.setCo_Y(rs.getLong("co_y"));
			p.setCo_X_ref(ponto.getCo_X_ref());
			p.setCo_Y_ref(ponto.getCo_Y_ref());
			p.setdMax(ponto.getdMax());

			if (p.getCo_X() <= p.getCo_X_ref() + p.getdMax() && p.getCo_Y() <= p.getCo_Y_ref() + p.getdMax()) {

				lista.add(p);
			}
		}
		return lista;

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

		
		  /*TESTE ATUALIZAÇÃO
		  
		   
		   p.setNome_ponto("Posto"); 
		   p.setCo_X(21L); 
		   p.setCo_Y(18L);
		   p.setIdPonto(76L);
		  
		  try{ 
		  pDAO.atualizar(p); 
		  System.out.println("Ponto atualizado com sucesso!");
		 
		  }catch(SQLException e) {
		  System.out.println("Ponto não pode ser atualizado!"); e.printStackTrace(); }
		  
		 

		
		/*  TESTE LISTAR POR PROXIMIDADE
		  
		  p.setCo_X_ref(20L);
		  p.setCo_Y_ref(10L);
		  p.setdMax(10L);
		  try { 
			  ArrayList<Pontos>lista = pDAO.listarPorProximidade(p);
		  for(Pontos ponto : lista) { System.out.println(ponto); }
		  
		  }catch(SQLException e){
		System.out.println("Não foi possivel listar!");
		e.printStackTrace(); 
		}
		*/

		/* Teste Listar 
		  try { ArrayList<Pontos> lista = pDAO.listar(); for (Pontos
		  ponto : lista) { System.out.println(ponto); }
		  
		  } catch (SQLException e) { System.out.println("Não foi possivel listar!");
		  e.printStackTrace(); // TODO: handle exception }
		
	}
	 */
	}
}
