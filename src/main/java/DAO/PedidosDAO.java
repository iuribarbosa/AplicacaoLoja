/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Pedidos;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class PedidosDAO implements PedidosDAOListener{
    private Session sessao;

    
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    
    
    @Override
    public void salvar(Pedidos al){
        this.sessao.save(al);
    }
    
    
    
    
    
    @Override
    public void alterar(Pedidos al){
        this.sessao.update(al);
    }
    
    
    
    
    
    @Override
    public void excluir(Pedidos al){
        this.sessao.delete(al);
    }
    
    
    
    
    
    @Override
    public List<Pedidos> listarSemFiltro(){
        return this.sessao.createCriteria(Pedidos.class).list();
    }
    
    
    
    
    
    @Override
    public Pedidos consultar(int ID){
        return (Pedidos) this.sessao.get(Pedidos.class,ID);
    }
    
//    public List<Pedidos> buscarPacientePorNome(String nome) {
//        String hql = "select t from PedidosDAO t where t.nome like :nomeA";
//        Query consulta = this.sessao.createQuery(hql);
//        consulta.setString("nomeA", '%'+nome+'%');
//        return (List<Pedidos>) consulta.list();
//    }
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
    
    
    
    
    @Override
    public List<Pedidos> obterTodos() {
        return this.sessao.createCriteria(Pedidos.class).list();
    }
    
}
