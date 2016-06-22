package DAO;

import Mapeamento.Funcionario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class FuncionarioDAO implements FuncionarioDAOListener {
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Funcionario al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Funcionario al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Funcionario al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Funcionario> listarSemFiltro(){
        return this.sessao.createCriteria(Funcionario.class).list();
    }
    
    
    
    @Override
    public Funcionario consultar(int ID){
        return (Funcionario) this.sessao.get(Funcionario.class,ID);
    }
    
    @Override
    public List<Funcionario> buscarFornecedorPorNome(String nome) {
        String hql = "select t from Funcionario t where t.nomefunc like :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nomeA", '%'+nome+'%');
        return (List<Funcionario>) consulta.list();
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
    public List<Funcionario> obterTodos() {
        return this.sessao.createCriteria(Funcionario.class).list();
    }
}
