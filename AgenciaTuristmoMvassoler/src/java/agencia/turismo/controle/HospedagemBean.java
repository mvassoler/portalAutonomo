package agencia.turismo.controle;

import agencia.turismo.dao.AgenciaDAO;
import agencia.turismo.dao.HospedagemDAO;
import agencia.turismo.dao.LocalidadesDAO;
import agencia.turismo.modelo.Agencia;
import agencia.turismo.modelo.Hospedagem;
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
public class HospedagemBean implements Serializable {

    // para alimentar o dataTable
    private List<Hospedagem> listaHospedagens;
    // objeto usado para inserir/atualizar/excluir
    private Hospedagem hospedagem;
    private HttpSession sessao;
    private Localidades local;
    private Agencia agencia;
    private boolean edicao;

    public HospedagemBean() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        sessao = (HttpSession) ec.getSession(false);
        iniciarObjetosTela();
    }

    public Localidades getLocal() {
        return local;
    }

    public void setLocal(Localidades local) {
        this.local = local;
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

    public List<Hospedagem> getListaHospedagens() {
        HospedagemDAO dao = new HospedagemDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        listaHospedagens = dao.obterTodasHospedagens();
        return listaHospedagens;
    }

    public void setListaHospedagens(List<Hospedagem> listaHospedagens) {
        this.listaHospedagens = listaHospedagens;
    }

    public Hospedagem getHospedagem() {
        return hospedagem;
    }

    public void setHospedagem(Hospedagem hospedagem) {
        this.hospedagem = hospedagem;
    }

    public String permiteEdicao() {
        return edicao + "";
    }

    private void iniciarObjetosTela() {
        hospedagem = new Hospedagem();
        listaHospedagens = new ArrayList<>();
    }

    public void prepararAdd() {
        hospedagem = new Hospedagem();
        local = new Localidades();
        agencia = new Agencia();
        edicao = false;
    }

    public void salvar() {
        try {
            this.hospedagem.setLocal(local);
            HospedagemDAO dao = new HospedagemDAO();
            dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
            dao.salvar(hospedagem);
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

    public void editar(Hospedagem hosp) {
        this.hospedagem = hosp;
        this.local = hosp.getLocal();
        this.agencia = hosp.getLocal().getAgencia();
        this.edicao = true;
    }

    public void excluir(Hospedagem hosp) {
        try {
            this.hospedagem = hosp;
            HospedagemDAO dao = new HospedagemDAO();
            dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
            dao.excluir(hospedagem);
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

    public List<Localidades> buscarLocalidade(String query) {
        List<Localidades> lista = new ArrayList<>();
        LocalidadesDAO dao = new LocalidadesDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        for (Localidades loc : dao.obterLocalidadesPorAgencia(agencia)) {
            if (loc.getNome().toUpperCase().startsWith(query.toUpperCase())) {
                lista.add(loc);
            }
        }
        return lista;
    }

    public void definirObjeto(SelectEvent event) {
        FacesContext fc = FacesContext.getCurrentInstance();
        if (event.getObject().getClass().getSimpleName().
                equalsIgnoreCase("Agencia")) {
            agencia = (Agencia) event.getObject();
        } else if (event.getObject().getClass().getSimpleName().
                equalsIgnoreCase("Localidades")) {
            local = (Localidades) event.getObject();
        }
    }
}
