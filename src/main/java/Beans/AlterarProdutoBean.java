/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Mapeamento.Produto;
import RN.ProdutoRN;
import Util.FacesUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "alterProd")
@SessionScoped
public class AlterarProdutoBean {

    private Produto produto;
    private List<Produto> listaProdutos;
    private ProdutoRN prodRN;
    private float quantidadeProduto;
    private float valorProduto;
    private String fornecedorProduto;
    private String nomeProduto;
    private int codProduto;
    private boolean qnt;
    private boolean vlr;
    private boolean forn;
    private boolean nome;
    private boolean psq;

    public AlterarProdutoBean() {
        desbloquearPesq();
    }
    
    public List<Produto> carregarProdutos(String nomeProd){
        prodRN = new ProdutoRN();
        return prodRN.buscarFornecedorPorNome(nomeProd);
    }
    
    public void listarProduto(){
//        codProduto = produto.getCodprod();
        nomeProduto = produto.getNomeprod();
        quantidadeProduto = produto.getQtdprod();
        valorProduto = produto.getValorprodAp();
        fornecedorProduto = produto.getNomeforn();
        bloquearPesq();
    }
    public void limparProduto(){
        produto = new Produto();
        listarProduto();
    }
    public void desbloquearPesq(){
    qnt=
    vlr=
    forn=
    nome=true;
    psq=false;
    }
    public void bloquearPesq(){
    qnt=
    vlr=
    forn=
    nome=false;
    psq=true;
    }
    public void setarProduto(){
        produto.setNomeforn(fornecedorProduto);
        produto.setNomeprod(nomeProduto);
        produto.setQtdprod(quantidadeProduto);
        produto.setValorprodAp(valorProduto);
        produto.setDataEntrada(" ");
        produto.setEntrada(" ");
        produto.setHora(" ");
        produto.setSaida(" ");
        produto.setValorprod(0);
    }
    
    public void alterarProduto(){
        try {
            setarProduto();
            prodRN = new ProdutoRN();
            prodRN.alterar(produto);
            limparProduto();
            desbloquearPesq();
            FacesUtil.exibirMensagemSucesso("Produto alterado com Sucesso!");
        } catch (Exception e) {
            System.out.println(e);
            FacesUtil.exibirMensagemErro("Erro ao alterar o produto!");
        }
        
    }
    
    public void voltarHome(){
        RequestContext.getCurrentInstance().execute("location.href='home.xhtml'");
    }
    
    public void cancelar(){
        limparProduto();
        desbloquearPesq();
        
    }
    //Gets e Sets

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(float quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public float getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getFornecedorProduto() {
        return fornecedorProduto;
    }

    public void setFornecedorProduto(String fornecedorProduto) {
        this.fornecedorProduto = fornecedorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public boolean isQnt() {
        return qnt;
    }

    public void setQnt(boolean qnt) {
        this.qnt = qnt;
    }

    public boolean isVlr() {
        return vlr;
    }

    public void setVlr(boolean vlr) {
        this.vlr = vlr;
    }

    public boolean isForn() {
        return forn;
    }

    public void setForn(boolean forn) {
        this.forn = forn;
    }

    public boolean isNome() {
        return nome;
    }

    public void setNome(boolean nome) {
        this.nome = nome;
    }

    public boolean isPsq() {
        return psq;
    }

    public void setPsq(boolean psq) {
        this.psq = psq;
    }

    

}
