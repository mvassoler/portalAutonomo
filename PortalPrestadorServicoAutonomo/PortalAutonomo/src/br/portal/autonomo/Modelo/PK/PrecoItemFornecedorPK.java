package br.portal.autonomo.Modelo.PK;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import br.portal.autonomo.Modelo.Fornecedor;
import br.portal.autonomo.Modelo.Item;

@Embeddable
public class PrecoItemFornecedorPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "PRECO_ITEM_FORNECEDOR_FK_ITEM")
	private Item item;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "PRECO_ITEM_FORNECEDOR_FK_FORNECEDOR")
	private Fornecedor fornecedor;

	public PrecoItemFornecedorPK() {
		super();
	}

	public PrecoItemFornecedorPK(Item item, Fornecedor fornecedor) {
		super();
		this.item = item;
		this.fornecedor = fornecedor;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		PrecoItemFornecedorPK other = (PrecoItemFornecedorPK) obj;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
