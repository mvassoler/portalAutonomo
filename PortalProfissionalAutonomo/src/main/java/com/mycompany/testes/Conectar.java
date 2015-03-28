/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testes;

import com.mycompany.conexao.HibernateUtil;
import com.mycompany.modelo.Pessoa;
import java.util.UUID;
import org.hibernate.Session;

/**
 *
 * @author mv
 */
public class Conectar {
    
    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Pessoa pessoa;
        
        session.beginTransaction();
        for(int i = 0; i <= 100; i++){
            pessoa = new Pessoa();
            UUID variavel = UUID.randomUUID();
            pessoa.setNome(variavel.toString());
            session.save(pessoa);
            System.out.println(pessoa.getNome());
        }
        session.getTransaction().commit();
        session.getSessionFactory().close();
    }
}
