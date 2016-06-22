package Beans;

import Mapeamento.Produto;
import RN.ProdutoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pesqProdPedido")
@SessionScoped
public class pesqProdPedidoBean {
    ProdutoRN prod;
    private Produto produto;
    public Produto produtoSelecionado;
    private List<Produto> produtos;
    private String pesqProduto;
    

    public pesqProdPedidoBean() {
        produto = new Produto();
        produtoSelecionado = new Produto();
    }
    
    //Funçoes
    
    public void pesquisarProd(){
        prod = new ProdutoRN();
        this.produtos = prod.buscarFornecedorPorNome(pesqProduto);
    }
    
    
    //Gets e Sets

    public String getPesqProduto() {
        return pesqProduto;
    }

    public void setPesqProduto(String pesqProduto) {
        this.pesqProduto = pesqProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }


}
