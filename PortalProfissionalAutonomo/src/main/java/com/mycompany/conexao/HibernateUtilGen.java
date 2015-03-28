/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author lab
 */
public class HibernateUtilGen {
    private static final SessionFactory sessaoGen = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            AnnotationConfiguration cfg = new AnnotationConfiguration();
            cfg.configure("hibernate.cfgGen.xml");
            return cfg.buildSessionFactory();
        } catch (Throwable e){
            System.out.println("Criação da conexão inicial falhou!");
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessaoGen;
    }
    
    public static void criarBanco(){
        AnnotationConfiguration cfg= new AnnotationConfiguration();
        cfg.configure("hibernate.cfgGen.xml");
        SchemaExport se = new SchemaExport(cfg);
        se.create(true, true);
    }
    
    public static void main(String args[]){
        HibernateUtilGen.criarBanco();
    }
}
