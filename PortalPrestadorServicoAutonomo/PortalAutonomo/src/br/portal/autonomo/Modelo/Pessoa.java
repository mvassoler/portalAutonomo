package br.portal.autonomo.Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

@Entity
@Table(name = "PESSOA", uniqueConstraints = { @UniqueConstraint(columnNames = "INSCRICAO_RG", name = "PESSOA_UK_INSCRICAO_RG") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@NamedQueries({ @NamedQuery(name = "Pessoa.findAll", query = "SELECT T FROM Pessoa T"),
		@NamedQuery(name = "Pessoa.findByCodigo", query = "SELECT T FROM Pessoa T WHERE T.cpfCnpj = :cpfCnpj") })
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF_CNPJ")
	private long cpfCnpj;

	@Column(name = "INSCRICAO_RG", nullable = false)
	private long inscricaoRg;

	@Column(name = "NOME_PESSOA", length = 100, nullable = false)
	@Index(name = "PESSOA_INDEX_NOME_PESSOA", columnNames = "CEP_CIDADE")
	private String nomePessoa;

	@Column(name = "NOME_FANTASIA", length = 100)
	private String nomeFantasia;

	@Column(name = "TIPO_PESSOA", length = 1, nullable = false)
	private char tipoPessoa;

	@Column(name = "TIPO_FORNECEDOR")
	private int tipoFornecedor;

	@Column(name = "TIPO_CLIENTE")
	private int tipoCliente;

	@Column(name = "TIPO_AUTONOMO")
	private int tipoAutonomo;

	@Column(name = "SITUACAO", length = 1, nullable = false)
	private char situacao;

	@Column(name = "LIMITE_CREDITO", precision = 15, scale = 2)
	private BigDecimal limiteCredito;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkPessoaEndereco.pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<PessoaEndereco> pessoaEnderecos = new ArrayList<PessoaEndereco>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkContato.pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Contato> contatos = new ArrayList<Contato>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkListaEmail.pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<ListaEmail> listaEmails = new ArrayList<ListaEmail>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pkTelefone.pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Telefone> telefones = new ArrayList<Telefone>();

	@ManyToOne
	@JoinColumn(name = "TIPO_BLOQUEIO_CREDITO")
	@Cascade(CascadeType.SAVE_UPDATE)
	@ForeignKey(name = "PESSOA_FK_TIPO_BLOQUEIO_CREDITO")
	private TipoBloqueioCredito tipoBloqueioCredito;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Fornecedor fornecedor;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Cliente cliente;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "pessoa")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Autonomo autonomo;

	public Pessoa() {
		super();
	}

	public Pessoa(long cpfCnpj, long inscricaoRg, String nomePessoa, String nomeFantasia, char tipoPessoa,
			int tipoFornecedor, int tipoCliente, int tipoAutonomo, char situacao, BigDecimal limiteCredito,
			Date dataCadastro, List<PessoaEndereco> pessoaEnderecos, List<Contato> contatos,
			List<ListaEmail> listaEmails, List<Telefone> telefones, TipoBloqueioCredito tipoBloqueioCredito,
			Fornecedor fornecedor, Cliente cliente, Autonomo autonomo) {
		super();
		this.cpfCnpj = cpfCnpj;
		this.inscricaoRg = inscricaoRg;
		this.nomePessoa = nomePessoa;
		this.nomeFantasia = nomeFantasia;
		this.tipoPessoa = tipoPessoa;
		this.tipoFornecedor = tipoFornecedor;
		this.tipoCliente = tipoCliente;
		this.tipoAutonomo = tipoAutonomo;
		this.situacao = situacao;
		this.limiteCredito = limiteCredito;
		this.dataCadastro = dataCadastro;
		this.pessoaEnderecos = pessoaEnderecos;
		this.contatos = contatos;
		this.listaEmails = listaEmails;
		this.telefones = telefones;
		this.tipoBloqueioCredito = tipoBloqueioCredito;
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.autonomo = autonomo;
	}

	public long getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(long cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public long getInscricaoRg() {
		return inscricaoRg;
	}

	public void setInscricaoRg(long inscricaoRg) {
		this.inscricaoRg = inscricaoRg;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public List<PessoaEndereco> getPessoaEnderecos() {
		return pessoaEnderecos;
	}

	public void setPessoaEnderecos(List<PessoaEndereco> pessoaEnderecos) {
		this.pessoaEnderecos = pessoaEnderecos;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<ListaEmail> getListaEmails() {
		return listaEmails;
	}

	public void setListaEmails(List<ListaEmail> listaEmails) {
		this.listaEmails = listaEmails;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public int getTipoFornecedor() {
		return tipoFornecedor;
	}

	public void setTipoFornecedor(int tipoFornecedor) {
		this.tipoFornecedor = tipoFornecedor;
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public int getTipoAutonomo() {
		return tipoAutonomo;
	}

	public void setTipoAutonomo(int tipoAutonomo) {
		this.tipoAutonomo = tipoAutonomo;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public TipoBloqueioCredito getTipoBloqueioCredito() {
		return tipoBloqueioCredito;
	}

	public void setTipoBloqueioCredito(TipoBloqueioCredito tipoBloqueioCredito) {
		this.tipoBloqueioCredito = tipoBloqueioCredito;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Autonomo getAutonomo() {
		return autonomo;
	}

	public void setAutonomo(Autonomo autonomo) {
		this.autonomo = autonomo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autonomo == null) ? 0 : autonomo.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((contatos == null) ? 0 : contatos.hashCode());
		result = prime * result + (int) (cpfCnpj ^ (cpfCnpj >>> 32));
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + (int) (inscricaoRg ^ (inscricaoRg >>> 32));
		result = prime * result + ((limiteCredito == null) ? 0 : limiteCredito.hashCode());
		result = prime * result + ((listaEmails == null) ? 0 : listaEmails.hashCode());
		result = prime * result + ((nomeFantasia == null) ? 0 : nomeFantasia.hashCode());
		result = prime * result + ((nomePessoa == null) ? 0 : nomePessoa.hashCode());
		result = prime * result + ((pessoaEnderecos == null) ? 0 : pessoaEnderecos.hashCode());
		result = prime * result + situacao;
		result = prime * result + ((telefones == null) ? 0 : telefones.hashCode());
		result = prime * result + tipoAutonomo;
		result = prime * result + ((tipoBloqueioCredito == null) ? 0 : tipoBloqueioCredito.hashCode());
		result = prime * result + tipoCliente;
		result = prime * result + tipoFornecedor;
		result = prime * result + tipoPessoa;
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
		Pessoa other = (Pessoa) obj;
		if (autonomo == null) {
			if (other.autonomo != null)
				return false;
		} else if (!autonomo.equals(other.autonomo))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (contatos == null) {
			if (other.contatos != null)
				return false;
		} else if (!contatos.equals(other.contatos))
			return false;
		if (cpfCnpj != other.cpfCnpj)
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (inscricaoRg != other.inscricaoRg)
			return false;
		if (limiteCredito == null) {
			if (other.limiteCredito != null)
				return false;
		} else if (!limiteCredito.equals(other.limiteCredito))
			return false;
		if (listaEmails == null) {
			if (other.listaEmails != null)
				return false;
		} else if (!listaEmails.equals(other.listaEmails))
			return false;
		if (nomeFantasia == null) {
			if (other.nomeFantasia != null)
				return false;
		} else if (!nomeFantasia.equals(other.nomeFantasia))
			return false;
		if (nomePessoa == null) {
			if (other.nomePessoa != null)
				return false;
		} else if (!nomePessoa.equals(other.nomePessoa))
			return false;
		if (pessoaEnderecos == null) {
			if (other.pessoaEnderecos != null)
				return false;
		} else if (!pessoaEnderecos.equals(other.pessoaEnderecos))
			return false;
		if (situacao != other.situacao)
			return false;
		if (telefones == null) {
			if (other.telefones != null)
				return false;
		} else if (!telefones.equals(other.telefones))
			return false;
		if (tipoAutonomo != other.tipoAutonomo)
			return false;
		if (tipoBloqueioCredito == null) {
			if (other.tipoBloqueioCredito != null)
				return false;
		} else if (!tipoBloqueioCredito.equals(other.tipoBloqueioCredito))
			return false;
		if (tipoCliente != other.tipoCliente)
			return false;
		if (tipoFornecedor != other.tipoFornecedor)
			return false;
		if (tipoPessoa != other.tipoPessoa)
			return false;
		return true;
	}

}
