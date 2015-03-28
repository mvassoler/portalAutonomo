package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "CFOP")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "CFOP.findAll", query = "SELECT T FROM CFOP T"),
		@NamedQuery(name = "CFOP.findByCodigo", query = "SELECT T FROM Item T CFOP T.codigoCFOP = :codigoCFOP") })
public class CFOP implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_CFOP")
	private int codigoCFOP;

	@Column(name = "DESCRICAO_CFOP", length = 100, nullable = false)
	private String descricao;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cfop")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Item> itens = new ArrayList<Item>();

	public CFOP() {
		super();
	}

	public CFOP(int codigoCFOP, String descricao, List<Item> itens) {
		super();
		this.codigoCFOP = codigoCFOP;
		this.descricao = descricao;
		this.itens = itens;
	}

	public int getCodigoCFOP() {
		return codigoCFOP;
	}

	public void setCodigoCFOP(int codigoCFOP) {
		this.codigoCFOP = codigoCFOP;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoCFOP;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
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
		CFOP other = (CFOP) obj;
		if (codigoCFOP != other.codigoCFOP)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}

}
