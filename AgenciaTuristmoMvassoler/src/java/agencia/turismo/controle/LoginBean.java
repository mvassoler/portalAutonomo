/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.controle;

import agencia.turismo.modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Pazin
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    private String login;
    private String senha;
    private boolean logado;
    private List<Usuarios> listaUsuarios;

    public LoginBean() {
        listaUsuarios = buscarUsuarios();
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuarios> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    private List<Usuarios> buscarUsuarios() {
        List<Usuarios> lista = new ArrayList<>();
        lista.add(new Usuarios("Anderson", "1234", "Gestor"));
        lista.add(new Usuarios("Marcela", "5678", "Gestor"));
        lista.add(new Usuarios("João Lucas", "1111", "Cliente"));
        lista.add(new Usuarios("Felipe", "2222", "Cliente"));
        lista.add(new Usuarios("Rafael", "3333", "Cliente"));
        return lista;
    }
    
    public void entrar(){
        Usuarios tentativa = new Usuarios();
        tentativa.setNome(login);
        tentativa.setSenha(senha);
        logado=false;
        String msg;
        for(Usuarios u:listaUsuarios){
            msg=u.logarUsuario(tentativa);
            if(msg.equalsIgnoreCase("OK")){
                FacesContext fc = FacesContext.getCurrentInstance();
                ExternalContext ec = fc.getExternalContext();
                HttpSession sessao = (HttpSession) ec.getSession(false);
                sessao.setAttribute("userSessao", u);
                logado=true;
                break;
            }
        }
        if(!logado){
            FacesContext fc = FacesContext.getCurrentInstance();
            login="";
            fc.addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                     "ACESSO NEGADO!", "Usuário ou Senha inválido(s)"));
        }
    }
    
    public void sair(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession sessao = (HttpSession) ec.getSession(false);
      //  sessao.invalidate();
        sessao.removeAttribute("userSessao");
        logado=false;
        login="";
        fc.addMessage(null, new FacesMessage(
                                FacesMessage.SEVERITY_INFO, 
                                "SAIR", "Sessão Encerrada."));
        
    }
    

}
