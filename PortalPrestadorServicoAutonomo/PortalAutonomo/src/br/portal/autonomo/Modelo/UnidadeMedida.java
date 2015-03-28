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
@Table(name = "UNIDADE_MEDIDA", uniqueConstraints = { @UniqueConstraint(columnNames = "SIGLA_MEDIDA", name = "UNIDADE_MEDIDA_UK_SIGLA_MEDIDA") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT T FROM UnidadeMedida T"),
		@NamedQuery(name = "UnidadeMedida.findByCodigo", query = "SELECT T FROM UnidadeMedida T WHERE T.idMedida = :idMedida") })
public class UnidadeMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID_MEDIDA", nullable = false)
	private int idMedida;

	@Column(name = "DESCRICAO_MEDIDA", length = 100, nullable = false)
	private String descricaoMedida;

	@Column(name = "SIGLA_MEDIDA", length = 5, nullable = false)
	private String siglaMedida;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "unidadeMedida")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Item> itens = new ArrayList<Item>();

	public UnidadeMedida() {

	}

	public UnidadeMedida(int idMedida, String descricaoMedida, String siglaMedida, List<Item> itens) {
		this.idMedida = idMedida;
		this.descricaoMedida = descricaoMedida;
		this.siglaMedida = siglaMedida;
		this.itens = itens;
	}

	public int getIdMedida() {
		return idMedida;
	}

	public void setIdMedida(int idMedida) {
		this.idMedida = idMedida;
	}

	public String getDescricaoMedida() {
		return descricaoMedida;
	}

	public void setDescricaoMedida(String descricaoMedida) {
		this.descricaoMedida = descricaoMedida;
	}

	public String getSiglaMedida() {
		return siglaMedida;
	}

	public void setSiglaMedida(String siglaMedida) {
		this.siglaMedida = siglaMedida;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoMedida == null) ? 0 : descricaoMedida.hashCode());
		result = prime * result + idMedida;
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((siglaMedida == null) ? 0 : siglaMedida.hashCode());
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
		UnidadeMedida other = (UnidadeMedida) obj;
		if (descricaoMedida == null) {
			if (other.descricaoMedida != null)
				return false;
		} else if (!descricaoMedida.equals(other.descricaoMedida))
			return false;
		if (idMedida != other.idMedida)
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (siglaMedida == null) {
			if (other.siglaMedida != null)
				return false;
		} else if (!siglaMedida.equals(other.siglaMedida))
			return false;
		return true;
	};

}
