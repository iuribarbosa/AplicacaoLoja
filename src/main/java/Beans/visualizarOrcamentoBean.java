package Beans;

import Mapeamento.Pedido2;
import RN.Pedido2RN;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "viewOrcamento")
@SessionScoped
public class visualizarOrcamentoBean {
    Pedido2RN orcamentoRN;
    private Pedido2 orcamento;
    
}
