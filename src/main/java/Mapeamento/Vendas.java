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
@Table(name = "vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByIDVenda", query = "SELECT v FROM Vendas v WHERE v.iDVenda = :iDVenda"),
    @NamedQuery(name = "Vendas.findByIDPedido", query = "SELECT v FROM Vendas v WHERE v.iDPedido = :iDPedido"),
    @NamedQuery(name = "Vendas.findByIDproduto", query = "SELECT v FROM Vendas v WHERE v.iDproduto = :iDproduto"),
    @NamedQuery(name = "Vendas.findByDescricaoProduto", query = "SELECT v FROM Vendas v WHERE v.descricaoProduto = :descricaoProduto"),
    @NamedQuery(name = "Vendas.findByValor", query = "SELECT v FROM Vendas v WHERE v.valor = :valor"),
    @NamedQuery(name = "Vendas.findByQuantidade", query = "SELECT v FROM Vendas v WHERE v.quantidade = :quantidade"),
    @NamedQuery(name = "Vendas.findByTotal", query = "SELECT v FROM Vendas v WHERE v.total = :total")})
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Venda")
    private Integer iDVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Pedido")
    private int iDPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_produto")
    private int iDproduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descricaoProduto")
    private String descricaoProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private float valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private float quantidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private float total;

    public Vendas() {
    }

    public Vendas(Integer iDVenda) {
        this.iDVenda = iDVenda;
    }

    public Vendas(Integer iDVenda, int iDPedido, int iDproduto, String descricaoProduto, float valor, float quantidade, float total) {
        this.iDVenda = iDVenda;
        this.iDPedido = iDPedido;
        this.iDproduto = iDproduto;
        this.descricaoProduto = descricaoProduto;
        this.valor = valor;
        this.quantidade = quantidade;
        this.total = total;
    }

    public Integer getIDVenda() {
        return iDVenda;
    }

    public void setIDVenda(Integer iDVenda) {
        this.iDVenda = iDVenda;
    }

    public int getIDPedido() {
        return iDPedido;
    }

    public void setIDPedido(int iDPedido) {
        this.iDPedido = iDPedido;
    }

    public int getIDproduto() {
        return iDproduto;
    }

    public void setIDproduto(int iDproduto) {
        this.iDproduto = iDproduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDVenda != null ? iDVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.iDVenda == null && other.iDVenda != null) || (this.iDVenda != null && !this.iDVenda.equals(other.iDVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Vendas[ iDVenda=" + iDVenda + " ]";
    }
    
}
