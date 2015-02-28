/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Converter.CidadeConverter;
import Modelo.Cidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mv
 */
@ManagedBean
@RequestScoped
public class CidadeBean implements  Serializable{

    /**
     * Creates a new instance of PessoaBean
     */
    
    private Cidade cidadeEscolhida;
    private List<Cidade> listaCidades;
    
    //não ser usado em bd
    private CidadeConverter converte;
    
    public CidadeBean() {
        this.cidadeEscolhida = new Cidade();
        
        //não deve ser utilizado em bando de dados
        this.listaCidades = new ArrayList();
        this.listaCidades.add(new Cidade(1, "Bauru", "SP"));
        this.listaCidades.add(new Cidade(2, "Lins", "SP"));
        this.listaCidades.add(new Cidade(3, "Avare", "SP"));
        this.listaCidades.add(new Cidade(4, "Jaú", "SP"));
        this.listaCidades.add(new Cidade(5, "Poxoréu", "MS"));
        
        this.converte = new CidadeConverter(listaCidades);
        
    }

    public Cidade getCidadeEscolhida() {
        return cidadeEscolhida;
    }

    public void setCidadeEscolhida(Cidade cidadeEscolhida) {
        this.cidadeEscolhida = cidadeEscolhida;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public CidadeConverter getConverte() {
        return converte;
    }

    public void setConverte(CidadeConverter converte) {
        this.converte = converte;
    }
    
    public String exibir(){
        String cidMsg = "Cidade: " + this.cidadeEscolhida.getNome() + 
                " - Estado: " + this.cidadeEscolhida.getUf() + 
                "(" + this.cidadeEscolhida.getId() + ")";
        
        FacesMessage msg = new FacesMessage(cidMsg);
        FacesContext.getCurrentInstance().addMessage(cidMsg, msg);
        return "exConverteCidade";
    }
           
}
