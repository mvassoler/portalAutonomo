package br.portal.autonomo.Modelo;

import java.io.Serializable;
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
@Table(name = "AUTONOMO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "Autonomo.findAll", query = "SELECT T FROM Autonomo T"),
		@NamedQuery(name = "Autonomo.findByCodigo", query = "SELECT T FROM Autonomo T WHERE T.pessoa.cpfCnpj = :cpfCnpj") })
public class Autonomo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "CPF_CNPJ")
	private long idAutonomo;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CPF_CNPJ", insertable = false, updatable = false)
	@ForeignKey(name = "AUTONOMO_FK_PESSOA")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Pessoa pessoa;

	@Column(name = "REGISTRO_PREFEITURA", nullable = false)
	private long registroPrefeitura;

	@Column(name = "EMITE_FICHA_SERVICO")
	private int emiteFichaServico;

	@Column(name = "EMITE_ORCAMENTO")
	private int emiteOrcamento;

	@Column(name = "EMITE_ORDEM_SERVICO")
	private int emiteOrdemServico;

	@Column(name = "EMITE_PEDIDO_COMPRA")
	private int emitePedidoCompra;

	@Column(name = "EMITE_CRONOGRAMA")
	private int emiteCronograma;

	@Column(name = "EMITE_CONTRATO")
	private int emiteContrato;

	@Column(name = "EMITE_DOCUMENTO_RECEBER")
	private int emiteDocumentoReceber;

	@Column(name = "EMITE_NOTA_SERVICO")
	private int emiteNotaServico;

	@Column(name = "EMITE_NOTA_ENTRADA_INSUMO")
	private int emiteNotaEntradaInsumo;

	@Column(name = "EMITE_NOTA_SAIDA_INSUMO")
	private int emiteNotaSaidaInsumo;

	@Column(name = "EMITE_REQUISICAO_CONSUMO")
	private int emiteRequisicaoConsumo;

	@Column(name = "EXECUTA_APONTAMENTO")
	private int executaApontamento;

	@Column(name = "EXECUTA_INVENTARIO")
	private int executaInventario;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO_ATIVIDADE")
	private Date dataInicioAtividade;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO_USO_PORTAL")
	private Date dataInicioUsoPortal;

	public Autonomo() {
		super();
	}

	public Autonomo(long idAutonomo, Pessoa pessoa, long registroPrefeitura, int emiteFichaServico, int emiteOrcamento,
			int emiteOrdemServico, int emitePedidoCompra, int emiteCronograma, int emiteContrato,
			int emiteDocumentoReceber, int emiteNotaServico, int emiteNotaEntradaInsumo, int emiteNotaSaidaInsumo,
			int emiteRequisicaoConsumo, int executaApontamento, int executaInventario, Date dataInicioAtividade,
			Date dataInicioUsoPortal) {
		super();
		this.idAutonomo = idAutonomo;
		this.pessoa = pessoa;
		this.registroPrefeitura = registroPrefeitura;
		this.emiteFichaServico = emiteFichaServico;
		this.emiteOrcamento = emiteOrcamento;
		this.emiteOrdemServico = emiteOrdemServico;
		this.emitePedidoCompra = emitePedidoCompra;
		this.emiteCronograma = emiteCronograma;
		this.emiteContrato = emiteContrato;
		this.emiteDocumentoReceber = emiteDocumentoReceber;
		this.emiteNotaServico = emiteNotaServico;
		this.emiteNotaEntradaInsumo = emiteNotaEntradaInsumo;
		this.emiteNotaSaidaInsumo = emiteNotaSaidaInsumo;
		this.emiteRequisicaoConsumo = emiteRequisicaoConsumo;
		this.executaApontamento = executaApontamento;
		this.executaInventario = executaInventario;
		this.dataInicioAtividade = dataInicioAtividade;
		this.dataInicioUsoPortal = dataInicioUsoPortal;
	}

	public long getIdAutonomo() {
		return idAutonomo;
	}

	public void setIdAutonomo(long idAutonomo) {
		this.idAutonomo = idAutonomo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public long getRegistroPrefeitura() {
		return registroPrefeitura;
	}

	public void setRegistroPrefeitura(long registroPrefeitura) {
		this.registroPrefeitura = registroPrefeitura;
	}

	public int getEmiteFichaServico() {
		return emiteFichaServico;
	}

	public void setEmiteFichaServico(int emiteFichaServico) {
		this.emiteFichaServico = emiteFichaServico;
	}

	public int getEmiteOrcamento() {
		return emiteOrcamento;
	}

	public void setEmiteOrcamento(int emiteOrcamento) {
		this.emiteOrcamento = emiteOrcamento;
	}

	public int getEmiteOrdemServico() {
		return emiteOrdemServico;
	}

	public void setEmiteOrdemServico(int emiteOrdemServico) {
		this.emiteOrdemServico = emiteOrdemServico;
	}

	public int getEmitePedidoCompra() {
		return emitePedidoCompra;
	}

	public void setEmitePedidoCompra(int emitePedidoCompra) {
		this.emitePedidoCompra = emitePedidoCompra;
	}

	public int getEmiteCronograma() {
		return emiteCronograma;
	}

	public void setEmiteCronograma(int emiteCronograma) {
		this.emiteCronograma = emiteCronograma;
	}

	public int getEmiteContrato() {
		return emiteContrato;
	}

	public void setEmiteContrato(int emiteContrato) {
		this.emiteContrato = emiteContrato;
	}

	public int getEmiteDocumentoReceber() {
		return emiteDocumentoReceber;
	}

	public void setEmiteDocumentoReceber(int emiteDocumentoReceber) {
		this.emiteDocumentoReceber = emiteDocumentoReceber;
	}

	public int getEmiteNotaServico() {
		return emiteNotaServico;
	}

	public void setEmiteNotaServico(int emiteNotaServico) {
		this.emiteNotaServico = emiteNotaServico;
	}

	public int getEmiteNotaEntradaInsumo() {
		return emiteNotaEntradaInsumo;
	}

	public void setEmiteNotaEntradaInsumo(int emiteNotaEntradaInsumo) {
		this.emiteNotaEntradaInsumo = emiteNotaEntradaInsumo;
	}

	public int getEmiteNotaSaidaInsumo() {
		return emiteNotaSaidaInsumo;
	}

	public void setEmiteNotaSaidaInsumo(int emiteNotaSaidaInsumo) {
		this.emiteNotaSaidaInsumo = emiteNotaSaidaInsumo;
	}

	public int getEmiteRequisicaoConsumo() {
		return emiteRequisicaoConsumo;
	}

	public void setEmiteRequisicaoConsumo(int emiteRequisicaoConsumo) {
		this.emiteRequisicaoConsumo = emiteRequisicaoConsumo;
	}

	public int getExecutaApontamento() {
		return executaApontamento;
	}

	public void setExecutaApontamento(int executaApontamento) {
		this.executaApontamento = executaApontamento;
	}

	public int getExecutaInventario() {
		return executaInventario;
	}

	public void setExecutaInventario(int executaInventario) {
		this.executaInventario = executaInventario;
	}

	public Date getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(Date dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public Date getDataInicioUsoPortal() {
		return dataInicioUsoPortal;
	}

	public void setDataInicioUsoPortal(Date dataInicioUsoPortal) {
		this.dataInicioUsoPortal = dataInicioUsoPortal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicioAtividade == null) ? 0 : dataInicioAtividade.hashCode());
		result = prime * result + ((dataInicioUsoPortal == null) ? 0 : dataInicioUsoPortal.hashCode());
		result = prime * result + emiteContrato;
		result = prime * result + emiteCronograma;
		result = prime * result + emiteDocumentoReceber;
		result = prime * result + emiteFichaServico;
		result = prime * result + emiteNotaEntradaInsumo;
		result = prime * result + emiteNotaSaidaInsumo;
		result = prime * result + emiteNotaServico;
		result = prime * result + emiteOrcamento;
		result = prime * result + emiteOrdemServico;
		result = prime * result + emitePedidoCompra;
		result = prime * result + emiteRequisicaoConsumo;
		result = prime * result + executaApontamento;
		result = prime * result + executaInventario;
		result = prime * result + (int) (idAutonomo ^ (idAutonomo >>> 32));
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + (int) (registroPrefeitura ^ (registroPrefeitura >>> 32));
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
		Autonomo other = (Autonomo) obj;
		if (dataInicioAtividade == null) {
			if (other.dataInicioAtividade != null)
				return false;
		} else if (!dataInicioAtividade.equals(other.dataInicioAtividade))
			return false;
		if (dataInicioUsoPortal == null) {
			if (other.dataInicioUsoPortal != null)
				return false;
		} else if (!dataInicioUsoPortal.equals(other.dataInicioUsoPortal))
			return false;
		if (emiteContrato != other.emiteContrato)
			return false;
		if (emiteCronograma != other.emiteCronograma)
			return false;
		if (emiteDocumentoReceber != other.emiteDocumentoReceber)
			return false;
		if (emiteFichaServico != other.emiteFichaServico)
			return false;
		if (emiteNotaEntradaInsumo != other.emiteNotaEntradaInsumo)
			return false;
		if (emiteNotaSaidaInsumo != other.emiteNotaSaidaInsumo)
			return false;
		if (emiteNotaServico != other.emiteNotaServico)
			return false;
		if (emiteOrcamento != other.emiteOrcamento)
			return false;
		if (emiteOrdemServico != other.emiteOrdemServico)
			return false;
		if (emitePedidoCompra != other.emitePedidoCompra)
			return false;
		if (emiteRequisicaoConsumo != other.emiteRequisicaoConsumo)
			return false;
		if (executaApontamento != other.executaApontamento)
			return false;
		if (executaInventario != other.executaInventario)
			return false;
		if (idAutonomo != other.idAutonomo)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (registroPrefeitura != other.registroPrefeitura)
			return false;
		return true;
	}

}
