/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Mapeamento.Funcionario;
import Mapeamento.Pedidos;
import RN.FuncionarioRN;
import RN.PedidosRN;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.core.Request;
import org.primefaces.context.RequestContext;

@ManagedBean (name = "viewOrcamento")
@SessionScoped
public class visualizarOrcamentoBean {
    //Variaveis de Mapeamento
    private Pedidos pedido;
    private PedidosRN pedidoRN;
    private List<Pedidos> listaPedido;
    private FuncionarioRN funcRN;
    private Funcionario func;
    
    //Variaveis de pesquisa 
    private int pesqPed;
    
    //Metodo Construtor

    public visualizarOrcamentoBean() {
        gerarLista();
    }
    
    //Funções
    public void gerarLista(){
        pedidoRN = new PedidosRN();
        listaPedido = pedidoRN.listarComFiltro(2);
    }
    public String getDate(Date data){
       String s= " ";
        try {
           SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");           
           s = f.format(data);
           Date date = (Date) f.parse(s);
           
           
           return s;
       } catch (ParseException parseException) {
           return s;
       }
   }
    
    public BigDecimal setaDoisDecimais(float valor){
        BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN);
        return bd;
    }
    
    public String pesqVendedor(int id){
        funcRN = new FuncionarioRN();
        func = new Funcionario();
        func = funcRN.consultar(id);
        return func.getNomefunc();
    }
    
    public String definirFormPag(int id){
        String s;
        if(id == 1){
            s = "Avista";
        }
        else{
            s = "A Prazo";
        }
        return s;
    }
    
    public void pesquisarPedido(){
        try {
            pedidoRN = new PedidosRN();
            pedido = new Pedidos();
            pedido = pedidoRN.consultarListaID(pesqPed, 2);
            if(pedido != null){
            listaPedido.removeAll(listaPedido);
            listaPedido.add(pedido);
            }
            else{
                RequestContext.getCurrentInstance().execute("alert('Orçamento não existe')");
            }
        } catch (Exception e) {
            RequestContext.getCurrentInstance().execute("alert('Orçamento não existe')");
        }
    }
    //Gets e Sets
    
    //Mapeamento

    public List<Pedidos> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<Pedidos> listaPedido) {
        this.listaPedido = listaPedido;
    }
    
    //Variaveis de Pesquisa

    public int getPesqPed() {
        return pesqPed;
    }

    public void setPesqPed(int pesqPed) {
        this.pesqPed = pesqPed;
    }
    
    
    
}
