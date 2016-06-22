
package DAO;

import Mapeamento.Item;
import Mapeamento.Item2;
import java.util.List;
import org.hibernate.Session;

public class Item2DAO implements Item2DAOListener {
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Item2 al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Item2 al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Item2 al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Item2> listarSemFiltro(){
        return this.sessao.createCriteria(Item2.class).list();
    }
    
    
    
    @Override
    public Item2 consultar(int ID){
        return (Item2) this.sessao.get(Item2.class,ID);
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
    public List<Item2> obterTodos() {
        return this.sessao.createCriteria(Item2.class).list();
    }
}
