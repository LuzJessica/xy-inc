package br.com.xyinc.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.xyinc.dao.PontoDAO;
import br.com.xyinc.domain.Pontos;
import br.com.xyinc.util.JSFUtil;

@ManagedBean(name = "MBPonto")
@ViewScoped
public class PontoBean {
	private ListDataModel<Pontos> pontos;
	private ListDataModel<Pontos> pontosProximidade;
	private Pontos ponto;

	public ListDataModel<Pontos> getPontos() {
		return pontos;
	}

	public void setPontos(ListDataModel<Pontos> pontos) {
		this.pontos = pontos;
	}
	
	
	
	
	public Pontos getPonto() {
		return ponto;
	}

	public void setPonto(Pontos ponto) {
		this.ponto = ponto;
	}
	
	

	public ListDataModel<Pontos> getPontosProximidade() {
		return pontosProximidade;
	}

	public void setPontosProximidade(ListDataModel<Pontos> pontosProximidade) {
		this.pontosProximidade = pontosProximidade;
	}

	@PostConstruct
	public void prepararPesquisa() {
		ponto = new Pontos();
		try {
			PontoDAO pDao = new PontoDAO();
			ArrayList<Pontos> p = pDao.listar();
			pontos = new ListDataModel<Pontos>(p);
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgErro(e.getMessage());
		}
	}
	
	public void listarPorProximidade() {
		try {
			PontoDAO pDao = new PontoDAO();
			ArrayList<Pontos> p = pDao.listarPorProximidade(ponto);
			pontosProximidade = new ListDataModel<Pontos>(p);
		} catch (SQLException e) {
			e.printStackTrace();
			JSFUtil.msgErro(e.getMessage());
		}
	}
	
	public void novoPonto() {
		try {
			PontoDAO pDAO = new PontoDAO();
			pDAO.cadastrar(ponto);
			JSFUtil.msgSucesso("Ponto cadastrado com sucesso!");
		}catch(SQLException e){
			e.printStackTrace();
			JSFUtil.msgErro("Ponto não pode ser cadastrado: " + e.getMessage());
		}
		
		
	}

}
