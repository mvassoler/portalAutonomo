/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lab
 */
public abstract class GenericDAO<T> {

    private SessionFactory sf;
    private Session sessao;

    public GenericDAO() {
        this.sf = HibernateUtil.getSessionFactory();
    }

    public Session getSession() {
        return this.sf.getCurrentSession();
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public void inserir(T obj) {
        try {
           // sessao.beginTransaction();
            sessao.save(obj);
           // sessao.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void atualizar(T obj) {
        try {
          //  sessao.beginTransaction();
            sessao.merge(obj);
          //  sessao.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(T obj) {
        try {
           // sessao.beginTransaction();
            sessao.delete(obj);
          //  sessao.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
