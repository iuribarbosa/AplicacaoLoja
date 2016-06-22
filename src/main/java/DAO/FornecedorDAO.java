/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Fornecedor;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class FornecedorDAO implements FornecedorDAOListener {
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Fornecedor al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Fornecedor al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Fornecedor al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Fornecedor> listarSemFiltro(){
        return this.sessao.createCriteria(Fornecedor.class).list();
    }
    
    
    
    @Override
    public Fornecedor consultar(int ID){
        return (Fornecedor) this.sessao.get(Fornecedor.class,ID);
    }
    
    @Override
    public List<Fornecedor> buscarFornecedorPorNome(String nome) {
        String hql = "select t from Fornecedor t where t.nomeforn like :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nomeA", '%'+nome+'%');
        return (List<Fornecedor>) consulta.list();
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
    
    
    @Override
    public List<Fornecedor> obterTodos() {
        return this.sessao.createCriteria(Fornecedor.class).list();
    }
}
