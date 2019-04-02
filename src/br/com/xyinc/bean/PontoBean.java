package br.com.xyinc.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.xyinc.dao.PontoDAO;
import br.com.xyinc.domain.Pontos;

@ManagedBean(name = "MBPonto")
@ViewScoped
public class PontoBean {
	private ListDataModel<Pontos> pontos;

	public ListDataModel<Pontos> getPontos() {
		return pontos;
	}

	public void setPontos(ListDataModel<Pontos> pontos) {
		this.pontos = pontos;
	}
	
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			PontoDAO pDao = new PontoDAO();
			ArrayList<Pontos> p = pDao.listar();
			pontos = new ListDataModel<Pontos>(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
