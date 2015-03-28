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

import br.portal.autonomo.Modelo.PK.PessoaEnderecoPK;

@Entity
@Table(name = "PESSOA_ENDERECO")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({
		@NamedQuery(name = "PessoaEndereco.findAll", query = "SELECT T FROM PessoaEndereco T"),
		@NamedQuery(name = "PessoaEndereco.findByCodigo", query = "SELECT T FROM PessoaEndereco T WHERE T.pkPessoaEndereco.endereco.cepEndereco = :cepEndereco"
				+ "AND T.pkPessoaEndereco.pessoa.cpfCnpj = :cpfCnpj") })
@AssociationOverrides({
		@AssociationOverride(name = "pkPessoaEndereco.pessoa", joinColumns = @JoinColumn(name = "CPF_CNPJ")),
		@AssociationOverride(name = "pkPessoaEndereco.endereco", joinColumns = @JoinColumn(name = "CEP_ENDERECO")) })
public class PessoaEndereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PessoaEnderecoPK pkPessoaEndereco;

	@Column(name = "NUMERO_ENDERECO", nullable = false)
	private int numeroEndereco;

	@Column(name = "DDD_TELEFONE_FIXO")
	private int dddTelefonefixo;

	@Column(name = "DDD_TELEFONE_CELULAR")
	private int dddTelefoneCelular;

	@Column(name = "NUMERO_TELEFONE_FIXO")
	private int numeroTelefoneFixo;

	@Column(name = "NUMERO_TELEFONE_CELULAR")
	private int numeroTelefoneCelular;

	@Column(name = "OPERADORA_TELEFONE_FIXO", length = 50)
	private String operadoraTelefoneFixo;

	@Column(name = "OPERADORA_TELEFONE_CELULAR", length = 50)
	private String operadoraTelefoneCelular;

	@Column(name = "EMAIL_CONTATO", length = 150)
	private String emailContato;

	public PessoaEndereco() {
		super();
	}

	public PessoaEndereco(PessoaEnderecoPK pkPessoaEndereco, int numeroEndereco, int dddTelefonefixo,
			int dddTelefoneCelular, int numeroTelefoneFixo, int numeroTelefoneCelular, String operadoraTelefoneFixo,
			String operadoraTelefoneCelular, String emailContato) {
		super();
		this.pkPessoaEndereco = pkPessoaEndereco;
		this.numeroEndereco = numeroEndereco;
		this.dddTelefonefixo = dddTelefonefixo;
		this.dddTelefoneCelular = dddTelefoneCelular;
		this.numeroTelefoneFixo = numeroTelefoneFixo;
		this.numeroTelefoneCelular = numeroTelefoneCelular;
		this.operadoraTelefoneFixo = operadoraTelefoneFixo;
		this.operadoraTelefoneCelular = operadoraTelefoneCelular;
		this.emailContato = emailContato;
	}

	public PessoaEnderecoPK getPkPessoaEndereco() {
		return pkPessoaEndereco;
	}

	public void setPkPessoaEndereco(PessoaEnderecoPK pkPessoaEndereco) {
		this.pkPessoaEndereco = pkPessoaEndereco;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public int getDddTelefonefixo() {
		return dddTelefonefixo;
	}

	public void setDddTelefonefixo(int dddTelefonefixo) {
		this.dddTelefonefixo = dddTelefonefixo;
	}

	public int getDddTelefoneCelular() {
		return dddTelefoneCelular;
	}

	public void setDddTelefoneCelular(int dddTelefoneCelular) {
		this.dddTelefoneCelular = dddTelefoneCelular;
	}

	public int getNumeroTelefoneFixo() {
		return numeroTelefoneFixo;
	}

	public void setNumeroTelefoneFixo(int numeroTelefoneFixo) {
		this.numeroTelefoneFixo = numeroTelefoneFixo;
	}

	public int getNumeroTelefoneCelular() {
		return numeroTelefoneCelular;
	}

	public void setNumeroTelefoneCelular(int numeroTelefoneCelular) {
		this.numeroTelefoneCelular = numeroTelefoneCelular;
	}

	public String getOperadoraTelefoneFixo() {
		return operadoraTelefoneFixo;
	}

	public void setOperadoraTelefoneFixo(String operadoraTelefoneFixo) {
		this.operadoraTelefoneFixo = operadoraTelefoneFixo;
	}

	public String getOperadoraTelefoneCelular() {
		return operadoraTelefoneCelular;
	}

	public void setOperadoraTelefoneCelular(String operadoraTelefoneCelular) {
		this.operadoraTelefoneCelular = operadoraTelefoneCelular;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dddTelefoneCelular;
		result = prime * result + dddTelefonefixo;
		result = prime * result + ((emailContato == null) ? 0 : emailContato.hashCode());
		result = prime * result + numeroEndereco;
		result = prime * result + numeroTelefoneCelular;
		result = prime * result + numeroTelefoneFixo;
		result = prime * result + ((operadoraTelefoneCelular == null) ? 0 : operadoraTelefoneCelular.hashCode());
		result = prime * result + ((operadoraTelefoneFixo == null) ? 0 : operadoraTelefoneFixo.hashCode());
		result = prime * result + ((pkPessoaEndereco == null) ? 0 : pkPessoaEndereco.hashCode());
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
		PessoaEndereco other = (PessoaEndereco) obj;
		if (dddTelefoneCelular != other.dddTelefoneCelular)
			return false;
		if (dddTelefonefixo != other.dddTelefonefixo)
			return false;
		if (emailContato == null) {
			if (other.emailContato != null)
				return false;
		} else if (!emailContato.equals(other.emailContato))
			return false;
		if (numeroEndereco != other.numeroEndereco)
			return false;
		if (numeroTelefoneCelular != other.numeroTelefoneCelular)
			return false;
		if (numeroTelefoneFixo != other.numeroTelefoneFixo)
			return false;
		if (operadoraTelefoneCelular == null) {
			if (other.operadoraTelefoneCelular != null)
				return false;
		} else if (!operadoraTelefoneCelular.equals(other.operadoraTelefoneCelular))
			return false;
		if (operadoraTelefoneFixo == null) {
			if (other.operadoraTelefoneFixo != null)
				return false;
		} else if (!operadoraTelefoneFixo.equals(other.operadoraTelefoneFixo))
			return false;
		if (pkPessoaEndereco == null) {
			if (other.pkPessoaEndereco != null)
				return false;
		} else if (!pkPessoaEndereco.equals(other.pkPessoaEndereco))
			return false;
		return true;
	}

}
