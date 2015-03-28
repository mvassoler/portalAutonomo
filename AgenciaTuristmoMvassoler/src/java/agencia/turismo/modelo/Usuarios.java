/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.modelo;

/**
 *
 * @author lab
 */
public class Usuarios {

    private String nome;
    private String senha;
    private String perfil;

    public Usuarios() {
    }

    public Usuarios(String nome, String senha, String perfil) {
        this.nome = nome;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String logarUsuario(Usuarios tentativa) {
        String msg = "OK";
        if (this.nome.equalsIgnoreCase(tentativa.getNome())) {
            if (this.senha.equalsIgnoreCase(tentativa.getSenha())) {
                msg = "OK";
            } else {
                msg = "Usuário e/ou Senha inválido(s)";
            }
        } else {
            msg = "Usuário e/ou Senha inválido(s)";
        }
        return msg;
    }
//    
//    public List acessoGestor(String menu){
//        if
//    }
}
