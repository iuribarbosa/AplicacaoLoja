
package DAO;

import Mapeamento.Item;
import java.util.List;
import org.hibernate.Session;


public class ItemDAO implements ItemDAOListener {
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Item al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Item al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Item al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Item> listarSemFiltro(){
        return this.sessao.createCriteria(Item.class).list();
    }
    
    
    
    @Override
    public Item consultar(int ID){
        return (Item) this.sessao.get(Item.class,ID);
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
    public List<Item> obterTodos() {
        return this.sessao.createCriteria(Item.class).list();
    }
}
