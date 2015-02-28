/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Converter.CidadeConverter;
import Modelo.Cidade;
import Modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mv
 */
@ManagedBean
@SessionScoped
public class PessoaBean {

    /**
     * Creates a new instance of PessoaBean
     */
    
    private Pessoa pessoa;
    private List<Pessoa> listaPessoas;
    private List<Cidade> listaCidades;
    private CidadeConverter conversorCidade;
    private Boolean editando;
    private String msg;    
       
    public PessoaBean() {
        this.editando = false;
        this.pessoa = new Pessoa();
        this.listaPessoas = new ArrayList();
        this.listaCidades = new ArrayList();
        
        this.listaCidades.add(new Cidade(1, "Bauru", "SP"));
        this.listaCidades.add(new Cidade(2, "Lins", "SP"));
        this.listaCidades.add(new Cidade(3, "Avare", "SP"));
        this.listaCidades.add(new Cidade(4, "Jaú", "SP"));
        this.listaCidades.add(new Cidade(5, "Poxoréu", "MS"));
        
        this.conversorCidade = new CidadeConverter(listaCidades);
        
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public void setListaPessoas(List<Pessoa> listaPessoas) {
        this.listaPessoas = listaPessoas;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public CidadeConverter getConversorCidade() {
        return conversorCidade;
    }

    public void setConversorCidade(CidadeConverter conversorCidade) {
        this.conversorCidade = conversorCidade;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String salvar(){
        if(this.pessoa.getId()==null){
            this.pessoa.setId(this.listaPessoas.size() + 1);
            this.listaPessoas.add(this.pessoa);
        }
        msg = "ID: " + this.pessoa.getId();
        msg += " Nome: " + this.pessoa.getNome();
        msg += " E-Mail: " + this.pessoa.getEmail();
        msg += " Telefone: " + this.pessoa.getTelefone();
        msg += " Cidade: " + this.pessoa.getCidade().getNome() + " - " + this.pessoa.getCidade().getUf();
        FacesMessage fmsg = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(null, fmsg);
        this.editando = false;
        this.pessoa = new Pessoa();
        //return "cadPessoa";
        return "cadPessoaValidation";
    }
    
    public String voltar(){
        this.editando = true;
        this.msg = "";
        this.pessoa = new Pessoa();
        //return "cadPessoa";
        return "cadPessoaValidation";
    }
    
}
