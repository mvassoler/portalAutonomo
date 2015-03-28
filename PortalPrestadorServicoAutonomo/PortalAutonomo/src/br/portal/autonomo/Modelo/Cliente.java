package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "CLIENTE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "SELECT T FROM Cliente T"),
		@NamedQuery(name = "Cliente.findByCodigo", query = "SELECT T FROM Cliente T WHERE T.pessoa.cpfCnpj = :cpfCnpj") })
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "CPF_CNPJ")
	private long idCliente;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CPF_CNPJ", insertable = false, updatable = false)
	@ForeignKey(name = "CLIENTE_FK_PESSOA")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Pessoa pessoa;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ULTIMA_VENDA")
	private Date dataUltimaVenda;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_PRIMEIRA_VENDA")
	private Date dataPrimeiraVenda;

	@Column(name = "VALOR_TOTAL_VENDA", precision = 18, scale = 2)
	private BigDecimal valorTotalVenda;

	public Cliente() {
		super();
	}

	public Cliente(long idCliente, Pessoa pessoa, Date dataUltimaVenda, Date dataPrimeiraVenda,
			BigDecimal valorTotalVenda) {
		super();
		this.idCliente = idCliente;
		this.pessoa = pessoa;
		this.dataUltimaVenda = dataUltimaVenda;
		this.dataPrimeiraVenda = dataPrimeiraVenda;
		this.valorTotalVenda = valorTotalVenda;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	public void setDataUltimaVenda(Date dataUltimaVenda) {
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public Date getDataPrimeiraVenda() {
		return dataPrimeiraVenda;
	}

	public void setDataPrimeiraVenda(Date dataPrimeiraVenda) {
		this.dataPrimeiraVenda = dataPrimeiraVenda;
	}

	public BigDecimal getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(BigDecimal valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPrimeiraVenda == null) ? 0 : dataPrimeiraVenda.hashCode());
		result = prime * result + ((dataUltimaVenda == null) ? 0 : dataUltimaVenda.hashCode());
		result = prime * result + (int) (idCliente ^ (idCliente >>> 32));
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((valorTotalVenda == null) ? 0 : valorTotalVenda.hashCode());
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
		Cliente other = (Cliente) obj;
		if (dataPrimeiraVenda == null) {
			if (other.dataPrimeiraVenda != null)
				return false;
		} else if (!dataPrimeiraVenda.equals(other.dataPrimeiraVenda))
			return false;
		if (dataUltimaVenda == null) {
			if (other.dataUltimaVenda != null)
				return false;
		} else if (!dataUltimaVenda.equals(other.dataUltimaVenda))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (valorTotalVenda == null) {
			if (other.valorTotalVenda != null)
				return false;
		} else if (!valorTotalVenda.equals(other.valorTotalVenda))
			return false;
		return true;
	}

}
