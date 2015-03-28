package agencia.turismo.controle;

import agencia.turismo.dao.HospedagemDAO;
import agencia.turismo.dao.LocalidadesDAO;
import agencia.turismo.modelo.Localidades;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@ManagedBean
@ViewScoped
public class CatalogoBean implements Serializable {

    private List<Localidades> listaLocalidades;
    private Localidades localEscolhido;
    private HttpSession sessao ;
    
    public CatalogoBean() {
        // para recuperar a sessão
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        sessao = (HttpSession) ec.getSession(false);
        //
        LocalidadesDAO daoLoc = new LocalidadesDAO();
        daoLoc.setSessao((Session) sessao.getAttribute("sessaoBD"));
        listaLocalidades = daoLoc.obterTodasLocalidades();
    }

    public HttpSession getSessao() {
        return sessao;
    }

    public void setSessao(HttpSession sessao) {
        this.sessao = sessao;
    }

    public List<Localidades> getListaLocalidades() {
        return listaLocalidades;
    }

    public void setListaLocalidades(List<Localidades> listaLocalidades) {
        this.listaLocalidades = listaLocalidades;
    }

    public Localidades getLocalEscolhido() {
        return localEscolhido;
    }

    public void setLocalEscolhido(Localidades localEscolhido) {
        this.localEscolhido = localEscolhido;
        getListaHospedagens();
    }
    
    private void getListaHospedagens(){
        HospedagemDAO dao = new HospedagemDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        localEscolhido.setHospedagens(
                dao.obterHospedagemPorLocal(localEscolhido));
    }
}

