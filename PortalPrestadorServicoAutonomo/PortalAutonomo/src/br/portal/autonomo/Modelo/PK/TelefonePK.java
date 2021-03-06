package br.portal.autonomo.Modelo.PK;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import br.portal.autonomo.Modelo.Pessoa;

@Embeddable
public class TelefonePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "TELEFONE_FK_PESSOA")
	private Pessoa pessoa;

	@Column(name = "SEQUENCIA_TELEFONE", nullable = false)
	private int sequenciaTelefone;

	public TelefonePK() {
		super();
	}

	public TelefonePK(Pessoa pessoa, int sequenciaTelefone) {
		super();
		this.pessoa = pessoa;
		this.sequenciaTelefone = sequenciaTelefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getSequenciaTelefone() {
		return sequenciaTelefone;
	}

	public void setSequenciaTelefone(int sequenciaTelefone) {
		this.sequenciaTelefone = sequenciaTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + sequenciaTelefone;
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
		TelefonePK other = (TelefonePK) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (sequenciaTelefone != other.sequenciaTelefone)
			return false;
		return true;
	}

}
