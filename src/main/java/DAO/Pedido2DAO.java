/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Pedido;
import Mapeamento.Pedido2;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class Pedido2DAO implements Pedido2DAOListener {
        
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Pedido2 al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Pedido2 al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Pedido2 al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Pedido2> listarSemFiltro(){
        return this.sessao.createCriteria(Pedido2.class).list();
    }
    
    
    
    @Override
    public Pedido2 consultar(int ID){
        return (Pedido2) this.sessao.get(Pedido2.class,ID);
    }
    
//    public List<Item> buscarFornecedorPorNome(String nome) {
//        String hql = "select t from Item t where t.nomefunc like :nomeA";
//        Query consulta = this.sessao.createQuery(hql);
//        consulta.setString("nomeA", '%'+nome+'%');
//        return (List<Item>) consulta.list();
//    }
    
    
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
    
    
    @Override
    public List<Pedido2> obterTodos() {
        return this.sessao.createCriteria(Pedido2.class).list();
    }
}
