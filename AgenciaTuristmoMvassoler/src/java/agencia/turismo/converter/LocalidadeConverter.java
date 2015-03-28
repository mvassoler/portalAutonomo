package agencia.turismo.converter;

import agencia.turismo.dao.LocalidadesDAO;
import agencia.turismo.modelo.Localidades;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@FacesConverter("LocalidadeConverter")
public class LocalidadeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ExternalContext ec = fc.getExternalContext();
        HttpSession sessao = (HttpSession) ec.getSession(false);
        LocalidadesDAO dao =  new LocalidadesDAO();
        dao.setSessao((Session) sessao.getAttribute("sessaoBD"));
        Localidades loc = null;
        try{
           loc = dao.getPorId(Integer.parseInt(string));
        }catch (NumberFormatException nex){
            loc=null;
        }catch (Exception ex){
            System.out.println("ERRO CONVERTER LOCALIDADE");
        } 
        return loc;
    }
    

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return String.valueOf(((Localidades) o).getId());
    }
    
}
