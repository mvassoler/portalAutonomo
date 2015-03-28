/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testes;

import com.mycompany.conexao.HibernateUtil;
import com.mycompany.conexao.HibernateUtilGen;
import com.mycompany.modelo.Usuario;
import java.util.Date;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author mv
 */
public class TesteTrocarConfiguracao {
    
    
    
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Usuario usuario = null;

        session.beginTransaction();

        Query query = session.createQuery("from Usuario u WHERE u.userName = 'mvassoler' and u.passwordUser = 'mitco'");     
        usuario = (Usuario) query.uniqueResult();
      
        session.getSessionFactory().close();
        
        System.out.println(usuario.getName());
        
        Configuration config = new Configuration().configure("hibernate.cfgGen.xml");
        config.setProperty("connection.driver_class", usuario.getDriverClass());
        config.setProperty("connection.url", usuario.getUrl() + usuario.getDataBase());
        config.setProperty("hibernate.dialect", usuario.getDialect());
        SchemaExport se = new SchemaExport(config);
        se.create(true, true);
    }
}
