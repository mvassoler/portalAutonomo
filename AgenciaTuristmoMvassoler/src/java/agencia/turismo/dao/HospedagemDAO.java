/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.dao;

import agencia.turismo.modelo.Hospedagem;
import agencia.turismo.modelo.Localidades;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lab
 */
public class HospedagemDAO extends GenericDAO<Hospedagem> {

    public Hospedagem getPorId(Integer id) {
        Session ses = getSession();
        try {
            //   ses.beginTransaction();
            return (Hospedagem) ses.get(Hospedagem.class, id);
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.getPorId()");
            ex.printStackTrace();
            return null;
        } finally {
            //ses.getTransaction().commit();
        }
    }

    public void salvar(Hospedagem obj) {
        try {
            if (getPorId(obj.getId()) == null) {
                this.inserir(obj);
            } else {
                this.atualizar(obj);
            }
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.salvar()");
            ex.printStackTrace();
        }
    }

    public List<Hospedagem> obterHospedagemPorLocal(Localidades local) {
        List<Hospedagem> lista = null;
        Session ses = getSession();
        //  ses.beginTransaction();
        try {
            Criteria c = ses.createCriteria(Hospedagem.class);
            Criterion filtro = Restrictions.eq("local.id", local.getId());
            c.add(filtro);
            c.addOrder(Order.asc("descricao"));
            lista = c.list();
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.obterHospedagemPorLocal()");
            ex.printStackTrace();
            return null;
        }
        // ses.getTransaction().commit();
        return lista;
    }

    public List<Hospedagem> obterTodasHospedagens() {
        List<Hospedagem> lista = null;
        Session ses = getSession();
        try {
            Criteria c = ses.createCriteria(Hospedagem.class);
            c.createAlias("local", "local");
            c.addOrder(Order.asc("local.nome"));
            lista = c.list();
        } catch (Exception ex) {
            System.out.println("HospedagemDAO.obterTodasHospedagens()");
            ex.printStackTrace();
            return null;
        }
        return lista;
    }


}
