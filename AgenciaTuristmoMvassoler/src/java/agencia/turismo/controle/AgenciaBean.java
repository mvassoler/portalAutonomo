package agencia.turismo.controle;

import agencia.turismo.dao.AgenciaDAO;
import agencia.turismo.modelo.Agencia;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class AgenciaBean {

    private Agencia agencia;
    private List<Agencia> agencias;
    private HttpSession sessao;
    private boolean edicao;

    public AgenciaBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        sessao = (HttpSession) ec.getSession(false);

        this.iniciarObjetosTela();
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Agencia> getAgencias() {
        AgenciaDAO dao = new AgenciaDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        this.agencias = dao.obterTodasAgencias();
        return this.agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public HttpSession getSessao() {
        return sessao;
    }

    public void setSessao(HttpSession sessao) {
        this.sessao = sessao;
    }

    public boolean isEdicao() {
        return edicao;
    }

    public void setEdicao(boolean edicao) {
        this.edicao = edicao;
    }

    private void iniciarObjetosTela() {
        this.agencia = new Agencia();
        this.agencias = new ArrayList<>();
    }

    public void salvar() {
        try {
            AgenciaDAO dao = new AgenciaDAO();
            dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
            dao.salvar(this.agencia);
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "SALVAR", "SALVO COM SUCESSO!");
            fc.addMessage(null, fm);

        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO AO SALVAR", e.getMessage());
            fc.addMessage(null, fm);
        } finally {
            this.prepararAdd();
        }
    }

    public void editar(Agencia age) {
        this.agencia = age;
        this.edicao = true;
    }

    public void excluir(Agencia age) {
        try {
            this.agencia = age;
            AgenciaDAO dao = new AgenciaDAO();
            dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
            dao.excluir(this.agencia);
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "EXCLUIR", "EXCLUSÃO BEM SUCEDIDA!");
            fc.addMessage(null, fm);
        } catch (Exception e) {
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "ERRO AO EXCLUIR", e.getMessage());
            fc.addMessage(null, fm);
        } finally {
            this.prepararAdd();
        }
    }

    public void prepararAdd() {
        this.agencia = new Agencia();
        this.edicao = false;
    }

}
