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

import br.portal.autonomo.Modelo.PK.TelefonePK;

@Entity
@Table(name = "TELEFONE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "Telefone.findAll", query = "SELECT T FROM Telefone T"),
		@NamedQuery(name = "Telefone.findByCodigo", query = "SELECT T FROM Telefone T WHERE T.pkTelefone.pessoa.cpfCnpj = :cpfCnpj") })
@AssociationOverrides({ @AssociationOverride(name = "pkTelefone.pessoa", joinColumns = @JoinColumn(name = "CPF_CNPJ")), })
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TelefonePK pkTelefone;

	@Column(name = "DDD_TELEFONE", nullable = false)
	private int dddTelefone;

	@Column(name = "NUMERO_TELEFONE", nullable = false)
	private int numeroTelefone;

	@Column(name = "TIPO_TELEFONE", length = 1, nullable = false)
	private char tipoTelefone;

	@Column(name = "OPERADORA_TELEFONE", length = 30, nullable = false)
	private String operadoraTelefone;

	public Telefone() {
		super();
	}

	public Telefone(TelefonePK pkTelefone, int dddTelefone, int numeroTelefone, char tipoTelefone,
			String operadoraTelefone) {
		super();
		this.pkTelefone = pkTelefone;
		this.dddTelefone = dddTelefone;
		this.numeroTelefone = numeroTelefone;
		this.tipoTelefone = tipoTelefone;
		this.operadoraTelefone = operadoraTelefone;
	}

	public TelefonePK getPkTelefone() {
		return pkTelefone;
	}

	public void setPkTelefone(TelefonePK pkTelefone) {
		this.pkTelefone = pkTelefone;
	}

	public int getDddTelefone() {
		return dddTelefone;
	}

	public void setDddTelefone(int dddTelefone) {
		this.dddTelefone = dddTelefone;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public char getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(char tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getOperadoraTelefone() {
		return operadoraTelefone;
	}

	public void setOperadoraTelefone(String operadoraTelefone) {
		this.operadoraTelefone = operadoraTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dddTelefone;
		result = prime * result + numeroTelefone;
		result = prime * result + ((operadoraTelefone == null) ? 0 : operadoraTelefone.hashCode());
		result = prime * result + ((pkTelefone == null) ? 0 : pkTelefone.hashCode());
		result = prime * result + tipoTelefone;
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
		Telefone other = (Telefone) obj;
		if (dddTelefone != other.dddTelefone)
			return false;
		if (numeroTelefone != other.numeroTelefone)
			return false;
		if (operadoraTelefone == null) {
			if (other.operadoraTelefone != null)
				return false;
		} else if (!operadoraTelefone.equals(other.operadoraTelefone))
			return false;
		if (pkTelefone == null) {
			if (other.pkTelefone != null)
				return false;
		} else if (!pkTelefone.equals(other.pkTelefone))
			return false;
		if (tipoTelefone != other.tipoTelefone)
			return false;
		return true;
	}

}
