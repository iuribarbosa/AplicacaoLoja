/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Vendas;
import org.hibernate.Session;

public interface VendasDAOListener {

    void salvar(Vendas al);

    void setSessao(Session sessao);
    
}
