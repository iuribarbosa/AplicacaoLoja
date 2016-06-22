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
@Table(name = "pedido2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido2.findAll", query = "SELECT p FROM Pedido2 p"),
    @NamedQuery(name = "Pedido2.findByCodped", query = "SELECT p FROM Pedido2 p WHERE p.codped = :codped"),
    @NamedQuery(name = "Pedido2.findByCodfuncped", query = "SELECT p FROM Pedido2 p WHERE p.codfuncped = :codfuncped"),
    @NamedQuery(name = "Pedido2.findByPedidoFechado", query = "SELECT p FROM Pedido2 p WHERE p.pedidoFechado = :pedidoFechado"),
    @NamedQuery(name = "Pedido2.findByDataped", query = "SELECT p FROM Pedido2 p WHERE p.dataped = :dataped")})
public class Pedido2 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codped")
    private Integer codped;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codfuncped")
    private int codfuncped;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pedido_fechado")
    private int pedidoFechado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "dataped")
    private String dataped;

    public Pedido2() {
    }

    public Pedido2(Integer codped) {
        this.codped = codped;
    }

    public Pedido2(Integer codped, int codfuncped, int pedidoFechado, String dataped) {
        this.codped = codped;
        this.codfuncped = codfuncped;
        this.pedidoFechado = pedidoFechado;
        this.dataped = dataped;
    }

    public Integer getCodped() {
        return codped;
    }

    public void setCodped(Integer codped) {
        this.codped = codped;
    }

    public int getCodfuncped() {
        return codfuncped;
    }

    public void setCodfuncped(int codfuncped) {
        this.codfuncped = codfuncped;
    }

    public int getPedidoFechado() {
        return pedidoFechado;
    }

    public void setPedidoFechado(int pedidoFechado) {
        this.pedidoFechado = pedidoFechado;
    }

    public String getDataped() {
        return dataped;
    }

    public void setDataped(String dataped) {
        this.dataped = dataped;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codped != null ? codped.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido2)) {
            return false;
        }
        Pedido2 other = (Pedido2) object;
        if ((this.codped == null && other.codped != null) || (this.codped != null && !this.codped.equals(other.codped))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Pedido2[ codped=" + codped + " ]";
    }
    
}
