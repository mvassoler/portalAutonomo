/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author mv
 */
public class Pessoa implements Serializable {

    private Integer id;

    @NotEmpty(message = "{modelo.pessoa.nome.notEmpty}")
    private String nome;

    @Email(message = "{modelo.pessoa.email.valido}")
    @NotEmpty(message = "{modelo.pessoa.email.notEmpty}")
    private String email;

    @Pattern(regexp = "\\(\\d{2}\\)\\d{4}\\-\\d{4}", message = "{modelo.pessoa.telefone.pattern}")
    private String telefone;

    @Range(min = 10, max = 80, message = "{modelo.pessoa.idade.range}")
    private int idade;

    @Past(message = "{modelo.pessoa.dataNascimento.past}")
    private Date dataNascimento;

    @DecimalMin(value = "1", message = "{modelo.pessoa.renda.decimalMin}")
    private double renda;

    private Cidade cidade;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, String email, String telefone, int idade, Date dataNascimento, double renda, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + this.idade;
        hash = 37 * hash + Objects.hashCode(this.dataNascimento);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.renda) ^ (Double.doubleToLongBits(this.renda) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.cidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.renda) != Double.doubleToLongBits(other.renda)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

}
