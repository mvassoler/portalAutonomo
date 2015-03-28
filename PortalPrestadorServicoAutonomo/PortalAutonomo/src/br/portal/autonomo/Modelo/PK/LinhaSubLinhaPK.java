package br.portal.autonomo.Modelo.PK;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import br.portal.autonomo.Modelo.Linha;
import br.portal.autonomo.Modelo.SubLinha;

@Embeddable
public class LinhaSubLinhaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "LINHA_SUBLINHA_FK_LINHA")
	private Linha linha;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "LINHA_SUBLINHA_FK_SUBLINHA")
	private SubLinha subLinha;

	public LinhaSubLinhaPK() {

	}

	public LinhaSubLinhaPK(Linha linha, SubLinha subLinha) {
		this.linha = linha;
		this.subLinha = subLinha;
	}

	public Linha getLinha() {
		return linha;
	}

	public void setLinha(Linha linha) {
		this.linha = linha;
	}

	public SubLinha getSubLinha() {
		return subLinha;
	}

	public void setSubLinha(SubLinha subLinha) {
		this.subLinha = subLinha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
		result = prime * result + ((subLinha == null) ? 0 : subLinha.hashCode());
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
		LinhaSubLinhaPK other = (LinhaSubLinhaPK) obj;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		if (subLinha == null) {
			if (other.subLinha != null)
				return false;
		} else if (!subLinha.equals(other.subLinha))
			return false;
		return true;
	}

}
