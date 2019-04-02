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
	
	public static void main(String[] args) {
		
		//TESTE INSERÇÃO
		
		PontoDAO pDAO = new PontoDAO();
		
		
		try {
			Pontos p = new Pontos();
			p.setNome_ponto("Lanchonete");
			p.setCo_X("27");
			p.setCo_Y("12");
			pDAO.cadastrar(p);
			System.out.println("Ponto cadastrado com sucesso!");
		}catch (SQLException e) {
			System.out.println("Não foi possivel cadastrar o ponto!");
			e.printStackTrace();
		}
	}

}
