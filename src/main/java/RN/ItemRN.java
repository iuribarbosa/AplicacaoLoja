/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ItemDAOListener;
import Mapeamento.Item;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class ItemRN {
    private ItemDAOListener item;

    public ItemRN() {
        this.item = FabricaDAO.criarItemDAO();
    }
    public void alterar(Item al){
        this.item.alterar(al);
    }

    public Item consultar(int ID){
        return this.item.consultar(ID);
    }
    
    public void excluir(Item al){
        this.item.excluir(al);
    }

    public List<Item> listarSemFiltro(){
        return this.item.listarSemFiltro();
    }

    public List<Item> obterTodos(){
        return this.item.obterTodos();
    }

    public void salvar(Item al){
        this.item.salvar(al);
    }

    public void setSessao(Session sessao){
        this.item.setSessao(sessao);
    }
    
}
