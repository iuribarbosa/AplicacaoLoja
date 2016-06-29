/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Vendas;
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
    public void salvar(Vendas al){
        this.sessao.save(al);
    }
}
