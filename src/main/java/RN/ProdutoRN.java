/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ProdutoDAOListener;
import Mapeamento.Produto;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class ProdutoRN {
    private ProdutoDAOListener prod;

    public ProdutoRN() {
        this.prod = FabricaDAO.criarProdutoDAO();
    }
    public void alterar(Produto al){
        this.prod.alterar(al);
    }

    public List<Produto> buscarFornecedorPorNome(String nome){
        return this.prod.buscarFornecedorPorNome(nome);
    }

    public Produto consultar(int ID){
        return this.prod.consultar(ID);
    }

    public void excluir(Produto al){
        this.prod.excluir(al);
    }

    public List<Produto> listarSemFiltro(){
        return this.prod.listarSemFiltro();
    }

    public List<Produto> obterTodos(){
        return this.prod.obterTodos();
    }

    public void salvar(Produto al){
        this.prod.salvar(al);
    }

    public void setSessao(Session sessao){
        this.prod.setSessao(sessao);
    }
    
}
