/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mv
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    
    @Column(name = "cpf", nullable = false)
    private long CPF;
    
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    
    @Column(name = "driver_class", length = 200, nullable = false)
    private String driverClass;
    
    @Column(name = "data_base", length = 200, nullable = false)
    private String dataBase;
    
    @Column(name = "url", length = 200, nullable = false)
    private String url;
    
    @Column(name = "dialect", length = 200, nullable = false)
    private String dialect;
    
    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;
    
    @Column(name = "password_user", length = 100, nullable = false)
    private String passwordUser;
    
    @Column(name = "email", length = 200, nullable = false)
    private String email;
    
    @Column(name = "date_include", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInclude;

    public Usuario() {
    }

    public Usuario(Long id, long CPF, String name, String driverClass, String dataBase, String url, String dialect, String userName, String passwordUser, String email, Date dateInclude) {
        this.id = id;
        this.CPF = CPF;
        this.name = name;
        this.driverClass = driverClass;
        this.dataBase = dataBase;
        this.url = url;
        this.dialect = dialect;
        this.userName = userName;
        this.passwordUser = passwordUser;
        this.email = email;
        this.dateInclude = dateInclude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDataBase() {
        return dataBase;
    }

    public void setDataBase(String dataBase) {
        this.dataBase = dataBase;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateInclude() {
        return dateInclude;
    }

    public void setDateInclude(Date dateInclude) {
        this.dateInclude = dateInclude;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + (int) (this.CPF ^ (this.CPF >>> 32));
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.driverClass);
        hash = 53 * hash + Objects.hashCode(this.dataBase);
        hash = 53 * hash + Objects.hashCode(this.url);
        hash = 53 * hash + Objects.hashCode(this.dialect);
        hash = 53 * hash + Objects.hashCode(this.userName);
        hash = 53 * hash + Objects.hashCode(this.passwordUser);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.dateInclude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.CPF != other.CPF) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.driverClass, other.driverClass)) {
            return false;
        }
        if (!Objects.equals(this.dataBase, other.dataBase)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.dialect, other.dialect)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.passwordUser, other.passwordUser)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.dateInclude, other.dateInclude)) {
            return false;
        }
        return true;
    }
    
    
    
}
