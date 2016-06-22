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
 * @author ibarbosa
 */
@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByCodforn", query = "SELECT f FROM Fornecedor f WHERE f.codforn = :codforn"),
    @NamedQuery(name = "Fornecedor.findByNomeforn", query = "SELECT f FROM Fornecedor f WHERE f.nomeforn = :nomeforn"),
    @NamedQuery(name = "Fornecedor.findByCnpjforn", query = "SELECT f FROM Fornecedor f WHERE f.cnpjforn = :cnpjforn"),
    @NamedQuery(name = "Fornecedor.findByEndforn", query = "SELECT f FROM Fornecedor f WHERE f.endforn = :endforn"),
    @NamedQuery(name = "Fornecedor.findByContato", query = "SELECT f FROM Fornecedor f WHERE f.contato = :contato"),
    @NamedQuery(name = "Fornecedor.findByTelContato", query = "SELECT f FROM Fornecedor f WHERE f.telContato = :telContato"),
    @NamedQuery(name = "Fornecedor.findByTelforn", query = "SELECT f FROM Fornecedor f WHERE f.telforn = :telforn")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codforn")
    private Integer codforn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nomeforn")
    private String nomeforn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cnpjforn")
    private String cnpjforn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "endforn")
    private String endforn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "contato")
    private String contato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tel_contato")
    private String telContato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telforn")
    private String telforn;

    public Fornecedor() {
    }

    public Fornecedor(Integer codforn) {
        this.codforn = codforn;
    }

    public Fornecedor(Integer codforn, String nomeforn, String cnpjforn, String endforn, String contato, String telContato, String telforn) {
        this.codforn = codforn;
        this.nomeforn = nomeforn;
        this.cnpjforn = cnpjforn;
        this.endforn = endforn;
        this.contato = contato;
        this.telContato = telContato;
        this.telforn = telforn;
    }

    public Integer getCodforn() {
        return codforn;
    }

    public void setCodforn(Integer codforn) {
        this.codforn = codforn;
    }

    public String getNomeforn() {
        return nomeforn;
    }

    public void setNomeforn(String nomeforn) {
        this.nomeforn = nomeforn;
    }

    public String getCnpjforn() {
        return cnpjforn;
    }

    public void setCnpjforn(String cnpjforn) {
        this.cnpjforn = cnpjforn;
    }

    public String getEndforn() {
        return endforn;
    }

    public void setEndforn(String endforn) {
        this.endforn = endforn;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public String getTelforn() {
        return telforn;
    }

    public void setTelforn(String telforn) {
        this.telforn = telforn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codforn != null ? codforn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.codforn == null && other.codforn != null) || (this.codforn != null && !this.codforn.equals(other.codforn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Fornecedor[ codforn=" + codforn + " ]";
    }
    
}
