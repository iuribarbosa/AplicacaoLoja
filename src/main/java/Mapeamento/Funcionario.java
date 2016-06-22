/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeamento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Iuri Barbosa
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByCodfunc", query = "SELECT f FROM Funcionario f WHERE f.codfunc = :codfunc"),
    @NamedQuery(name = "Funcionario.findByNomefunc", query = "SELECT f FROM Funcionario f WHERE f.nomefunc = :nomefunc"),
    @NamedQuery(name = "Funcionario.findByUsufunc", query = "SELECT f FROM Funcionario f WHERE f.usufunc = :usufunc"),
    @NamedQuery(name = "Funcionario.findBySenhafunc", query = "SELECT f FROM Funcionario f WHERE f.senhafunc = :senhafunc"),
    @NamedQuery(name = "Funcionario.findByEndfunc", query = "SELECT f FROM Funcionario f WHERE f.endfunc = :endfunc"),
    @NamedQuery(name = "Funcionario.findByCpffunc", query = "SELECT f FROM Funcionario f WHERE f.cpffunc = :cpffunc"),
    @NamedQuery(name = "Funcionario.findByTelfunc", query = "SELECT f FROM Funcionario f WHERE f.telfunc = :telfunc")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codfunc")
    private Integer codfunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nomefunc")
    private String nomefunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "usufunc")
    private String usufunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "senhafunc")
    private String senhafunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "endfunc")
    private String endfunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cpffunc")
    private String cpffunc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telfunc")
    private String telfunc;

    public Funcionario() {
    }

    public Funcionario(Integer codfunc) {
        this.codfunc = codfunc;
    }

    public Funcionario(Integer codfunc, String nomefunc, String usufunc, String senhafunc, String endfunc, String cpffunc, String telfunc) {
        this.codfunc = codfunc;
        this.nomefunc = nomefunc;
        this.usufunc = usufunc;
        this.senhafunc = senhafunc;
        this.endfunc = endfunc;
        this.cpffunc = cpffunc;
        this.telfunc = telfunc;
    }

    public Integer getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Integer codfunc) {
        this.codfunc = codfunc;
    }

    public String getNomefunc() {
        return nomefunc;
    }

    public void setNomefunc(String nomefunc) {
        this.nomefunc = nomefunc;
    }

    public String getUsufunc() {
        return usufunc;
    }

    public void setUsufunc(String usufunc) {
        this.usufunc = usufunc;
    }

    public String getSenhafunc() {
        return senhafunc;
    }

    public void setSenhafunc(String senhafunc) {
        this.senhafunc = senhafunc;
    }

    public String getEndfunc() {
        return endfunc;
    }

    public void setEndfunc(String endfunc) {
        this.endfunc = endfunc;
    }

    public String getCpffunc() {
        return cpffunc;
    }

    public void setCpffunc(String cpffunc) {
        this.cpffunc = cpffunc;
    }

    public String getTelfunc() {
        return telfunc;
    }

    public void setTelfunc(String telfunc) {
        this.telfunc = telfunc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfunc != null ? codfunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codfunc == null && other.codfunc != null) || (this.codfunc != null && !this.codfunc.equals(other.codfunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Funcionario[ codfunc=" + codfunc + " ]";
    }
    
}
