package Beans;

import Mapeamento.Produto;
import RN.ProdutoRN;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pesqProdOrcamento")
@SessionScoped
public class pesqProdOrcamentoBean {
    ProdutoRN prod;
    private Produto produto;
    private List<Produto> produtos;
    private String pesqProduto;

    public pesqProdOrcamentoBean() {
        produto = new Produto();
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
    
}
