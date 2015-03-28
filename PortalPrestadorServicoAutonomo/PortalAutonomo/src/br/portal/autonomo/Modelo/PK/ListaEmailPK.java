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
public class ListaEmailPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "LISTA_EMAIL_FK_PESSOA")
	private Pessoa pessoa;

	@Column(name = "SEQUENCIA_LISTA_EMAIL")
	private int sequenciaListaEmail;

	public ListaEmailPK() {
		super();
	}

	public ListaEmailPK(Pessoa pessoa, int sequenciaListaEmail) {
		super();
		this.pessoa = pessoa;
		this.sequenciaListaEmail = sequenciaListaEmail;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getSequenciaListaEmail() {
		return sequenciaListaEmail;
	}

	public void setSequenciaListaEmail(int sequenciaListaEmail) {
		this.sequenciaListaEmail = sequenciaListaEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + sequenciaListaEmail;
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
		ListaEmailPK other = (ListaEmailPK) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (sequenciaListaEmail != other.sequenciaListaEmail)
			return false;
		return true;
	}

}
