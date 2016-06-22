/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.ClienteDAOListener;
import Mapeamento.Cliente;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class ClienteRN {
    private ClienteDAOListener cli;

    public ClienteRN() {
        this.cli = FabricaDAO.criarClienteDAO();
    }
    
    public void alterar(Cliente al){
        this.cli.alterar(al);
    }

    public List<Cliente> buscarPacientePorNome(String nome){
        return this.cli.buscarPacientePorNome(nome);
    }

    public Cliente consultar(int ID){
        return this.cli.consultar(ID);
    }

    public void excluir(Cliente al){
        this.cli.excluir(al);
    }

    public List<Cliente> listarSemFiltro(){
        return this.cli.listarSemFiltro();
    }

    public List<Cliente> obterTodos(){
        return this.cli.obterTodos();
    }

    public void salvar(Cliente al){
        this.cli.salvar(al);
    }

    public void setSessao(Session sessao){
        this.cli.setSessao(sessao);
    }
}
