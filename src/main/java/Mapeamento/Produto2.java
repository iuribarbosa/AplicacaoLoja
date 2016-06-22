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
@Table(name = "produto_2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto2.findAll", query = "SELECT p FROM Produto2 p"),
    @NamedQuery(name = "Produto2.findByCodprod", query = "SELECT p FROM Produto2 p WHERE p.codprod = :codprod"),
    @NamedQuery(name = "Produto2.findByNomeprod", query = "SELECT p FROM Produto2 p WHERE p.nomeprod = :nomeprod"),
    @NamedQuery(name = "Produto2.findByQtdprod", query = "SELECT p FROM Produto2 p WHERE p.qtdprod = :qtdprod"),
    @NamedQuery(name = "Produto2.findByValorprod", query = "SELECT p FROM Produto2 p WHERE p.valorprod = :valorprod"),
    @NamedQuery(name = "Produto2.findByValorprodAp", query = "SELECT p FROM Produto2 p WHERE p.valorprodAp = :valorprodAp"),
    @NamedQuery(name = "Produto2.findByNomeforn", query = "SELECT p FROM Produto2 p WHERE p.nomeforn = :nomeforn"),
    @NamedQuery(name = "Produto2.findByEntrada", query = "SELECT p FROM Produto2 p WHERE p.entrada = :entrada"),
    @NamedQuery(name = "Produto2.findBySaida", query = "SELECT p FROM Produto2 p WHERE p.saida = :saida"),
    @NamedQuery(name = "Produto2.findByDataEntrada", query = "SELECT p FROM Produto2 p WHERE p.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Produto2.findByHora", query = "SELECT p FROM Produto2 p WHERE p.hora = :hora")})
public class Produto2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codprod")
    private Integer codprod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nomeprod")
    private String nomeprod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdprod")
    private int qtdprod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorprod")
    private float valorprod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorprod_ap")
    private float valorprodAp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nomeforn")
    private String nomeforn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada")
    private int entrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saida")
    private int saida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "data_entrada")
    private String dataEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "hora")
    private String hora;

    public Produto2() {
    }

    public Produto2(Integer codprod) {
        this.codprod = codprod;
    }

    public Produto2(Integer codprod, String nomeprod, int qtdprod, float valorprod, float valorprodAp, String nomeforn, int entrada, int saida, String dataEntrada, String hora) {
        this.codprod = codprod;
        this.nomeprod = nomeprod;
        this.qtdprod = qtdprod;
        this.valorprod = valorprod;
        this.valorprodAp = valorprodAp;
        this.nomeforn = nomeforn;
        this.entrada = entrada;
        this.saida = saida;
        this.dataEntrada = dataEntrada;
        this.hora = hora;
    }

    public Integer getCodprod() {
        return codprod;
    }

    public void setCodprod(Integer codprod) {
        this.codprod = codprod;
    }

    public String getNomeprod() {
        return nomeprod;
    }

    public void setNomeprod(String nomeprod) {
        this.nomeprod = nomeprod;
    }

    public int getQtdprod() {
        return qtdprod;
    }

    public void setQtdprod(int qtdprod) {
        this.qtdprod = qtdprod;
    }

    public float getValorprod() {
        return valorprod;
    }

    public void setValorprod(float valorprod) {
        this.valorprod = valorprod;
    }

    public float getValorprodAp() {
        return valorprodAp;
    }

    public void setValorprodAp(float valorprodAp) {
        this.valorprodAp = valorprodAp;
    }

    public String getNomeforn() {
        return nomeforn;
    }

    public void setNomeforn(String nomeforn) {
        this.nomeforn = nomeforn;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSaida() {
        return saida;
    }

    public void setSaida(int saida) {
        this.saida = saida;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto2)) {
            return false;
        }
        Produto2 other = (Produto2) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mapeamento.Produto2[ codprod=" + codprod + " ]";
    }
    
}
