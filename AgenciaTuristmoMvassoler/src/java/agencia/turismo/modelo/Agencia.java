/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.turismo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lab
 */
@Entity
@Table(name="Agencias")
public class Agencia implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(length=40)
    private String nome;
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @OneToMany(mappedBy="agencia")
    private List<Localidades> localidades;

    public Agencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Localidades> getLocalidades() {
        return localidades;
    }

    public void setLocalidades(List<Localidades> localidades) {
        this.localidades = localidades;
    }
    
    public Localidades encontrarLocalidades(String nome){
        Localidades encontrado = null;
        for (Localidades local : localidades) {
            if(local.getNome().equalsIgnoreCase(nome)){
                encontrado = local;
            }
        }
        return encontrado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final Agencia other = (Agencia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    
}
