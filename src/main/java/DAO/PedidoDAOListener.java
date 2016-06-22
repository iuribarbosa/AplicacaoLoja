/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Pedido;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public interface PedidoDAOListener {

    void alterar(Pedido al);

    Pedido consultar(int ID);
    //    public List<Item> buscarFornecedorPorNome(String nome) {
    //        String hql = "select t from Item t where t.nomefunc like :nomeA";
    //        Query consulta = this.sessao.createQuery(hql);
    //        consulta.setString("nomeA", '%'+nome+'%');
    //        return (List<Item>) consulta.list();
    //    }

    void excluir(Pedido al);

    List<Pedido> listarSemFiltro();

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
    List<Pedido> obterTodos();

    void salvar(Pedido al);

    void setSessao(Session sessao);
    
}
