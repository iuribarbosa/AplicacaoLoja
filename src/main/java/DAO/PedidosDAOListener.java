/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Pedidos;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public interface PedidosDAOListener {

    void alterar(Pedidos al);

    Pedidos consultar(int ID);
    
    Pedidos consultarListaID(int id, int tipo);

    void excluir(Pedidos al);

    List<Pedidos> listarSemFiltro();
    
    List<Pedidos> listarComFiltro(int id);
    
    List<Pedidos> listarComFiltroEData(int id, Date data);

    List<Pedidos> obterTodos();

    void salvar(Pedidos al);

    void setSessao(Session sessao);
    
    Pedidos buscarData(Date data);
    
    double listarPorMês(String ano, String mes, String dia);
    double listarPorAno(String ano);
    double listarPorMêsAV(String ano, String mes);
    double listarPorMêsAP(String ano, String mes);
    double listarPorMêsTotal(String ano, String mes);
    
    double listarPorDia(String ano, String mes, String dia);
    double listarPorDiaAP(String ano, String mes, String dia);
    double listarPorDiaAV(String ano, String mes, String dia);
    
}
