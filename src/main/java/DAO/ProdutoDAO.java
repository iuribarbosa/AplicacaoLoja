package DAO;

import Mapeamento.Funcionario;
import Mapeamento.Produto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProdutoDAO implements ProdutoDAOListener {
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Produto al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Produto al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Produto al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Produto> listarSemFiltro(){
        return this.sessao.createCriteria(Produto.class).list();
    }
    
    
    
    @Override
    public Produto consultar(int ID){
        return (Produto) this.sessao.get(Produto.class,ID);
    }
    
    @Override
    public List<Produto> buscarFornecedorPorNome(String nome) {
        String hql = "select t from Produto t where t.nomeprod like :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nomeA", '%'+nome+'%');
        return (List<Produto>) consulta.list();
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
    public List<Produto> obterTodos() {
        return this.sessao.createCriteria(Produto.class).list();
    }
}
