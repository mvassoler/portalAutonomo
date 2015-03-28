package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

@Entity
@Table(name = "ITEM", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODIGO_EDITADO", name = "ITEM_UK_CODIGO_ESTADO"),
		@UniqueConstraint(columnNames = "CODIGO_BARRA", name = "ITEM_UK_CODIGO_BARRA") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "Item.findAll", query = "SELECT T FROM Item T"),
		@NamedQuery(name = "Item.findByCodigo", query = "SELECT T FROM Item T WHERE T.idItem = :idItem"),
		@NamedQuery(name = "Item.findByCodigoEditado", query = "SELECT T FROM Item T WHERE T.codigoEditado = :codigoEditado"),
		@NamedQuery(name = "Item.findByCodigoBarra", query = "SELECT T FROM Item T WHERE T.codigoBarra = :codigoBarra") })
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_ITEM")
	private long idItem;

	@Column(name = "CODIGO_EDITADO", length = 30)
	private String codigoEditado;

	@Column(name = "CODIGO_BARRA", length = 30)
	private String codigoBarra;

	@Column(name = "DESCRICAO_ITEM")
	@Index(name = "ITEM_INDEX_DESCRICAO_ITEM", columnNames = "DESCRICAO_ITEM")
	private String descricaoItem;

	@Column(name = "ESTOQUE_INICIAL", precision = 15, scale = 4)
	private BigDecimal estoqueInicial;

	@Column(name = "PRECO_VENDA", precision = 15, scale = 2)
	private BigDecimal precoVenda;

	@Column(name = "PRECO_REPOSICAO", precision = 15, scale = 2)
	private BigDecimal precoReposicao;

	@Column(name = "PESO_BRUTO", precision = 9, scale = 3)
	private double pesoBruto;

	@Column(name = "PESO_LIQUIDO", precision = 9, scale = 3)
	private double pesoLiquido;

	@Column(name = "EMBALAGEM_MINIMA", precision = 9, scale = 3)
	private double embalagemMinima;

	@Column(name = "DATA_INCLUSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInclusao;

	@Column(name = "DATA_INCLUSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAtualizacao;

	@Column(name = "DATA_ULTIMA_COMPRA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaCompra;

	@Column(name = "SITUACAO_ITEM", length = 1)
	private char situacaoItem;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CODIGO_NCM")
	@ForeignKey(name = "ITEM_FK_NCM")
	private NCM ncm;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CODIGO_SITUACAO_TRIBUTARIA")
	@ForeignKey(name = "ITEM_FK_SITUACAO_TRIBUTARIA")
	private SituacaoTributaria situacaoTributaria;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CODIGO_UNIDADE_MEDIDA")
	@ForeignKey(name = "ITEM_FK_UNIDA_MEDIDA")
	private UnidadeMedida unidadeMedida;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumns({
			@JoinColumn(name = "CODIGO_LINHA", referencedColumnName = "CODIGO_LINHA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGO_SUBLINHA", referencedColumnName = "CODIGO_SUBLINHA", insertable = false, updatable = false) })
	@ForeignKey(name = "ITEM_FK_LINHA_SUBLINHA")
	private LinhaSubLinha linhaSubLinha;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "CODIGO_CFOP")
	@ForeignKey(name = "ITEM_FK_CODIGO_CFOP")
	private CFOP cfop;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkPrecoItemFornecedor.item")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<PrecoItemFornecedor> precoItemFornecedores = new ArrayList<PrecoItemFornecedor>();

	public Item() {

	}

	public long getIdItem() {
		return idItem;
	}

	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}

	public String getCodigoEditado() {
		return codigoEditado;
	}

	public void setCodigoEditado(String codigoEditado) {
		this.codigoEditado = codigoEditado;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	public BigDecimal getEstoqueInicial() {
		return estoqueInicial;
	}

	public void setEstoqueInicial(BigDecimal estoqueInicial) {
		this.estoqueInicial = estoqueInicial;
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

	public double getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(double pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public double getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(double pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public double getEmbalagemMinima() {
		return embalagemMinima;
	}

	public void setEmbalagemMinima(double embalagemMinima) {
		this.embalagemMinima = embalagemMinima;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Date getDataUltimaCompra() {
		return dataUltimaCompra;
	}

	public void setDataUltimaCompra(Date dataUltimaCompra) {
		this.dataUltimaCompra = dataUltimaCompra;
	}

	public char getSituacaoItem() {
		return situacaoItem;
	}

	public void setSituacaoItem(char situacaoItem) {
		this.situacaoItem = situacaoItem;
	}

	public NCM getNcm() {
		return ncm;
	}

	public void setNcm(NCM ncm) {
		this.ncm = ncm;
	}

	public SituacaoTributaria getSituacaoTributaria() {
		return situacaoTributaria;
	}

	public void setSituacaoTributaria(SituacaoTributaria situacaoTributaria) {
		this.situacaoTributaria = situacaoTributaria;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public LinhaSubLinha getLinhaSubLinha() {
		return linhaSubLinha;
	}

	public void setLinhaSubLinha(LinhaSubLinha linhaSubLinha) {
		this.linhaSubLinha = linhaSubLinha;
	}

	public CFOP getCfop() {
		return cfop;
	}

	public void setCfop(CFOP cfop) {
		this.cfop = cfop;
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
		result = prime * result + ((cfop == null) ? 0 : cfop.hashCode());
		result = prime * result + ((codigoBarra == null) ? 0 : codigoBarra.hashCode());
		result = prime * result + ((codigoEditado == null) ? 0 : codigoEditado.hashCode());
		result = prime * result + ((dataInclusao == null) ? 0 : dataInclusao.hashCode());
		result = prime * result + ((dataUltimaAtualizacao == null) ? 0 : dataUltimaAtualizacao.hashCode());
		result = prime * result + ((dataUltimaCompra == null) ? 0 : dataUltimaCompra.hashCode());
		result = prime * result + ((descricaoItem == null) ? 0 : descricaoItem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(embalagemMinima);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((estoqueInicial == null) ? 0 : estoqueInicial.hashCode());
		result = prime * result + (int) (idItem ^ (idItem >>> 32));
		result = prime * result + ((linhaSubLinha == null) ? 0 : linhaSubLinha.hashCode());
		result = prime * result + ((ncm == null) ? 0 : ncm.hashCode());
		temp = Double.doubleToLongBits(pesoBruto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pesoLiquido);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((precoItemFornecedores == null) ? 0 : precoItemFornecedores.hashCode());
		result = prime * result + ((precoReposicao == null) ? 0 : precoReposicao.hashCode());
		result = prime * result + ((precoVenda == null) ? 0 : precoVenda.hashCode());
		result = prime * result + situacaoItem;
		result = prime * result + ((situacaoTributaria == null) ? 0 : situacaoTributaria.hashCode());
		result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
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
		Item other = (Item) obj;
		if (cfop == null) {
			if (other.cfop != null)
				return false;
		} else if (!cfop.equals(other.cfop))
			return false;
		if (codigoBarra == null) {
			if (other.codigoBarra != null)
				return false;
		} else if (!codigoBarra.equals(other.codigoBarra))
			return false;
		if (codigoEditado == null) {
			if (other.codigoEditado != null)
				return false;
		} else if (!codigoEditado.equals(other.codigoEditado))
			return false;
		if (dataInclusao == null) {
			if (other.dataInclusao != null)
				return false;
		} else if (!dataInclusao.equals(other.dataInclusao))
			return false;
		if (dataUltimaAtualizacao == null) {
			if (other.dataUltimaAtualizacao != null)
				return false;
		} else if (!dataUltimaAtualizacao.equals(other.dataUltimaAtualizacao))
			return false;
		if (dataUltimaCompra == null) {
			if (other.dataUltimaCompra != null)
				return false;
		} else if (!dataUltimaCompra.equals(other.dataUltimaCompra))
			return false;
		if (descricaoItem == null) {
			if (other.descricaoItem != null)
				return false;
		} else if (!descricaoItem.equals(other.descricaoItem))
			return false;
		if (Double.doubleToLongBits(embalagemMinima) != Double.doubleToLongBits(other.embalagemMinima))
			return false;
		if (estoqueInicial == null) {
			if (other.estoqueInicial != null)
				return false;
		} else if (!estoqueInicial.equals(other.estoqueInicial))
			return false;
		if (idItem != other.idItem)
			return false;
		if (linhaSubLinha == null) {
			if (other.linhaSubLinha != null)
				return false;
		} else if (!linhaSubLinha.equals(other.linhaSubLinha))
			return false;
		if (ncm == null) {
			if (other.ncm != null)
				return false;
		} else if (!ncm.equals(other.ncm))
			return false;
		if (Double.doubleToLongBits(pesoBruto) != Double.doubleToLongBits(other.pesoBruto))
			return false;
		if (Double.doubleToLongBits(pesoLiquido) != Double.doubleToLongBits(other.pesoLiquido))
			return false;
		if (precoItemFornecedores == null) {
			if (other.precoItemFornecedores != null)
				return false;
		} else if (!precoItemFornecedores.equals(other.precoItemFornecedores))
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
		if (situacaoItem != other.situacaoItem)
			return false;
		if (situacaoTributaria == null) {
			if (other.situacaoTributaria != null)
				return false;
		} else if (!situacaoTributaria.equals(other.situacaoTributaria))
			return false;
		if (unidadeMedida == null) {
			if (other.unidadeMedida != null)
				return false;
		} else if (!unidadeMedida.equals(other.unidadeMedida))
			return false;
		return true;
	}

}
