package Beans;

import Mapeamento.Funcionario;
import Mapeamento.Pedidos;
import Mapeamento.Produto;
import Mapeamento.Vendas;
import RN.FuncionarioRN;
import RN.PedidosRN;
import RN.VendasRn;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "previaOrcamento")
@SessionScoped
public class previaOrcamentoBean {

    //Variaveis de Mapeamento
    private Produto produtoSelecionado;
    private List<Produto> produtosInseridos;
    private pesqProdPedidoBean psqPed;
    private Produto produtoExc;
    private Pedidos pedido;
    private PedidosRN pedidoRN;
    private Vendas venda;
    private VendasRn vendaRN;
    private Funcionario func;
    private FuncionarioRN funcRN;
    private Pedidos OrcaRecuperado;
    private Produto prodOrcaRecuperado;
    private List<Vendas> vendasRecuperado;
    private Vendas vendaRecup;
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
    public double quantidade;
    public String vendedor;
    public String numeroPedido;

    //Variaveis de Controle
    public boolean cntParcelas;
    public boolean cntDialog = false;
    private Produto prod1;
    private Produto newProd;
    private int idPedido;
    private String user;
    private String senha;
    private int idControlePed = 0;
    private int controlFunc = 0;
    private boolean controlVersion = true;
    //Construtor
    public previaOrcamentoBean() {
        produtoExc = new Produto();
        produtoSelecionado = new Produto();
        psqPed = new pesqProdPedidoBean();
        produtosInseridos = new ArrayList<>();
        func = new Funcionario();
        verificarTotal();
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

    public void verificarTotal() {
        total = 0;
        newProd = new Produto();
        if (produtosInseridos.size() > 0) {
            for (int i = 0; i <= produtosInseridos.size() - 1; i++) {
                newProd = produtosInseridos.get(i);
                total = total + newProd.getValorprod();
                BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
                totalString = "R$ " + bd;
            }
        } else {
            total = 0;
            BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
            totalString = "R$ " + bd;
        }
    }

    public void pegarFunc() {
        if (controlFunc == 0) {

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = (HttpSession) request.getSession();
            user = (String) session.getAttribute("ID_USUARIO");
            funcRN = new FuncionarioRN();
            func = new Funcionario();
            func = funcRN.buscarFornecedorPorNome(user, senha);
            setarVendedor();
            controlFunc++;
        }
    }

    public void gerarPedido() {
        Date data = new Date();
        pedido.setDesconto(Desconto);
        pedido.setFormaPagamento(formaPag);
        pedido.setQuantVezes(parcelas);
        pedido.setTotal(total);
        pedido.setTotalDesconto(totalDesconto);
        pedido.setTotalParcelas(valorParcelas);
        pedido.setVendedor(15);
        pedido.setData(data);
        pedido.setTipo(2);
    }

    public void gerarVenda() {
        venda.setDescricaoProduto(prod1.getNomeprod());
        venda.setIDPedido(idPedido);
        venda.setIDproduto(prod1.getCodprod());
        venda.setQuantidade(prod1.getQtdprod());
        venda.setTotal(prod1.getValorprod());
        venda.setValor(prod1.getValorprodAp());
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

    public void setarVendedor() {
        vendedor = func.getNomefunc();
    }

    public void abrirDialog() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('confirmarQnt').show()");
    }

    public void imprimir() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("imprimirTela()");
        salvarPedido();
    }

