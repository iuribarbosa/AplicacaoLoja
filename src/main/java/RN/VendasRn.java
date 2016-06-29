/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import DAO.VendasDAOListener;
import Mapeamento.Vendas;
import Util.FabricaDAO;

public class VendasRn {
    private VendasDAOListener vend;

    public VendasRn() {
        this.vend = FabricaDAO.criarVendasDAO();
    }
    
    public void salvar(Vendas al){
        this.vend.salvar(al);
    }

    
    
}
