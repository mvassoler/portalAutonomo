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
@Table(name = "SITUACAO_TRIBUTARIA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "SituacaoTributaria.findAll", query = "SELECT T FROM SituacaoTributaria T"),
		@NamedQuery(name = "SituacaoTributaria.findByCodigo", query = "SELECT T FROM SituacaoTributaria T WHERE T.codigoSituacao = :codigoSituacao") })
public class SituacaoTributaria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_SITUACAO", length = 2, nullable = false)
	private int codigoSituacao;

	@Column(name = "DESCRICAO_SITUACAO", length = 100, nullable = false)
	private String descricaoSituacao;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "situacaoTributaria")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Item> itens = new ArrayList<Item>();

	public SituacaoTributaria() {

	}

	public SituacaoTributaria(int codigoSituacao, String descricaoSituacao, List<Item> contas) {
		super();
		this.codigoSituacao = codigoSituacao;
		this.descricaoSituacao = descricaoSituacao;
		this.itens = contas;
	}

	public int getCodigoSituacao() {
		return codigoSituacao;
	}

	public void setCodigoSituacao(int codigoSituacao) {
		this.codigoSituacao = codigoSituacao;
	}

	public String getDescricaoSituacao() {
		return descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
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
		result = prime * result + codigoSituacao;
		result = prime * result + ((descricaoSituacao == null) ? 0 : descricaoSituacao.hashCode());
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
		SituacaoTributaria other = (SituacaoTributaria) obj;
		if (codigoSituacao != other.codigoSituacao)
			return false;
		if (descricaoSituacao == null) {
			if (other.descricaoSituacao != null)
				return false;
		} else if (!descricaoSituacao.equals(other.descricaoSituacao))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}

}
