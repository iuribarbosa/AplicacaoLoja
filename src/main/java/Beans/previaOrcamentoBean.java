package Beans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "previaOrcamento")
@SessionScoped
public class previaOrcamentoBean {

    //Variaveis da Tela
    public int formaPag = 1;
    public int parcelas;
    public double Desconto;
    public double total = 1000;
    public String totalString;
    public double totalDesconto = 0;
    public String totalDescontoString;
    public double valorParcelas;
    public String valorParcelasString;

    //Variaveis de Controle
    public boolean cntParcelas;

    public previaOrcamentoBean() {
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN);
        totalString = "R$ " + bd;
    }

    //Funções
    //Funções de valores
    public void gerarValorDesconto() {
        totalDesconto = total - (total * (Desconto / 100));
        BigDecimal bd = new BigDecimal(totalDesconto).setScale(2, RoundingMode.HALF_EVEN);
        totalDescontoString = "R$ " + bd;
    }

    public void gerarValorParcelas() {
        valorParcelas = total / parcelas;
        BigDecimal bd = new BigDecimal(valorParcelas).setScale(2, RoundingMode.HALF_EVEN);
        valorParcelasString = "R$ " + bd;
    }

    //Funções de Controles
    public void verificarFormaPag() {
        int i = formaPag;
        if (i == 1) {
            cntParcelas = false;
        } else {
            cntParcelas = true;
        }
    }

    //Gets e Sets
    //Variaveis da Tela
    public int getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(int formaPag) {
        this.formaPag = formaPag;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public String getTotalString() {
        return totalString;
    }

    public void setTotalString(String totalString) {
        this.totalString = totalString;
    }

    public String getTotalDescontoString() {
        return totalDescontoString;
    }

    public void setTotalDescontoString(String totalDescontoString) {
        this.totalDescontoString = totalDescontoString;
    }

    public String getValorParcelasString() {
        return valorParcelasString;
    }

    public void setValorParcelasString(String valorParcelasString) {
        this.valorParcelasString = valorParcelasString;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(double totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public double getDesconto() {
        return Desconto;
    }

    public void setDesconto(double Desconto) {
        this.Desconto = Desconto;
    }

    //Variaveis de Controle
    public boolean isCntParcelas() {
        return cntParcelas;
    }

    public void setCntParcelas(boolean cntParcelas) {
        this.cntParcelas = cntParcelas;
    }

}
