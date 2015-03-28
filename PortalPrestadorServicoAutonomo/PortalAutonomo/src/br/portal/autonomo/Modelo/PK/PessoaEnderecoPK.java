package br.portal.autonomo.Modelo.PK;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;

import br.portal.autonomo.Modelo.Endereco;
import br.portal.autonomo.Modelo.Pessoa;

@Embeddable
public class PessoaEnderecoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "PESSOA_ENDERECO_FK_PESSOA")
	private Pessoa pessoa;

	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "PESSOA_ENDERECO_FK_ENDERECO")
	private Endereco endereco;

	@Column(name = "TIPO_ENDERECO", length = 1, nullable = false)
	private char tipoEndereco;

	public PessoaEnderecoPK() {
		super();
	}

	public PessoaEnderecoPK(Pessoa pessoa, Endereco endereco, char tipoEndereco) {
		super();
		this.pessoa = pessoa;
		this.endereco = endereco;
		this.tipoEndereco = tipoEndereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public char getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(char tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + tipoEndereco;
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
		PessoaEnderecoPK other = (PessoaEnderecoPK) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (tipoEndereco != other.tipoEndereco)
			return false;
		return true;
	}

}
