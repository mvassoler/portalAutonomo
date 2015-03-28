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
@Table(name = "SUBLINHA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "SubLinha.findAll", query = "SELECT T FROM SubLinha T"),
		@NamedQuery(name = "SubLinha.findByCodigo", query = "SELECT T FROM SubLinha T WHERE T.codigoSublinha = :codigoSublinha") })
public class SubLinha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_SUBLINHA", nullable = false)
	private int codigoSublinha;

	@Column(name = "DESCRICAO_SUBLINHA", length = 100, nullable = false)
	private String descricaoSubLinha;

	@Column(name = "SIGLA_SUBLINHA", length = 5, nullable = false)
	private String siglaSubLinha;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkLinhaSubLinha.subLinha")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<LinhaSubLinha> linhaSubLinhas = new ArrayList<LinhaSubLinha>();

	public SubLinha() {
	}

	public SubLinha(int codigoSublinha, String descricaoSubLinha, String siglaSubLinha,
			List<LinhaSubLinha> linhaSubLinhas) {
		this.codigoSublinha = codigoSublinha;
		this.descricaoSubLinha = descricaoSubLinha;
		this.siglaSubLinha = siglaSubLinha;
		this.linhaSubLinhas = linhaSubLinhas;
	}

	public int getCodigoSublinha() {
		return codigoSublinha;
	}

	public void setCodigoSublinha(int codigoSublinha) {
		this.codigoSublinha = codigoSublinha;
	}

	public String getDescricaoSubLinha() {
		return descricaoSubLinha;
	}

	public void setDescricaoSubLinha(String descricaoSubLinha) {
		this.descricaoSubLinha = descricaoSubLinha;
	}

	public String getSiglaSubLinha() {
		return siglaSubLinha;
	}

	public void setSiglaSubLinha(String siglaSubLinha) {
		this.siglaSubLinha = siglaSubLinha;
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
		result = prime * result + codigoSublinha;
		result = prime * result + ((descricaoSubLinha == null) ? 0 : descricaoSubLinha.hashCode());
		result = prime * result + ((linhaSubLinhas == null) ? 0 : linhaSubLinhas.hashCode());
		result = prime * result + ((siglaSubLinha == null) ? 0 : siglaSubLinha.hashCode());
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
		SubLinha other = (SubLinha) obj;
		if (codigoSublinha != other.codigoSublinha)
			return false;
		if (descricaoSubLinha == null) {
			if (other.descricaoSubLinha != null)
				return false;
		} else if (!descricaoSubLinha.equals(other.descricaoSubLinha))
			return false;
		if (linhaSubLinhas == null) {
			if (other.linhaSubLinhas != null)
				return false;
		} else if (!linhaSubLinhas.equals(other.linhaSubLinhas))
			return false;
		if (siglaSubLinha == null) {
			if (other.siglaSubLinha != null)
				return false;
		} else if (!siglaSubLinha.equals(other.siglaSubLinha))
			return false;
		return true;
	}

}
