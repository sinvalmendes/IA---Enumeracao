package model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Node {
	private String descricao;
	private List<Node> pais;

	public Node(String descricao) {
		this.descricao = descricao;
		this.setPais(new ArrayList<Node>());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Node> getPais() {
		return Collections.unmodifiableList(pais);
	}

	public void setPais(List<Node> pais) {
		this.pais = pais;
	}

	public void addPai(Node pai) {
		if (!this.pais.contains(pai)) {
			this.pais.add(pai);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Node [descricao=" + descricao + ", pais=" + pais + "]";
	}
}
