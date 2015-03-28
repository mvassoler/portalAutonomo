package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "SERVICO", uniqueConstraints = { @UniqueConstraint(columnNames = "DESCRICAO_SERVICO", name = "SERVICO_UK_DESCRICAO_SERVICO") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Servico.findAll", query = "SELECT T FROM Servico T"),
		@NamedQuery(name = "Servico.findByCodigo", query = "SELECT T FROM Servico T WHERE T.idServico = :idServico") })
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_SERVICO")
	private long idServico;

	@Column(name = "DESCRICAO_SERVICO", length = 100, nullable = false)
	private String descricaoServico;

	@Column(name = "VALOR_SERVICO", precision = 15, scale = 2)
	private BigDecimal valorServico;

	@Column(name = "ALIQUOTA_ISS", precision = 3, scale = 2)
	private double aliquotaISS;

	@Column(name = "ALIQUOTA_BASE_ISS", precision = 3, scale = 2)
	private double aliquotaBaseISS;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumns({
			@JoinColumn(name = "CODIGO_LINHA", referencedColumnName = "CODIGO_LINHA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGO_SUBLINHA", referencedColumnName = "CODIGO_SUBLINHA", insertable = false, updatable = false) })
	@ForeignKey(name = "SERVICO_FK_LINHA_SUBLINHA")
	private LinhaSubLinha linhaSubLinha;

	public Servico() {
		super();
	}

	public Servico(long idServico, String descricaoServico, BigDecimal valorServico, double aliquotaISS,
			double aliquotaBaseISS, LinhaSubLinha linhaSubLinha) {
		super();
		this.idServico = idServico;
		this.descricaoServico = descricaoServico;
		this.valorServico = valorServico;
		this.aliquotaISS = aliquotaISS;
		this.aliquotaBaseISS = aliquotaBaseISS;
		this.linhaSubLinha = linhaSubLinha;
	}

	public long getIdServico() {
		return idServico;
	}

	public void setIdServico(long idServico) {
		this.idServico = idServico;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	public double getAliquotaISS() {
		return aliquotaISS;
	}

	public void setAliquotaISS(double aliquotaISS) {
		this.aliquotaISS = aliquotaISS;
	}

	public double getAliquotaBaseISS() {
		return aliquotaBaseISS;
	}

	public void setAliquotaBaseISS(double aliquotaBaseISS) {
		this.aliquotaBaseISS = aliquotaBaseISS;
	}

	public LinhaSubLinha getLinhaSubLinha() {
		return linhaSubLinha;
	}

	public void setLinhaSubLinha(LinhaSubLinha linhaSubLinha) {
		this.linhaSubLinha = linhaSubLinha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aliquotaBaseISS);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(aliquotaISS);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((descricaoServico == null) ? 0 : descricaoServico.hashCode());
		result = prime * result + (int) (idServico ^ (idServico >>> 32));
		result = prime * result + ((linhaSubLinha == null) ? 0 : linhaSubLinha.hashCode());
		result = prime * result + ((valorServico == null) ? 0 : valorServico.hashCode());
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
		Servico other = (Servico) obj;
		if (Double.doubleToLongBits(aliquotaBaseISS) != Double.doubleToLongBits(other.aliquotaBaseISS))
			return false;
		if (Double.doubleToLongBits(aliquotaISS) != Double.doubleToLongBits(other.aliquotaISS))
			return false;
		if (descricaoServico == null) {
			if (other.descricaoServico != null)
				return false;
		} else if (!descricaoServico.equals(other.descricaoServico))
			return false;
		if (idServico != other.idServico)
			return false;
		if (linhaSubLinha == null) {
			if (other.linhaSubLinha != null)
				return false;
		} else if (!linhaSubLinha.equals(other.linhaSubLinha))
			return false;
		if (valorServico == null) {
			if (other.valorServico != null)
				return false;
		} else if (!valorServico.equals(other.valorServico))
			return false;
		return true;
	}

}
