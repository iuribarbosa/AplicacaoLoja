/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Funcionario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public interface FuncionarioDAOListener {

    void alterar(Funcionario al);

    Funcionario buscarFornecedorPorNome(String login,String senha);

    Funcionario consultar(int ID);

    void excluir(Funcionario al);

    List<Funcionario> listarSemFiltro();

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
    List<Funcionario> obterTodos();

    void salvar(Funcionario al);

    void setSessao(Session sessao);
    
    boolean verificarConexao(String login, String senha);
    
}
