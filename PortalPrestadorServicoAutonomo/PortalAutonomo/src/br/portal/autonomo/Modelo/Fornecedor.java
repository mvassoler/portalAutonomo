package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "FORNECEDOR")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "Fornecedor.findAll", query = "SELECT T FROM Fornecedor T"),
		@NamedQuery(name = "Fornecedor.findByCodigo", query = "SELECT T FROM Fornecedor T WHERE T.idFornecedor = :idFornecedor") })
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF_CNPJ")
	private long idFornecedor;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CPF_CNPJ", insertable = false, updatable = false)
	@ForeignKey(name = "FORNECEDOR_FK_PESSOA")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Pessoa pessoa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ULTIMA_COMPRA")
	private Date dataUltimaCompra;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_PRIMEIRA_COMPRA")
	private Date dataPrimeiraCompra;

	@Column(name = "VALOR_TOTAL_COMPRA", precision = 18, scale = 2)
	private BigDecimal valorTotalCompra;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkPrecoItemFornecedor.fornecedor")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<PrecoItemFornecedor> precoItemFornecedores = new ArrayList<PrecoItemFornecedor>();

	public Fornecedor() {
		super();
	}

	public Fornecedor(long idFornecedor, Pessoa pessoa, Date dataUltimaCompra, Date dataPrimeiraCompra,
			BigDecimal valorTotalCompra, List<PrecoItemFornecedor> precoItemFornecedores) {
		super();
		this.idFornecedor = idFornecedor;
		this.pessoa = pessoa;
		this.dataUltimaCompra = dataUltimaCompra;
		this.dataPrimeiraCompra = dataPrimeiraCompra;
		this.valorTotalCompra = valorTotalCompra;
		this.precoItemFornecedores = precoItemFornecedores;
	}

	public long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataUltimaCompra() {
		return dataUltimaCompra;
	}

	public void setDataUltimaCompra(Date dataUltimaCompra) {
		this.dataUltimaCompra = dataUltimaCompra;
	}

	public Date getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}

	public void setDataPrimeiraCompra(Date dataPrimeiraCompra) {
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}

	public BigDecimal getValorTotalCompra() {
		return valorTotalCompra;
	}

	public void setValorTotalCompra(BigDecimal valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}

	public List<PrecoItemFornecedor> getPrecoItemFornecedores() {
		return precoItemFornecedores;
	}

	public void setPrecoItemFornecedores(List<PrecoItemFornecedor> precoItemFornecedores) {
		this.precoItemFornecedores = precoItemFornecedores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPrimeiraCompra == null) ? 0 : dataPrimeiraCompra.hashCode());
		result = prime * result + ((dataUltimaCompra == null) ? 0 : dataUltimaCompra.hashCode());
		result = prime * result + (int) (idFornecedor ^ (idFornecedor >>> 32));
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((precoItemFornecedores == null) ? 0 : precoItemFornecedores.hashCode());
		result = prime * result + ((valorTotalCompra == null) ? 0 : valorTotalCompra.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (dataPrimeiraCompra == null) {
			if (other.dataPrimeiraCompra != null)
				return false;
		} else if (!dataPrimeiraCompra.equals(other.dataPrimeiraCompra))
			return false;
		if (dataUltimaCompra == null) {
			if (other.dataUltimaCompra != null)
				return false;
		} else if (!dataUltimaCompra.equals(other.dataUltimaCompra))
			return false;
		if (idFornecedor != other.idFornecedor)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (precoItemFornecedores == null) {
			if (other.precoItemFornecedores != null)
				return false;
		} else if (!precoItemFornecedores.equals(other.precoItemFornecedores))
			return false;
		if (valorTotalCompra == null) {
			if (other.valorTotalCompra != null)
				return false;
		} else if (!valorTotalCompra.equals(other.valorTotalCompra))
			return false;
		return true;
	}

}
