package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tabela {

	private List<Condicao> tabelaCondicional;

	public Tabela() {
		this.setTabelaCondicional(new ArrayList<Condicao>());
	}

	public List<Condicao> getTabelaCondicional() {
		return Collections.unmodifiableList(this.tabelaCondicional);
	}

	public void setTabelaCondicional(List<Condicao> tabelaCondicional) {
		this.tabelaCondicional = tabelaCondicional;
	}

	public void addCondicao(Condicao condicao) {
		if (!this.tabelaCondicional.contains(condicao)) {
			this.tabelaCondicional.add(condicao);
		}
	}

	public double consulta(List<Estado> evidenciasDaConsulta) throws Exception {
		for (Condicao c : this.tabelaCondicional) {
			List<Estado> evidenciasDaCondicao = c.getEvidencias();

			if (evidenciasDaCondicao.containsAll(evidenciasDaConsulta)) {
				
				if (evidenciasDaCondicao.size() == evidenciasDaConsulta.size()) {
					return c.getProbabilidade();
				}
				
			}
		}
		throw new Exception("Consulta não encontrada na tabela!");
	}

}
