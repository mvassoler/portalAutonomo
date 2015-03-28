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
@Table(name = "TIPO_BLOQUEIO_CREDITO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "TipoBloqueioCredito.findAll", query = "SELECT T FROM TipoBloqueioCredito T"),
		@NamedQuery(name = "TipoBloqueioCredito.findByCodigo", query = "SELECT T FROM TipoBloqueioCredito T WHERE T.idBloqueio = :idBloqueio") })
public class TipoBloqueioCredito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_BLOQUEIO")
	private int idBloqueio;

	@Column(name = "DESCRICAO_BLOQUEIO", length = 100, nullable = false)
	private String descricaoBloqueio;

	@Column(name = "BLOQUEAR_CREDITO")
	private int bloquearCredito;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tipoBloqueioCredito")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	public TipoBloqueioCredito() {
		super();
	}

	public TipoBloqueioCredito(int idBloqueio, String descricaoBloqueio, int bloquearCredito, List<Pessoa> pessoas) {
		super();
		this.idBloqueio = idBloqueio;
		this.descricaoBloqueio = descricaoBloqueio;
		this.bloquearCredito = bloquearCredito;
		this.pessoas = pessoas;
	}

	public int getIdBloqueio() {
		return idBloqueio;
	}

	public void setIdBloqueio(int idBloqueio) {
		this.idBloqueio = idBloqueio;
	}

	public String getDescricaoBloqueio() {
		return descricaoBloqueio;
	}

	public void setDescricaoBloqueio(String descricaoBloqueio) {
		this.descricaoBloqueio = descricaoBloqueio;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public int getBloquearCredito() {
		return bloquearCredito;
	}

	public void setBloquearCredito(int bloquearCredito) {
		this.bloquearCredito = bloquearCredito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bloquearCredito;
		result = prime * result + ((descricaoBloqueio == null) ? 0 : descricaoBloqueio.hashCode());
		result = prime * result + idBloqueio;
		result = prime * result + ((pessoas == null) ? 0 : pessoas.hashCode());
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
		TipoBloqueioCredito other = (TipoBloqueioCredito) obj;
		if (bloquearCredito != other.bloquearCredito)
			return false;
		if (descricaoBloqueio == null) {
			if (other.descricaoBloqueio != null)
				return false;
		} else if (!descricaoBloqueio.equals(other.descricaoBloqueio))
			return false;
		if (idBloqueio != other.idBloqueio)
			return false;
		if (pessoas == null) {
			if (other.pessoas != null)
				return false;
		} else if (!pessoas.equals(other.pessoas))
			return false;
		return true;
	}

}