    public void fecharDialog() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('confirmarQnt').hide()");
        quantidade = 0;
    }

    public void abrirDialogExc() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('dlgExc').show()");
    }

    //Funções de fluxo
    public void inserirProduto() {
        produtoSelecionado.setQtdprod((float) quantidade);
        produtoSelecionado.setValorprod(produtoSelecionado.getValorprodAp() * (float) quantidade);
        produtosInseridos.add(produtoSelecionado);
        verificarTotal();

        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("window.opener.location.href='Previa_Orcamento.xhtml'");
        requestContext.execute("PF('confirmarQnt').hide()");
        quantidade = 0;
    }

    public void excluirProduto() {
        prod1 = new Produto();
        try {
            for (int i = 0; i <= produtosInseridos.size() - 1; i++) {
                prod1 = produtosInseridos.get(i);
                int codA = produtoExc.getCodprod();
                int codB = prod1.getCodprod();
                if (codA == codB) {
                    produtosInseridos.remove(i);
                }
            }
            verificarTotal();
        } catch (Exception e) {
            System.out.println(e);
            RequestContext.getCurrentInstance().execute("alert('Erro na exclusão')");
        }
    }

    public String gerarNumeroPedido() {
        if (idControlePed == 0) {
            pedido = new Pedidos();
            gerarPedido();
            pedidoRN = new PedidosRN();
            pedidoRN.salvar(pedido);
            idControlePed++;
            return numeroPedido = pedido.getIdPedido().toString();
        }
        return numeroPedido;
    }

    public void salvarPedido() {
        try {
            gerarPedido();
            pedidoRN = new PedidosRN();
            pedidoRN.alterar(pedido);
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
            idPedido = pedido.getIdPedido();
            prod1 = new Produto();
            for (int i = 0; i <= produtosInseridos.size() - 1; i++) {
                prod1 = produtosInseridos.get(i);
                venda = new Vendas();
                gerarVenda();
                vendaRN = new VendasRn();
                vendaRN.salvar(venda);
            }
//            RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_logout");
//            dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
//            FacesContext.getCurrentInstance().responseComplete();
            RequestContext.getCurrentInstance().execute("location.href='index.jsp'");
//            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        } catch (Exception e) {
            System.out.println(e);
            RequestContext.getCurrentInstance().execute("alert('Erro ao salvar o Pedido')");
        }
    }

    public void cancelarPedido() {
        if(controlVersion){
        pedidoRN = new PedidosRN();
        pedidoRN.excluir(pedido);
        }
        idControlePed = 0;
        controlFunc = 0;
        produtosInseridos.removeAll(produtosInseridos);
        total = 0;
        totalDesconto = 0;
        parcelas = 0;
        Desconto = 0;
        formaPag = 1;
        valorParcelasString = "R$ 0,00";
        cntParcelas = false;
        valorParcelas = 0;
        gerarValorDesconto();
        verificarTotal();
//        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        RequestContext.getCurrentInstance().execute("location.href='home.xhtml'");
    }

    public void carregarOrçamento() {
        idControlePed = 1;
        controlFunc = 1;
        controlVersion = false;
        produtosInseridos.removeAll(produtosInseridos);
        formaPag = OrcaRecuperado.getFormaPagamento();
        Desconto = OrcaRecuperado.getDesconto();
        parcelas = OrcaRecuperado.getQuantVezes();
        total = OrcaRecuperado.getTotal();
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
        totalString = "R$ " + bd;
        totalDesconto = OrcaRecuperado.getTotalDesconto();
        valorParcelas = OrcaRecuperado.getTotalParcelas();
        funcRN = new FuncionarioRN();
        vendedor = funcRN.consultar(OrcaRecuperado.getVendedor()).getNomefunc();
        numeroPedido = OrcaRecuperado.getIdPedido().toString();
        verificarFormaPag();
        gerarValorDesconto();
        vendaRN = new VendasRn();
        vendasRecuperado = vendaRN.buscarFornecedorPorNome(OrcaRecuperado.getIdPedido());
        for(int i = 0; i <= vendasRecuperado.size()-1;i++){
            prodOrcaRecuperado = new Produto();
            vendaRecup = new Vendas();
            vendaRecup = vendasRecuperado.get(i);
            prodOrcaRecuperado.setCodprod(vendaRecup.getIDproduto());
            prodOrcaRecuperado.setNomeprod(vendaRecup.getDescricaoProduto());
            prodOrcaRecuperado.setQtdprod(vendaRecup.getQuantidade());
            prodOrcaRecuperado.setValorprod(vendaRecup.getTotal());
            prodOrcaRecuperado.setValorprodAp(vendaRecup.getValor());
            produtosInseridos.add(prodOrcaRecuperado);
        }
        RequestContext.getCurrentInstance().execute("location.href='Previa_Orcamento.xhtml'");
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
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

    public Funcionario getFunc() {
        return func;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Listas
    public void setFunc(Funcionario func) {
        this.func = func;
    }

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

    public Produto getProdutoExc() {
        return produtoExc;
    }

    public void setProdutoExc(Produto produtoExc) {
        this.produtoExc = produtoExc;
    }

    public Pedidos getOrcaRecuperado() {
        return OrcaRecuperado;
    }

    public void setOrcaRecuperado(Pedidos OrcaRecuperado) {
        this.OrcaRecuperado = OrcaRecuperado;
    }

    public boolean isControlVersion() {
        return controlVersion;
    }

    public void setControlVersion(boolean controlVersion) {
        this.controlVersion = controlVersion;
    }
    
}
