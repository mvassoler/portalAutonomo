package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "CIDADE", uniqueConstraints = { @UniqueConstraint(columnNames = "CEP_CIDADE", name = "CIDADE_UK_CEP_CIDADE") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Cidade.findAll", query = "SELECT T FROM Cidade T"),
		@NamedQuery(name = "Cidade.findByCodigo", query = "SELECT T FROM Cidade T WHERE T.codigoIBGE = :codigoIBGE") })
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_IBGE")
	private int codigoIBGE;

	@Column(name = "NOME_CIDADE", length = 100, nullable = false)
	private String nomeCidade;

	@Column(name = "CEP_CIDADE", nullable = false)
	private int cepCidade;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CODIGO_ESTADO")
	@ForeignKey(name = "CIDADE_FK_ESTADO")
	private Estado estado;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cidade")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	public Cidade() {
		super();
	}

	public Cidade(int codigoIBGE, String nomeCidade, int cepCidade, Estado estado, List<Endereco> enderecos) {
		super();
		this.codigoIBGE = codigoIBGE;
		this.nomeCidade = nomeCidade;
		this.cepCidade = cepCidade;
		this.estado = estado;
		this.enderecos = enderecos;
	}

	public int getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public int getCepCidade() {
		return cepCidade;
	}

	public void setCepCidade(int cepCidade) {
		this.cepCidade = cepCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cepCidade;
		result = prime * result + codigoIBGE;
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cepCidade != other.cepCidade)
			return false;
		if (codigoIBGE != other.codigoIBGE)
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	}

}
