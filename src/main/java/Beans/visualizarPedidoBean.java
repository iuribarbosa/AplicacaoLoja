/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Mapeamento.Pedidos;
import RN.PedidosRN;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean (name = "viewPedido")
@ViewScoped
public class visualizarPedidoBean {
    //Variaveis de Mapeamento
    private Pedidos pedido;
    private PedidosRN pedidoRN;
    private List<Pedidos> listaPedido;
    //Metodo Construtor

    public visualizarPedidoBean() {
        pedidoRN = new PedidosRN();
        listaPedido = pedidoRN.listarSemFiltro();
    }
    
    //Funções
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
    
    //Gets e Sets
    
    //Mapeamento

    public List<Pedidos> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<Pedidos> listaPedido) {
        this.listaPedido = listaPedido;
    }
    
    
}
