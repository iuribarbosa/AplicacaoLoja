/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Produto2;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public interface Produto2DAOListener {

    void alterar(Produto2 al);

    List<Produto2> buscarFornecedorPorNome(String nome);

    Produto2 consultar(int ID);

    void excluir(Produto2 al);

    List<Produto2> listarSemFiltro();

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
    List<Produto2> obterTodos();

    void salvar(Produto2 al);

    void setSessao(Session sessao);
    
}
