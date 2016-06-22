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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ibarbosa
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByCoditem", query = "SELECT i FROM Item i WHERE i.coditem = :coditem"),
    @NamedQuery(name = "Item.findByCodpeditem", query = "SELECT i FROM Item i WHERE i.codpeditem = :codpeditem"),
    @NamedQuery(name = "Item.findByCodproditem", query = "SELECT i FROM Item i WHERE i.codproditem = :codproditem"),
    @NamedQuery(name = "Item.findByQtditem", query = "SELECT i FROM Item i WHERE i.qtditem = :qtditem")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coditem")
    private Integer coditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codpeditem")
    private int codpeditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codproditem")
    private int codproditem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtditem")
    private float qtditem;

    public Item() {
    }

    public Item(Integer coditem) {
        this.coditem = coditem;
    }

    public Item(Integer coditem, int codpeditem, int codproditem, float qtditem) {
        this.coditem = coditem;
        this.codpeditem = codpeditem;
        this.codproditem = codproditem;
        this.qtditem = qtditem;
    }

    public Integer getCoditem() {
        return coditem;
    }

    public void setCoditem(Integer coditem) {
        this.coditem = coditem;
    }

    public int getCodpeditem() {
        return codpeditem;
    }

    public void setCodpeditem(int codpeditem) {
        this.codpeditem = codpeditem;
    }

    public int getCodproditem() {
        return codproditem;
    }

    public void setCodproditem(int codproditem) {
        this.codproditem = codproditem;
    }

    public float getQtditem() {
        return qtditem;
    }

    public void setQtditem(float qtditem) {
        this.qtditem = qtditem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coditem != null ? coditem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.coditem == null && other.coditem != null) || (this.coditem != null && !this.coditem.equals(other.coditem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Item[ coditem=" + coditem + " ]";
    }
    
}
