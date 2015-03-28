package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import br.portal.autonomo.Modelo.PK.LinhaSubLinhaPK;

@Entity
@Table(name = "LINHA_SUBLINHA")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "LinhaSubLinha.findAll", query = "SELECT T FROM LinhaSubLinha T"),
		@NamedQuery(name = "LinhaSubLinha.findByCodigo", query = "SELECT T FROM LinhaSubLinha T WHERE T.pkLinhaSubLinha.linha.codigoLinha = :codigoLinha and T.pkLinhaSubLinha.subLinha.codigoSublinha = :codigoSublinha") })
@AssociationOverrides({
		@AssociationOverride(name = "pkLinhaSubLinha.linha", joinColumns = @JoinColumn(name = "CODIGO_LINHA")),
		@AssociationOverride(name = "pkLinhaSubLinha.subLinha", joinColumns = @JoinColumn(name = "CODIGO_SUBLINHA")) })
public class LinhaSubLinha implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LinhaSubLinhaPK pkLinhaSubLinha;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "linhaSubLinha")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Item> itens = new ArrayList<Item>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "linhaSubLinha")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Servico> servicos = new ArrayList<Servico>();

	public LinhaSubLinha() {

	}

	public LinhaSubLinha(LinhaSubLinhaPK pkLinhaSubLinha, List<Item> itens) {
		this.pkLinhaSubLinha = pkLinhaSubLinha;
		this.itens = itens;
	}

	public LinhaSubLinha(LinhaSubLinhaPK pkLinhaSubLinha, List<Item> itens, List<Servico> servicos) {
		super();
		this.pkLinhaSubLinha = pkLinhaSubLinha;
		this.itens = itens;
		this.servicos = servicos;
	}

	public LinhaSubLinhaPK getPkLinhaSubLinha() {
		return pkLinhaSubLinha;
	}

	public void setPkLinhaSubLinha(LinhaSubLinhaPK pkLinhaSubLinha) {
		this.pkLinhaSubLinha = pkLinhaSubLinha;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((pkLinhaSubLinha == null) ? 0 : pkLinhaSubLinha.hashCode());
		result = prime * result + ((servicos == null) ? 0 : servicos.hashCode());
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
		LinhaSubLinha other = (LinhaSubLinha) obj;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (pkLinhaSubLinha == null) {
			if (other.pkLinhaSubLinha != null)
				return false;
		} else if (!pkLinhaSubLinha.equals(other.pkLinhaSubLinha))
			return false;
		if (servicos == null) {
			if (other.servicos != null)
				return false;
		} else if (!servicos.equals(other.servicos))
			return false;
		return true;
	}

}
