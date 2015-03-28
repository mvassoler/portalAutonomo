/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.dao;

import agencia.turismo.modelo.Agencia;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class AgenciaDAO extends GenericDAO<Agencia> {

    public Agencia getPorId(Integer id) {
        Session ses = getSession();
        //   ses.beginTransaction();
        Agencia ag = null;
        try {
            ag = (Agencia) ses.get(Agencia.class, id);
        } catch (Exception ex) {
            System.out.println("AgenciaDAO.getPorId()");
            ex.printStackTrace();
            return ag;
        }
        //  ses.getTransaction().commit();
        return ag;
    }

    public void salvar(Agencia obj) {
        try {
            if (getPorId(obj.getId()) == null) {
                obj.setDataCadastro(new Date());
                this.inserir(obj);
            } else {
                this.atualizar(obj);
            }
        } catch (Exception ex) {
            System.out.println("AgenciaDAO.salvar()");
            ex.printStackTrace();
        }
    }

    public List<Agencia> obterTodasAgencias() {
        List<Agencia> lista = null;
        Session ses = getSession();
        //  ses.beginTransaction();
        try {
            Criteria c = ses.createCriteria(Agencia.class);
            c.addOrder(Order.asc("nome"));
            lista = c.list();
        } catch (Exception ex) {
            System.out.println("AgenciaDAO.obterTodasAgencias()");
            ex.printStackTrace();
            return null;
        }
        //  ses.getTransaction().commit();
        return lista;
    }

}
