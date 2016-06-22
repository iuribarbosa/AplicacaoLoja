package Beans;

import Mapeamento.Produto;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "previaPedido")
@SessionScoped
public class previaPedidoBean {

    //Variaveis de Mapeamento
    private Produto produtoSelecionado;
    private List<Produto> produtosInseridos;
    private pesqProdPedidoBean psqPed;
    //Variaveis da Tela
    public int formaPag = 1;
    public int parcelas;
    public double Desconto;
    public double total = 0;
    public String totalString;
    public double totalDesconto = 0;
    public String totalDescontoString;
    public double valorParcelas;
    public String valorParcelasString;
    public int quantidade;

    //Variaveis de Controle
    public boolean cntParcelas;
    public boolean cntDialog = false;

    public previaPedidoBean() {
        produtoSelecionado = new Produto();
        psqPed = new pesqProdPedidoBean();
        produtosInseridos = new ArrayList<>();

    }

    //Funções
    //Funções de valores
    public void gerarValorDesconto() {
        totalDesconto = total - (total * (Desconto / 100));
        BigDecimal bd = new BigDecimal(totalDesconto).setScale(2, RoundingMode.HALF_EVEN);
        totalDescontoString = "R$ " + bd;
    }

    public void gerarValorParcelas() {
        valorParcelas = total / parcelas;
        BigDecimal bd = new BigDecimal(valorParcelas).setScale(2, RoundingMode.HALF_EVEN);
        valorParcelasString = "R$ " + bd;
    }

    //Funções de Controles
    public void verificarFormaPag() {
        int i = formaPag;
        if (i == 1) {
            cntParcelas = false;
        } else {
            cntParcelas = true;
        }
    }

    public void abrirDialog(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('confirmarQnt').show()");
        cntDialog = true;
    }
    public void fecharDialog(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('confirmarQnt').hide()");
        cntDialog = false;
        quantidade = 0;
    }
    //Funções de inserção
    public void inserirProduto() {
        produtoSelecionado.setQtdprod(quantidade);
        produtoSelecionado.setValorprod(produtoSelecionado.getValorprodAp() * produtoSelecionado.getQtdprod());
        this.produtosInseridos.add(produtoSelecionado);
        total = total + produtoSelecionado.getValorprod();
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
        totalString = "R$ " + bd;
        RequestContext.getCurrentInstance().execute("window.opener.location.href='faces/Previa_Pedido.xhtml'");
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('confirmarQnt').hide()");
        quantidade = 0;
    }
    
    //Gets e Sets
    //Variaveis da Tela
    public int getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(int formaPag) {
        this.formaPag = formaPag;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getTotalString() {
        return totalString;
    }

    public void setTotalString(String totalString) {
        this.totalString = totalString;
    }

    public String getTotalDescontoString() {
        return totalDescontoString;
    }

    public void setTotalDescontoString(String totalDescontoString) {
        this.totalDescontoString = totalDescontoString;
    }

    public String getValorParcelasString() {
        return valorParcelasString;
    }

    public void setValorParcelasString(String valorParcelasString) {
        this.valorParcelasString = valorParcelasString;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(double totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public double getDesconto() {
        return Desconto;
    }

    public void setDesconto(double Desconto) {
        this.Desconto = Desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    //Variaveis de Controle
    public boolean isCntParcelas() {
        return cntParcelas;
    }

    public void setCntParcelas(boolean cntParcelas) {
        this.cntParcelas = cntParcelas;
    }

    public boolean isCntDialog() {
        return cntDialog;
    }

    public void setCntDialog(boolean cntDialog) {
        this.cntDialog = cntDialog;
    }
    
    //Listas
    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Produto> getProdutosInseridos() {
        return produtosInseridos;
    }

    public void setProdutosInseridos(List<Produto> produtosInseridos) {
        this.produtosInseridos = produtosInseridos;
    }

}
