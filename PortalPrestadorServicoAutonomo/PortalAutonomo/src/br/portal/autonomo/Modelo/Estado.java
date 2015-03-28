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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "ESTADO", uniqueConstraints = { @UniqueConstraint(columnNames = "UNIDADE_FEDERAL", name = "ESTADO_UK_UNIDADE_FEDERAL") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Estado.findAll", query = "SELECT T FROM Estado T"),
		@NamedQuery(name = "Estado.findByCodigo", query = "SELECT T FROM Estado T WHERE T.idEstado = :idEstado") })
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CODIGO_ESTADO")
	private int idEstado;

	@Column(name = "NOME_ESTADO", length = 100, nullable = false)
	private String nomeEstado;

	@Column(name = "UNIDADE_FEDERAL", length = 2, nullable = false)
	private String unidadeFederal;

	@Column(name = "BASE_ICMS_ENTRADA", precision = 3, scale = 2)
	private double baseICMSEntrada;

	@Column(name = "ALIQUOTA_ICMS_ENTRADA", precision = 3, scale = 2)
	private double aliquotaICMSEntrada;

	@Column(name = "BASE_ICMS_SAIDA", precision = 3, scale = 2)
	private double baseICMSSaida;

	@Column(name = "ALIQUOTA_ICMS_ENTRADA", precision = 3, scale = 2)
	private double aliquotaICMSSaida;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "estado")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Cidade> cidades = new ArrayList<Cidade>();

	public Estado() {
		super();
	}

	public Estado(int idEstado, String nomeEstado, String unidadeFederal, double baseICMSEntrada,
			double aliquotaICMSEntrada, double baseICMSSaida, double aliquotaICMSSaida, List<Cidade> cidades) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
		this.unidadeFederal = unidadeFederal;
		this.baseICMSEntrada = baseICMSEntrada;
		this.aliquotaICMSEntrada = aliquotaICMSEntrada;
		this.baseICMSSaida = baseICMSSaida;
		this.aliquotaICMSSaida = aliquotaICMSSaida;
		this.cidades = cidades;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getUnidadeFederal() {
		return unidadeFederal;
	}

	public void setUnidadeFederal(String unidadeFederal) {
		this.unidadeFederal = unidadeFederal;
	}

	public double getBaseICMSEntrada() {
		return baseICMSEntrada;
	}

	public void setBaseICMSEntrada(double baseICMSEntrada) {
		this.baseICMSEntrada = baseICMSEntrada;
	}

	public double getAliquotaICMSEntrada() {
		return aliquotaICMSEntrada;
	}

	public void setAliquotaICMSEntrada(double aliquotaICMSEntrada) {
		this.aliquotaICMSEntrada = aliquotaICMSEntrada;
	}

	public double getBaseICMSSaida() {
		return baseICMSSaida;
	}

	public void setBaseICMSSaida(double baseICMSSaida) {
		this.baseICMSSaida = baseICMSSaida;
	}

	public double getAliquotaICMSSaida() {
		return aliquotaICMSSaida;
	}

	public void setAliquotaICMSSaida(double aliquotaICMSSaida) {
		this.aliquotaICMSSaida = aliquotaICMSSaida;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(aliquotaICMSEntrada);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(aliquotaICMSSaida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(baseICMSEntrada);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(baseICMSSaida);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cidades == null) ? 0 : cidades.hashCode());
		result = prime * result + idEstado;
		result = prime * result + ((nomeEstado == null) ? 0 : nomeEstado.hashCode());
		result = prime * result + ((unidadeFederal == null) ? 0 : unidadeFederal.hashCode());
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
		Estado other = (Estado) obj;
		if (Double.doubleToLongBits(aliquotaICMSEntrada) != Double.doubleToLongBits(other.aliquotaICMSEntrada))
			return false;
		if (Double.doubleToLongBits(aliquotaICMSSaida) != Double.doubleToLongBits(other.aliquotaICMSSaida))
			return false;
		if (Double.doubleToLongBits(baseICMSEntrada) != Double.doubleToLongBits(other.baseICMSEntrada))
			return false;
		if (Double.doubleToLongBits(baseICMSSaida) != Double.doubleToLongBits(other.baseICMSSaida))
			return false;
		if (cidades == null) {
			if (other.cidades != null)
				return false;
		} else if (!cidades.equals(other.cidades))
			return false;
		if (idEstado != other.idEstado)
			return false;
		if (nomeEstado == null) {
			if (other.nomeEstado != null)
				return false;
		} else if (!nomeEstado.equals(other.nomeEstado))
			return false;
		if (unidadeFederal == null) {
			if (other.unidadeFederal != null)
				return false;
		} else if (!unidadeFederal.equals(other.unidadeFederal))
			return false;
		return true;
	}

}
