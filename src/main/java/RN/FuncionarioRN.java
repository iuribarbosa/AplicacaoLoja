/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.FuncionarioDAOListener;
import Mapeamento.Funcionario;
import Util.FabricaDAO;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class FuncionarioRN {
    private FuncionarioDAOListener func;

    public FuncionarioRN() {
        this.func = FabricaDAO.criarFuncionarioDAO();
    }
    
    public void alterar(Funcionario al){
        this.func.alterar(al);
    }

    public Funcionario buscarFornecedorPorNome(String login,String senha){
        return this.func.buscarFornecedorPorNome(login, senha);
    }

   public  Funcionario consultar(int ID){
       return this.func.consultar(ID);
   }

    public void excluir(Funcionario al){
        this.func.excluir(al);
    }

    public List<Funcionario> listarSemFiltro(){
        return this.func.listarSemFiltro();
    }

    //    public List<Fornecedor> buscarAlunoporcpf(String cpf) {
    //        String hql = "select t from TbAluno t where t.aluPesIdpessoa.pesCpf = :cpfA";
    //        Query consulta = this.sessao.createQuery(hql);
    //        consulta.setString("cpfA", cpf);
    //        return (List<TbAluno>) consulta.list();
    //    }
    //    public TbAluno buscarAlunoporMat(String matricula) {
    //        String hql = "select t from TbAluno t where t.aluMatricula = :matA";
    //        Query consulta = this.sessao.createQuery(hql);
    //        consulta.setString("matA", matricula);
    //        return (TbAluno) consulta.uniqueResult();
    //    }
    public List<Funcionario> obterTodos(){
        return this.func.obterTodos();
    }

    public void salvar(Funcionario al){
        this.func.salvar(al);
    }

    public void setSessao(Session sessao){
        this.func.setSessao(sessao);
    }
    public boolean verificarConexao(String login, String senha){
       return this.func.verificarConexao(login, senha);
    }
}
