/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Pedidos;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public interface PedidosDAOListener {

    void alterar(Pedidos al);

    Pedidos consultar(int ID);
    
    Pedidos consultarListaID(int id, int tipo);
    //
    //    public List<TbAluno> buscarAlunoporcpf(String cpf) {
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

    void excluir(Pedidos al);

    List<Pedidos> listarSemFiltro();
    
    List<Pedidos> listarComFiltro(int id);

    List<Pedidos> obterTodos();

    void salvar(Pedidos al);

    void setSessao(Session sessao);
    
    Pedidos buscarData(Date data);
    
}
