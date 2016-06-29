/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapeamento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ibarbosa
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
    @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedidos.findByFormaPagamento", query = "SELECT p FROM Pedidos p WHERE p.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "Pedidos.findByDesconto", query = "SELECT p FROM Pedidos p WHERE p.desconto = :desconto"),
    @NamedQuery(name = "Pedidos.findByTotal", query = "SELECT p FROM Pedidos p WHERE p.total = :total"),
    @NamedQuery(name = "Pedidos.findByQuantVezes", query = "SELECT p FROM Pedidos p WHERE p.quantVezes = :quantVezes"),
    @NamedQuery(name = "Pedidos.findByTotalDesconto", query = "SELECT p FROM Pedidos p WHERE p.totalDesconto = :totalDesconto"),
    @NamedQuery(name = "Pedidos.findByTotalParcelas", query = "SELECT p FROM Pedidos p WHERE p.totalParcelas = :totalParcelas"),
    @NamedQuery(name = "Pedidos.findByVendedor", query = "SELECT p FROM Pedidos p WHERE p.vendedor = :vendedor")})
public class Pedidos implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_pagamento")
    private int formaPagamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "desconto")
    private double desconto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quant_vezes")
    private int quantVezes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_desconto")
    private double totalDesconto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_parcelas")
    private double totalParcelas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vendedor")
    private int vendedor;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedidos(Integer idPedido, int formaPagamento, double desconto, double total, int quantVezes, double totalDesconto, double totalParcelas, int vendedor) {
        this.idPedido = idPedido;
        this.formaPagamento = formaPagamento;
        this.desconto = desconto;
        this.total = total;
        this.quantVezes = quantVezes;
        this.totalDesconto = totalDesconto;
        this.totalParcelas = totalParcelas;
        this.vendedor = vendedor;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantVezes() {
        return quantVezes;
    }

    public void setQuantVezes(int quantVezes) {
        this.quantVezes = quantVezes;
    }

    public double getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(double totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public double getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(double totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Pedidos[ idPedido=" + idPedido + " ]";
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
}
