package br.com.xyinc.domain;

public class Pontos {
	
	private Long idPonto;
	private String nome_ponto;
	private Long co_X;
	private Long co_X_ref;
	private Long co_Y;
	private Long co_Y_ref;
	private Long dMax;
	public Long getIdPonto() {
		return idPonto;
	}
	public void setIdPonto(Long idPonto) {
		this.idPonto = idPonto;
	}
	public String getNome_ponto() {
		return nome_ponto;
	}
	public void setNome_ponto(String nome_ponto) {
		this.nome_ponto = nome_ponto;
	}
	public Long getCo_X() {
		return co_X;
	}
	public void setCo_X(Long co_X) {
		this.co_X = co_X;
	}
	public Long getCo_Y() {
		return co_Y;
	}
	public void setCo_Y(Long co_Y) {
		this.co_Y = co_Y;
	}
	public Long getCo_X_ref() {
		return co_X_ref;
	}
	public void setCo_X_ref(Long co_X_ref) {
		this.co_X_ref = co_X_ref;
	}
	public Long getCo_Y_ref() {
		return co_Y_ref;
	}
	public void setCo_Y_ref(Long co_Y_ref) {
		this.co_Y_ref = co_Y_ref;
	}
	public Long getdMax() {
		return dMax;
	}
	public void setdMax(Long dMax) {
		this.dMax = dMax;
	}
	@Override
	public String toString() {
		String saida = "Código: " + idPonto + " | Nome do Ponto:  " + nome_ponto + " | Coordenada X:  " + co_X + " | Coordenada Y:  " + co_Y ;
		return saida;
	}
	

}
