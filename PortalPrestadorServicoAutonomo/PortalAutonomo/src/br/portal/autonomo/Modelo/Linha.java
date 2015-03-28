package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(name = "LINHA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Linha.findAll", query = "SELECT T FROM Linha T"),
		@NamedQuery(name = "Linha.findByCodigo", query = "SELECT T FROM Linha T WHERE T.codigoLinha = :codigoLinha") })
public class Linha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_LINHA", nullable = false)
	private int codigoLinha;

	@Column(name = "DESCRICAO_LINHA", length = 100, nullable = false)
	private String descricaoLinha;

	@Column(name = "SIGLA_LINHA", length = 5, nullable = false)
	private String siglaLinha;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkLinhaSubLinha.linha")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<LinhaSubLinha> linhaSubLinhas = new ArrayList<LinhaSubLinha>();

	public Linha() {

	}

	public Linha(int codigoLinha, String descricaoLinha, String siglaLinha, List<LinhaSubLinha> linhaSubLinhas) {
		super();
		this.codigoLinha = codigoLinha;
		this.descricaoLinha = descricaoLinha;
		this.siglaLinha = siglaLinha;
		this.linhaSubLinhas = linhaSubLinhas;
	}

	public int getCodigoLinha() {
		return codigoLinha;
	}

	public void setCodigoLinha(int codigoLinha) {
		this.codigoLinha = codigoLinha;
	}

	public String getDescricaoLinha() {
		return descricaoLinha;
	}

	public void setDescricaoLinha(String descricaoLinha) {
		this.descricaoLinha = descricaoLinha;
	}

	public String getSiglaLinha() {
		return siglaLinha;
	}

	public void setSiglaLinha(String siglaLinha) {
		this.siglaLinha = siglaLinha;
	}

	public List<LinhaSubLinha> getLinhaSubLinhas() {
		return linhaSubLinhas;
	}

	public void setLinhaSubLinhas(List<LinhaSubLinha> linhaSubLinhas) {
		this.linhaSubLinhas = linhaSubLinhas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoLinha;
		result = prime * result + ((descricaoLinha == null) ? 0 : descricaoLinha.hashCode());
		result = prime * result + ((linhaSubLinhas == null) ? 0 : linhaSubLinhas.hashCode());
		result = prime * result + ((siglaLinha == null) ? 0 : siglaLinha.hashCode());
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
		Linha other = (Linha) obj;
		if (codigoLinha != other.codigoLinha)
			return false;
		if (descricaoLinha == null) {
			if (other.descricaoLinha != null)
				return false;
		} else if (!descricaoLinha.equals(other.descricaoLinha))
			return false;
		if (linhaSubLinhas == null) {
			if (other.linhaSubLinhas != null)
				return false;
		} else if (!linhaSubLinhas.equals(other.linhaSubLinhas))
			return false;
		if (siglaLinha == null) {
			if (other.siglaLinha != null)
				return false;
		} else if (!siglaLinha.equals(other.siglaLinha))
			return false;
		return true;
	}

}
