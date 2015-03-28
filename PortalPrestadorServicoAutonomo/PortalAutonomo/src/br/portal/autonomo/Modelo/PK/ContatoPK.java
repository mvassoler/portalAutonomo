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
public class ContatoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "CONTATO_FK_PESSOA")
	private Pessoa pessoa;

	@Column(name = "SEQUENCIA_CONTATO", nullable = false)
	private int sequenciaContato;

	public ContatoPK() {
		super();
	}

	public ContatoPK(Pessoa pessoa, int sequenciaContato) {
		super();
		this.pessoa = pessoa;
		this.sequenciaContato = sequenciaContato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getSequenciaContato() {
		return sequenciaContato;
	}

	public void setSequenciaContato(int sequenciaContato) {
		this.sequenciaContato = sequenciaContato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + sequenciaContato;
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
		ContatoPK other = (ContatoPK) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (sequenciaContato != other.sequenciaContato)
			return false;
		return true;
	}

}
