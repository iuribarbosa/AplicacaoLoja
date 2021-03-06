/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.PedidosDAOListener;
import Mapeamento.Pedidos;
import Util.FabricaDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class PedidosRN {
    private PedidosDAOListener ped;
    public PedidosRN() {
        this.ped = FabricaDAO.criarPedidosDAO();
    }
    
    
    public void alterar(Pedidos al){
        this.ped.alterar(al);
    }

    public Pedidos consultar(int ID){
        return this.ped.consultar(ID);
    }
    
    public void excluir(Pedidos al){
        this.ped.excluir(al);
    }

    public List<Pedidos> listarSemFiltro(){
        return this.ped.listarSemFiltro();
    }

    public List<Pedidos> obterTodos(){
        return this.ped.obterTodos();
    }

    public void salvar(Pedidos al){
        this.ped.salvar(al);
    }

    public void setSessao(Session sessao){
        this.ped.setSessao(sessao);
    }
    public Pedidos buscarData(Date data){
        return this.ped.buscarData(data);
    }
     public Pedidos consultarListaID(int id, int tipo){
        return this.ped.consultarListaID(id, tipo);
    }
    public List<Pedidos> listarComFiltro(int id){
        return this.ped.listarComFiltro(id);
    }
    public List<Pedidos> listarComFiltroEData(int id, Date data){
        return this.ped.listarComFiltroEData(id,data);
    }
    public double listarPorMês(String ano, String mes, String dia){
        return this.ped.listarPorMês(ano,mes,dia);
    }
    public double listarPorAno(String ano){
        return this.ped.listarPorAno(ano);
    }
    public double listarPorMêsAP(String ano, String mes){
        return this.ped.listarPorMêsAP(ano,mes);
    }
    public double listarPorMêsTotal(String ano, String mes){
        return this.ped.listarPorMêsTotal(ano,mes);
    }
    public double listarPorMêsAV(String ano, String mes){
        return this.ped.listarPorMêsAV(ano,mes);
    }
    public double listarPorDia(String ano, String mes, String dia){
        return this.ped.listarPorDia(ano,mes,dia);
    }
    public double listarPorDiaAP(String ano, String mes, String dia){
        return this.ped.listarPorDiaAP(ano,mes,dia);
    }
    public double listarPorDiaAV(String ano, String mes, String dia){
        return this.ped.listarPorDiaAV(ano,mes,dia);
    }
}
