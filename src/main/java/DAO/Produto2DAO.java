/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Produto;
import Mapeamento.Produto2;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class Produto2DAO implements Produto2DAOListener {
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Produto2 al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Produto2 al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Produto2 al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Produto2> listarSemFiltro(){
        return this.sessao.createCriteria(Produto2.class).list();
    }
    
    
    
    @Override
    public Produto2 consultar(int ID){
        return (Produto2) this.sessao.get(Produto2.class,ID);
    }
    
    @Override
    public List<Produto2> buscarFornecedorPorNome(String nome) {
        String hql = "select t from Produto2 t where t.nomeprod like :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nomeA", '%'+nome+'%');
        return (List<Produto2>) consulta.list();
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
    public List<Produto2> obterTodos() {
        return this.sessao.createCriteria(Produto2.class).list();
    }
}
