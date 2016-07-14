/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import Beans.AlterarProdutoBean;
import Mapeamento.Produto;
import RN.ProdutoRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter ("ProdutoConverter")
public class ProdutoConverter implements Converter{
    
    private ProdutoRN prodRn;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Produto retorno = null;
        prodRn = new ProdutoRN();
        
        if(value != null){
            Integer id = new Integer(value);
            retorno = prodRn.consultar(id);
        }
        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        if (value == null || value.equals("")) {
//            return "";
//        } else {
//            return ((Produto) value).getCodprod().toString();
//        }
        if(value != null){
            Integer codigo = ((Produto) value).getCodprod();
            String retorno = (codigo == null ? null : codigo.toString());
            return retorno;
        }
        return "";
    }

    
}
