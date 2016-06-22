/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Cliente;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class ClienteDAO implements ClienteDAOListener {
    private Session sessao;
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    @Override
    public void salvar(Cliente al){
        this.sessao.save(al);
    }
    
    
    @Override
    public void alterar(Cliente al){
        this.sessao.update(al);
    }
    
    
    @Override
    public void excluir(Cliente al){
        this.sessao.delete(al);
    }
    
    
    @Override
    public List<Cliente> listarSemFiltro(){
        return this.sessao.createCriteria(Cliente.class).list();
    }
    
    
    @Override
    public Cliente consultar(int ID){
        return (Cliente) this.sessao.get(Cliente.class,ID);
    }
    @Override
    public List<Cliente> buscarPacientePorNome(String nome) {
        String hql = "select t from Cliente t where t.nome like :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nomeA", '%'+nome+'%');
        return (List<Cliente>) consulta.list();
    }
    
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
    public List<Cliente> obterTodos() {
        return this.sessao.createCriteria(Cliente.class).list();
    }
}
