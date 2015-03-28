/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testes;

import com.mycompany.conexao.HibernateUtil;
import com.mycompany.modelo.Usuario;
import java.util.Date;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author mv
 */
public class TesteIncluirUsuario {

   public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Usuario usuario = new Usuario();

        session.beginTransaction();

        usuario.setCPF(16177168809l);
        usuario.setDataBase("marcos_vassoler");
        usuario.setDateInclude(new Date());
        usuario.setDialect("org.hibernate.dialect.MySQLDialect");
        usuario.setDriverClass("com.mysql.jdbc.Driver");
        usuario.setEmail("marcosvassoler@yahoo.com.br");
        usuario.setName("Marcos Vassoler");
        usuario.setPasswordUser("mitco");
        usuario.setUserName("mvassoler");
        usuario.setUrl("jdbc:mysql://localhost:3306/");
        session.save(usuario);
        
        session.getTransaction().commit();
        session.getSessionFactory().close();
    }
}
