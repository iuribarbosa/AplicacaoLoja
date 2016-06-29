package Beans;

import Mapeamento.Pedidos;
import RN.PedidosRN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "viewOrcamento")
@SessionScoped
public class visualizarOrcamentoBean {
    
    //Variaveis de Mapeamento
    private Pedidos orcamento;
    private PedidosRN orcaRN;
    
}
