package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "NCM")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "NCM.findAll", query = "SELECT T FROM NCM T"),
		@NamedQuery(name = "NCM.findByCodigo", query = "SELECT T FROM NCM T WHERE T.codigoNCM = :codigoNCM") })
public class NCM implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_NCM", length = 8, nullable = false)
	private String codigoNCM;

	@Column(name = "DESCRICAO_NCM", length = 100, nullable = false)
	private String descricaoNCM;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ncm")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Item> itens = new ArrayList<Item>();

	public NCM() {

	}

	public NCM(String codigoNCM, String descricaoNCM, List<Item> itens) {
		this.codigoNCM = codigoNCM;
		this.descricaoNCM = descricaoNCM;
		this.itens = itens;
	}

	public String getCodigoNCM() {
		return codigoNCM;
	}

	public void setCodigoNCM(String codigoNCM) {
		this.codigoNCM = codigoNCM;
	}

	public String getDescricaoNCM() {
		return descricaoNCM;
	}

	public void setDescricaoNCM(String descricaoNCM) {
		this.descricaoNCM = descricaoNCM;
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
		result = prime * result + ((codigoNCM == null) ? 0 : codigoNCM.hashCode());
		result = prime * result + ((descricaoNCM == null) ? 0 : descricaoNCM.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
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
		NCM other = (NCM) obj;
		if (codigoNCM == null) {
			if (other.codigoNCM != null)
				return false;
		} else if (!codigoNCM.equals(other.codigoNCM))
			return false;
		if (descricaoNCM == null) {
			if (other.descricaoNCM != null)
				return false;
		} else if (!descricaoNCM.equals(other.descricaoNCM))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		return true;
	}

}
