/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Vendas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ibarbosa
 */
public class VendasDAO implements VendasDAOListener {

    private Session sessao;

    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    @Override
    public void salvar(Vendas al) {
        this.sessao.save(al);
    }

    @Override
    public List<Vendas> buscarFornecedorPorNome(int id) {
        String hql = "select t from Vendas t where t.iDPedido = :id";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setInteger("id",id);
        return (List<Vendas>) consulta.list();
    }
}
