/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.PedidoDAOListener;
import Mapeamento.Pedido;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class PedidoRN {
    private PedidoDAOListener ped;

    public PedidoRN() {
        this.ped = FabricaDAO.criarPedidoDAO();
    }
    public void alterar(Pedido al){
        this.ped.alterar(al);
    }

    public Pedido consultar(int ID){
        return this.ped.consultar(ID);
    }
    
    public void excluir(Pedido al){
        this.ped.excluir(al);
    }

    public List<Pedido> listarSemFiltro(){
        return this.ped.listarSemFiltro();
    }

    public List<Pedido> obterTodos(){
        return this.ped.obterTodos();
    }

    public void salvar(Pedido al){
        this.ped.salvar(al);
    }

    public void setSessao(Session sessao){
        this.ped.setSessao(sessao);
    }
    
}
