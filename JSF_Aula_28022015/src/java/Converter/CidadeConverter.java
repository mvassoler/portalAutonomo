/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

import Modelo.Cidade;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mv
 */
@FacesConverter("CidadeConverter")
public class CidadeConverter implements Converter {

    //Não deve ser usado em caso de conexão com banco de dados
    private List<Cidade> listaCidades;

    public CidadeConverter() {
    }

    public CidadeConverter(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }

    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public void setListaCidades(List<Cidade> listaCidades) {
        this.listaCidades = listaCidades;
    }
    //*****************************************

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cidade cid = null;
        //com bd faria assim
        //List<Cidade> lista = obDao.getTodasCidades();

        for (Cidade cidade : listaCidades) {
            if (cidade.getId().equals(Integer.parseInt(value))) {
                cid = cidade;
            }
        }
        return cid;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        return ((Cidade) value).getId().toString();
    }

}
