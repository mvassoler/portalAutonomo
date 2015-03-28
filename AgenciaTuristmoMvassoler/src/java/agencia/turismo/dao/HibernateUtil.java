/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author lab
 */
public class HibernateUtil {
    private static final SessionFactory sessao = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        } catch (Throwable e){
            System.out.println("Criação da conexão inicial falhou!");
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessao;
    }
    
    public static void criarBanco(){
        AnnotationConfiguration cfg= new AnnotationConfiguration();
        cfg.configure("hibernate.cfg.xml");
        SchemaExport se = new SchemaExport(cfg);
        se.create(true, true);
    }
    
    public static void main(String args[]){
        HibernateUtil.criarBanco();
    }
}
