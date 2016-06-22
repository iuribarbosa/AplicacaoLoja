/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.FornecedorDAOListener;
import Mapeamento.Fornecedor;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class FornecedorRN {
    private FornecedorDAOListener forn;
    public FornecedorRN() {
        this.forn = FabricaDAO.criarFornecedorDAO();
    }
    
    public void alterar(Fornecedor al){
        this.forn.alterar(al);
    }

    public List<Fornecedor> buscarFornecedorPorNome(String nome){
        return this.forn.buscarFornecedorPorNome(nome);
    }

    public Fornecedor consultar(int ID){
        return this.forn.consultar(ID);
    }

    public void excluir(Fornecedor al){
        this.forn.excluir(al);
    }

    public List<Fornecedor> listarSemFiltro(){
        return this.forn.listarSemFiltro();
    }

    public List<Fornecedor> obterTodos(){
        return this.forn.obterTodos();
    }

    public void salvar(Fornecedor al){
        this.forn.salvar(al);
    }

    public void setSessao(Session sessao){
        this.forn.setSessao(sessao);
    }
}
