/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.Pedido2DAOListener;
import Mapeamento.Pedido2;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class Pedido2RN {
    private Pedido2DAOListener ped;

    public Pedido2RN() {
        this.ped = FabricaDAO.criarPedido2DAO();
    }
    public void alterar(Pedido2 al){
        this.ped.alterar(al);
    }

    public Pedido2 consultar(int ID){
        return this.ped.consultar(ID);
    }
    
    public void excluir(Pedido2 al){
        this.ped.excluir(al);
    }

    public List<Pedido2> listarSemFiltro(){
        return this.ped.listarSemFiltro();
    }

    public List<Pedido2> obterTodos(){
        return this.ped.obterTodos();
    }

    public void salvar(Pedido2 al){
        this.ped.salvar(al);
    }

    public void setSessao(Session sessao){
        this.ped.setSessao(sessao);
    }
    
}
