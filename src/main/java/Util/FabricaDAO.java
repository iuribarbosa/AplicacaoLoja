package Util;

import DAO.*;

public class FabricaDAO {

    public static ClienteDAOListener criarClienteDAO() {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return clienteDAO;
    }

    public static FornecedorDAOListener criarFornecedorDAO() {
        FornecedorDAO a = new FornecedorDAO();
        a.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return a;
    }

    public static FuncionarioDAOListener criarFuncionarioDAO() {
        FuncionarioDAO a = new FuncionarioDAO();
        a.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return a;
    }

    public static Item2DAOListener criarItem2DAO() {
        Item2DAO a = new Item2DAO();
        a.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return a;
    }
    
    public static ItemDAOListener criarItemDAO() {
        ItemDAO a = new ItemDAO();
        a.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return a;
    }
    
    public static PedidoDAOListener criarPedidoDAO() {
        PedidoDAO pontAlDAO = new PedidoDAO();
        pontAlDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return pontAlDAO;
    }

    public static Pedido2DAOListener criarPedido2DAO() {
        Pedido2DAO pontProfDAO = new Pedido2DAO();
        pontProfDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return pontProfDAO;
    }

    public static ProdutoDAOListener criarProdutoDAO() {
        ProdutoDAO ProCDAO = new ProdutoDAO();
        ProCDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return ProCDAO;
    }
    
    public static Produto2DAOListener criarProduto2DAO() {
        Produto2DAO ProfDAO = new Produto2DAO();
        ProfDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return ProfDAO;
    }
    public static PedidosDAOListener criarPedidosDAO() {
        PedidosDAO ProfDAO = new PedidosDAO();
        ProfDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return ProfDAO;
    }
}
