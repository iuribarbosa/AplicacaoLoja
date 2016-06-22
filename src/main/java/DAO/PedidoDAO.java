package DAO;

import Mapeamento.Item;
import Mapeamento.Pedido;
import java.util.List;
import org.hibernate.Session;

public class PedidoDAO implements PedidoDAOListener {
    
    private Session sessao;
    
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    
    
    @Override
    public void salvar(Pedido al){
        this.sessao.save(al);
    }
    
    
    
    @Override
    public void alterar(Pedido al){
        this.sessao.update(al);
    }
    
    
    
    @Override
    public void excluir(Pedido al){
        this.sessao.delete(al);
    }
    
    
    
    @Override
    public List<Pedido> listarSemFiltro(){
        return this.sessao.createCriteria(Pedido.class).list();
    }
    
    
    
    @Override
    public Pedido consultar(int ID){
        return (Pedido) this.sessao.get(Pedido.class,ID);
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
    public List<Pedido> obterTodos() {
        return this.sessao.createCriteria(Pedido.class).list();
    }
}
