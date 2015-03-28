package br.portal.autonomo.Modelo;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.portal.autonomo.Modelo.PK.ListaEmailPK;

@Entity
@Table(name = "LISTA_EMAIL")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "ListaEmail.findAll", query = "SELECT T FROM ListaEmail T"),
		@NamedQuery(name = "ListaEmail.findByCodigo", query = "SELECT T FROM ListaEmail T WHERE T.pkListaEmail.pessoa.cpfCnpj = :cpfCnpj") })
@AssociationOverrides({ @AssociationOverride(name = "pkListaEmail.pessoa", joinColumns = @JoinColumn(name = "CPF_CNPJ")), })
public class ListaEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListaEmailPK pkListaEmail;

	@Column(name = "EMAIL_LISTA", length = 150, nullable = false)
	private String emailLista;

	public ListaEmail() {
		super();
	}

	public ListaEmail(ListaEmailPK pkListaEmail, String emailLista) {
		super();
		this.pkListaEmail = pkListaEmail;
		this.emailLista = emailLista;
	}

	public ListaEmailPK getPkListaEmail() {
		return pkListaEmail;
	}

	public void setPkListaEmail(ListaEmailPK pkListaEmail) {
		this.pkListaEmail = pkListaEmail;
	}

	public String getEmailLista() {
		return emailLista;
	}

	public void setEmailLista(String emailLista) {
		this.emailLista = emailLista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailLista == null) ? 0 : emailLista.hashCode());
		result = prime * result + ((pkListaEmail == null) ? 0 : pkListaEmail.hashCode());
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
		ListaEmail other = (ListaEmail) obj;
		if (emailLista == null) {
			if (other.emailLista != null)
				return false;
		} else if (!emailLista.equals(other.emailLista))
			return false;
		if (pkListaEmail == null) {
			if (other.pkListaEmail != null)
				return false;
		} else if (!pkListaEmail.equals(other.pkListaEmail))
			return false;
		return true;
	}

}
