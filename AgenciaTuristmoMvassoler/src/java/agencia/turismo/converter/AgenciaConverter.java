package agencia.turismo.converter;

import agencia.turismo.dao.AgenciaDAO;
import agencia.turismo.modelo.Agencia;
import agencia.turismo.modelo.Localidades;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@FacesConverter("AgenciaConverter")
public class AgenciaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ExternalContext ec = fc.getExternalContext();
        HttpSession sessao = (HttpSession) ec.getSession(false);
        AgenciaDAO dao =  new AgenciaDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        Agencia agencia = null;
        try{
           agencia = dao.getPorId(Integer.parseInt(string));
        }catch (NumberFormatException nex){
            agencia=null;
        }catch (Exception ex){
            System.out.println("ERRO CONVERTER AGENCIA");
        } 
        return agencia;
    }
    

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return String.valueOf(((Agencia) o).getId());
    }
    
}
