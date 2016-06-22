/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Item2;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public interface Item2DAOListener {

    void alterar(Item2 al);

    Item2 consultar(int ID);
    //    public List<Item> buscarFornecedorPorNome(String nome) {
    //        String hql = "select t from Item t where t.nomefunc like :nomeA";
    //        Query consulta = this.sessao.createQuery(hql);
    //        consulta.setString("nomeA", '%'+nome+'%');
    //        return (List<Item>) consulta.list();
    //    }

    void excluir(Item2 al);

    List<Item2> listarSemFiltro();

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
    List<Item2> obterTodos();

    void salvar(Item2 al);

    void setSessao(Session sessao);
    
}
