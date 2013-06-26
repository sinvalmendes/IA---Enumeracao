package model;

import java.util.ArrayList;
import java.util.List;

public class Condicao {

	private List<Estado> evidencias;
	private double probabilidade;

	
	public Condicao(double probabilidade) {
		this.setProbabilidade(probabilidade);
		this.setEvidencias(new ArrayList<Estado>());
	}

	public double getProbabilidade() {
		return probabilidade;
	}

	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}

	public List<Estado> getEvidencias() {
		return evidencias;
	}

	public void setEvidencias(List<Estado> evidencias) {
		this.evidencias = evidencias;
	}
	
	public void addEstado(Estado estado){
		if (!this.evidencias.contains(estado)){
			this.evidencias.add(estado);
		}
	}
}
