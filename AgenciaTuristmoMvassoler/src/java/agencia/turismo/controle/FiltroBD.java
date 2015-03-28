/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.controle;

import agencia.turismo.dao.HibernateUtil;
import agencia.turismo.modelo.Usuarios;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;

/**
 *
 * @author Anderson Pazin
 */

public class FiltroBD implements Filter{

    private SessionFactory sf;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sf=HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessao=req.getSession();
        try{
            sf.getCurrentSession().beginTransaction();
            sessao.setAttribute("sessaoBD", sf.getCurrentSession());
            Usuarios user = (Usuarios) sessao.getAttribute("userSessao");
          //  System.out.println(req.getRequestURI());
            if(isPermitido(req.getRequestURI(), user)){
                chain.doFilter(request, response);
            }else {
                req.getRequestDispatcher("catalogo.xhtml")
                                    .forward(request, response);
            }
            sf.getCurrentSession().getTransaction().commit();
            sf.getCurrentSession().close();
        } catch (TransactionException ex){
            if(sf.getCurrentSession().getTransaction().isActive()){
                sf.getCurrentSession().getTransaction().rollback();
            }
        }
    }

    @Override
    public void destroy() {
        sf.close();
    }
    
    private boolean isPermitido(String uri, Usuarios user){
        if((user!=null)&&
           (user.getPerfil().equalsIgnoreCase("GESTOR"))){
            return true;
        }
        for(String permitido:uriPermitidosSemLogin()){
            if(uri.contains(permitido)){
                return true;
            }
        }
        return false;
    }
    private List<String> uriPermitidosSemLogin(){
        List<String> uriPermitido = new ArrayList<String>();
        uriPermitido.add("login");
        uriPermitido.add("pesquisa");
        uriPermitido.add("resource");
        uriPermitido.add("destino");
        uriPermitido.add("catalogo");
        return uriPermitido;
    }
}
