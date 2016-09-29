package Beans;

import Mapeamento.Produto;
import RN.ProdutoRN;
import Util.DateMath;
import Util.FacesUtil;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean (name = "cadProd")
@SessionScoped
public class CadProdutoBean {
    //Variaveis da tela
    private String descricao;
    private float qnt;
    private float valor;
    private String fornecedor;
    //Variaveis de mapeamento
    private Produto produto;
    private ProdutoRN prodRN;
    
    //Funções
    public void salvarProd(){
        try {
            prodRN = new ProdutoRN();
            produto = new Produto();
            gerarProduto();
            prodRN.salvar(produto);
            FacesUtil.exibirMensagemSucesso("Produto salvo com sucesso");
            limparCampos();
        } catch (Exception e) {
            FacesUtil.exibirMensagemErro("Erro ao cadastrar Produto");
        }
        
    }
    public void cancelarProd(){
        limparCampos();
    }
    public void limparCampos(){
        descricao = " ";
        qnt = 0;
        valor = 0;
        fornecedor = " ";
    }
    public void gerarProduto(){
        Date data = new Date();
        produto.setNomeprod(descricao);
        produto.setQtdprod(qnt);
        produto.setValorprodAp(valor);
        produto.setNomeforn(fornecedor);
        produto.setDataEntrada(DateMath.obterdata(data));
        produto.setEntrada(" ");
        produto.setHora(" ");
        produto.setSaida(" ");
        produto.setValorprod(0);
    }
    
    public void voltarHome(){
        RequestContext.getCurrentInstance().execute("location.href='home.xhtml'");
    }
    
    //Gets e sets
    //Variaveis de tela

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQnt() {
        return qnt;
    }

    public void setQnt(float qnt) {
        this.qnt = qnt;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
