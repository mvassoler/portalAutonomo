/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.dao;

import agencia.turismo.modelo.Agencia;
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
public class LocalidadesDAO extends GenericDAO<Localidades> {

    public Localidades getPorId(Integer id) {
        Session ses = getSession();
        try {
          //  ses.beginTransaction();
            return (Localidades) ses.get(Localidades.class, id);
        } catch (Exception ex) {
            System.out.println("LocalidadeDAO.getPorId()");
            ex.printStackTrace();
            return null;
        } finally{
          //  ses.getTransaction().commit();
        }
    }

    public void salvar(Localidades obj) {
        try {
            if (getPorId(obj.getId()) == null) {
                this.inserir(obj);
            } else {
                this.atualizar(obj);
            }
        } catch (Exception ex) {
            System.out.println("LocalidadeDAO.salvar()");
            ex.printStackTrace();
        }
    }

    public List<Localidades> obterTodasLocalidades() {
        List<Localidades> lista = null;
        Session ses = getSession();
       // ses.beginTransaction();
        try {
            Criteria c = ses.createCriteria(Localidades.class);
            c.addOrder(Order.asc("nome"));
            lista = c.list();
        } catch (Exception ex) {
            System.out.println("LocalidadesDAO.obterTodasLocalidades()");
            ex.printStackTrace();
            return null;
        }
       // ses.getTransaction().commit();
        return lista;
    }

    public List<Localidades> obterLocalidadesPorAgencia(Agencia ag) {
        List<Localidades> lista = null;
        Session ses = getSession();
       // ses.beginTransaction();
        try {
            Criteria c = ses.createCriteria(Localidades.class);
            Criterion filtro = Restrictions.eq("agencia.id", ag.getId());
            c.add(filtro);
            c.addOrder(Order.asc("nome"));
            lista = c.list();
        } catch (Exception ex) {
            System.out.println("LocalidadesDAO.obterLocalidadesPorAgencia()");
            ex.printStackTrace();
            return null;
        }
       // ses.getTransaction().commit();
        return lista;
    }

    public List<Localidades> obterLocalidadesPorDestino(String destino) {
        List<Localidades> lista = null;
        Session ses = getSession();
        ses.beginTransaction();
        try {
            Criteria c = ses.createCriteria(Localidades.class);
            destino+="%";
            Criterion filtro = Restrictions.like("nome",destino).ignoreCase();
            c.add(filtro);
            c.addOrder(Order.asc("nome"));
            lista = c.list();
        } catch (Exception ex) {
            System.out.println("LocalidadesDAO.obterLocalidadesPorDestino()");
            ex.printStackTrace();
            return null;
        }
        ses.getTransaction().commit();
        return lista;
    }

    
    
    
}
