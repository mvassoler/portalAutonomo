package agencia.turismo.controle;

import agencia.turismo.dao.AgenciaDAO;
import agencia.turismo.dao.LocalidadesDAO;
import agencia.turismo.modelo.Agencia;
import agencia.turismo.modelo.Localidades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class LocalidadeBean implements Serializable {

    private List<Localidades> localidades;
    private Localidades localidade;
    private Agencia agencia;
    private HttpSession sessao;
    private boolean edicao;

    public LocalidadeBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        sessao = (HttpSession) ec.getSession(false);

        this.iniciarObjetosTela();
    }

    public List<Localidades> getLocalidades() {
        LocalidadesDAO dao = new LocalidadesDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        this.localidades = dao.obterTodasLocalidades();
        return this.localidades;
    }

    public void setLocalidades(List<Localidades> localidades) {
        this.localidades = localidades;
    }

    public Localidades getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidades localidade) {
        this.localidade = localidade;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
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
        this.localidade = new Localidades();
        this.localidades = new ArrayList<>();
    }

    public void salvar() {
        try {
            this.localidade.setAgencia(this.agencia);
            LocalidadesDAO dao = new LocalidadesDAO();
            dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
            dao.salvar(this.localidade);
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

    public void editar(Localidades loc) {
        this.localidade = loc;
        this.agencia = loc.getAgencia();
        this.edicao = true;
    }

    public void excluir(Localidades loc) {
        try {
            this.localidade = loc;
            LocalidadesDAO dao = new LocalidadesDAO();
            dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
            dao.excluir(this.localidade);
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

    public List<Agencia> buscarAgencias(String query) {
        List<Agencia> lista = new ArrayList<>();
        AgenciaDAO dao = new AgenciaDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        for (Agencia ag : dao.obterTodasAgencias()) {
            if (ag.getNome().toUpperCase().startsWith(query.toUpperCase())) {
                lista.add(ag);
            }
        }
        return lista;
    }

    public void prepararAdd() {
        this.agencia = new Agencia();
        this.localidade = new Localidades();
        this.edicao = false;
    }

    public void definirObjeto(SelectEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (event.getObject().getClass().getSimpleName().equalsIgnoreCase("Agencia")) {
            agencia = (Agencia) event.getObject();
        }
    }

}
