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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "ENDERECO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "Endereco.findAll", query = "SELECT T FROM Endereco T"),
		@NamedQuery(name = "Endereco.findByCodigo", query = "SELECT T FROM Endereco T WHERE T.cepEndereco = :cepEndereco") })
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CEP_ENDERECO")
	private int cepEndereco;

	@Column(name = "NOME_ENDERECO", length = 100, nullable = false)
	private String nomeEndereco;

	@Column(name = "NOME_ENDERECO", length = 50)
	private String tipoLogradouro;

	@Column(name = "NOME_ENDERECO", length = 100, nullable = false)
	private String bairroEndereco;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CODIGO_IBGE")
	@ForeignKey(name = "ENDERECO_FK_CIDADE")
	private Cidade cidade;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkPessoaEndereco.endereco")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<PessoaEndereco> enderecos = new ArrayList<PessoaEndereco>();

	public Endereco() {
		super();
	}

	public Endereco(int cepEndereco, String nomeEndereco, String tipoLogradouro, String bairroEndereco, Cidade cidade,
			List<PessoaEndereco> enderecos) {
		super();
		this.cepEndereco = cepEndereco;
		this.nomeEndereco = nomeEndereco;
		this.tipoLogradouro = tipoLogradouro;
		this.bairroEndereco = bairroEndereco;
		this.cidade = cidade;
		this.enderecos = enderecos;
	}

	public int getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(int cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public String getNomeEndereco() {
		return nomeEndereco;
	}

	public void setNomeEndereco(String nomeEndereco) {
		this.nomeEndereco = nomeEndereco;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<PessoaEndereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<PessoaEndereco> enderecos) {
		this.enderecos = enderecos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairroEndereco == null) ? 0 : bairroEndereco.hashCode());
		result = prime * result + cepEndereco;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((enderecos == null) ? 0 : enderecos.hashCode());
		result = prime * result + ((nomeEndereco == null) ? 0 : nomeEndereco.hashCode());
		result = prime * result + ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
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
		Endereco other = (Endereco) obj;
		if (bairroEndereco == null) {
			if (other.bairroEndereco != null)
				return false;
		} else if (!bairroEndereco.equals(other.bairroEndereco))
			return false;
		if (cepEndereco != other.cepEndereco)
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (enderecos == null) {
			if (other.enderecos != null)
				return false;
		} else if (!enderecos.equals(other.enderecos))
			return false;
		if (nomeEndereco == null) {
			if (other.nomeEndereco != null)
				return false;
		} else if (!nomeEndereco.equals(other.nomeEndereco))
			return false;
		if (tipoLogradouro == null) {
			if (other.tipoLogradouro != null)
				return false;
		} else if (!tipoLogradouro.equals(other.tipoLogradouro))
			return false;
		return true;
	}

}
