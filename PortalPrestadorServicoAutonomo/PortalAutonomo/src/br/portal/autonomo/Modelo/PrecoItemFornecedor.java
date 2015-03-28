package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.portal.autonomo.Modelo.PK.PrecoItemFornecedorPK;

@Entity
@Table(name = "PRECO_ITEM_FORNECEDOR")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "PrecoItemFornecedor.findAll", query = "SELECT T FROM PrecoItemFornecedor T"),
		@NamedQuery(name = "PrecoItemFornecedor.findByCodigo", query = "SELECT T FROM PrecoItemFornecedor T WHERE T.pkPrecoItemFornecedor.item.idItem = :idItem "
				+ "and T.pkPrecoItemFornecedor.fornecedor.idFornecedor = :idFornecedor") })
@AssociationOverrides({
		@AssociationOverride(name = "pkPrecoItemFornecedor.item", joinColumns = @JoinColumn(name = "CODIGO_ITEM")),
		@AssociationOverride(name = "pkPrecoItemFornecedor.fornecedor", joinColumns = @JoinColumn(name = "CPF_CNPJ")) })
public class PrecoItemFornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrecoItemFornecedorPK pkPrecoItemFornecedor;

	@Column(name = "PRECO_VENDA", precision = 15, scale = 2)
	private BigDecimal precoVenda;

	@Column(name = "PRECO_REPOSICAO", precision = 15, scale = 2)
	private BigDecimal precoReposicao;

	@Column(name = "PRECO_PROMOCAO", precision = 15, scale = 2)
	private BigDecimal precoPromocao;

	@Column(name = "PERCENTUAL_DESCONTO", precision = 3, scale = 2)
	private BigDecimal percentualDesconto;

	@Column(name = "DATA_ATUALIZACAO")
	private Date dataAtualizacao;

	public PrecoItemFornecedor() {
		super();
	}

	public PrecoItemFornecedor(PrecoItemFornecedorPK pkPrecoItemFornecedor, BigDecimal precoVenda,
			BigDecimal precoReposicao, BigDecimal precoPromocao, BigDecimal percentualDesconto, Date dataAtualizacao) {
		super();
		this.pkPrecoItemFornecedor = pkPrecoItemFornecedor;
		this.precoVenda = precoVenda;
		this.precoReposicao = precoReposicao;
		this.precoPromocao = precoPromocao;
		this.percentualDesconto = percentualDesconto;
		this.dataAtualizacao = dataAtualizacao;
	}

	public PrecoItemFornecedorPK getPkPrecoItemFornecedor() {
		return pkPrecoItemFornecedor;
	}

	public void setPkPrecoItemFornecedor(PrecoItemFornecedorPK pkPrecoItemFornecedor) {
		this.pkPrecoItemFornecedor = pkPrecoItemFornecedor;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public BigDecimal getPrecoReposicao() {
		return precoReposicao;
	}

	public void setPrecoReposicao(BigDecimal precoReposicao) {
		this.precoReposicao = precoReposicao;
	}

	public BigDecimal getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(BigDecimal precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
		result = prime * result + ((percentualDesconto == null) ? 0 : percentualDesconto.hashCode());
		result = prime * result + ((pkPrecoItemFornecedor == null) ? 0 : pkPrecoItemFornecedor.hashCode());
		result = prime * result + ((precoPromocao == null) ? 0 : precoPromocao.hashCode());
		result = prime * result + ((precoReposicao == null) ? 0 : precoReposicao.hashCode());
		result = prime * result + ((precoVenda == null) ? 0 : precoVenda.hashCode());
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
		PrecoItemFornecedor other = (PrecoItemFornecedor) obj;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		if (percentualDesconto == null) {
			if (other.percentualDesconto != null)
				return false;
		} else if (!percentualDesconto.equals(other.percentualDesconto))
			return false;
		if (pkPrecoItemFornecedor == null) {
			if (other.pkPrecoItemFornecedor != null)
				return false;
		} else if (!pkPrecoItemFornecedor.equals(other.pkPrecoItemFornecedor))
			return false;
		if (precoPromocao == null) {
			if (other.precoPromocao != null)
				return false;
		} else if (!precoPromocao.equals(other.precoPromocao))
			return false;
		if (precoReposicao == null) {
			if (other.precoReposicao != null)
				return false;
		} else if (!precoReposicao.equals(other.precoReposicao))
			return false;
		if (precoVenda == null) {
			if (other.precoVenda != null)
				return false;
		} else if (!precoVenda.equals(other.precoVenda))
			return false;
		return true;
	}

}
