/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import RN.PedidosRN;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Iuri Barbosa - PC
 */
@ManagedBean(name = "LevanteMensal")
@SessionScoped
public class LevanteMensal {

    private LineChartModel lineModel1;
    private PedidosRN ped;
    private String dia;
    private String mes;
    private String ano;
    private String nomeMes;
    private String valorTotal;
    private String valorTotalAP;
    private String valorTotalAV;
    private Double valorTotalD;
    private Double valorTotalAPD;
    private Double valorTotalAVD;
    private int qntDias;

    @PostConstruct
    public void init() {
        Calendar cal = GregorianCalendar.getInstance();
        Calendar calendar = Calendar.getInstance();
//        qntDias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        mes = Integer.toString(cal.get(Calendar.MONTH) + 1);
        ano = Integer.toString(cal.get(Calendar.YEAR));
        nomeMes = NomeDoMes(mes);
        qntDiasMes(mes);
        createLineModels();
    }
    public void qntDiasMes(String mes){
        Calendar datas = new GregorianCalendar();
        datas.set(Calendar.MONTH, Integer.parseInt(mes)-1);//2
       qntDias = datas.getActualMaximum (Calendar.DAY_OF_MONTH);
        
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public void createLineModels() {
        lineModel1 = initLinearModel();
        Axis xAxis = lineModel1.getAxis(AxisType.X);
        xAxis.setMin(1);
        xAxis.setMax(qntDias);
        xAxis.setTickCount(qntDias);
        xAxis.setLabel("Dias");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(30000);
        yAxis.setTickCount(13);
        yAxis.setLabel("Reais");
    }
    
    public void mudarMes(){
        nomeMes = NomeDoMes(mes);
        qntDiasMes(mes);
        createLineModels();
        
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        model.setLegendPosition("ne");
        LineChartSeries series1 = new LineChartSeries();
        LineChartSeries series2 = new LineChartSeries();
        LineChartSeries series3 = new LineChartSeries();
        for (int i = 1; i <= qntDias; i++) {
            ped = new PedidosRN();
            dia = Integer.toString(i);
            Double valor = ped.listarPorDia(ano, mes, dia);
            Double valorAP = ped.listarPorDiaAP(ano, mes, dia);
            Double valorAV = ped.listarPorDiaAV(ano, mes, dia);
//            valorTotalD = valorTotalD + valor;
//            valorTotalAPD = valorTotalAPD + valorAP;
//            valorTotalAVD = valorTotalAVD + valorAV;
//            valorTotal = valorTotalD.toString();
//            valorTotalAP = valorTotalAPD.toString();
//            valorTotalAV = valorTotalAVD.toString();
            series1.set(i, valor);
            series2.set(i, valorAV);
            series3.set(i, valorAP);
        }
        series1.setLabel("Total");
        model.setSeriesColors("0000FF,DC143C,7FFF00");
        series2.setLabel("Total AV");
        series3.setLabel("Total AP");
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
        return model;
    }
    
    public static String NomeDoMes(String i) {
    String mes[] = {"Janeiro", "Fevereiro", "Março", "Abril",
      "maio", "junho", "julho", "agosto", "setembro", "outubro",
      "novembro", "dezembro"};
    
       return(mes[Integer.parseInt(i)-1].toUpperCase()); 
     
  }

    public String getNomeMes() {
        return nomeMes;
    }

    public void setNomeMes(String nomeMes) {
        this.nomeMes = nomeMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getValorTotalAP() {
        return valorTotalAP;
    }

    public void setValorTotalAP(String valorTotalAP) {
        this.valorTotalAP = valorTotalAP;
    }

    public String getValorTotalAV() {
        return valorTotalAV;
    }

    public void setValorTotalAV(String valorTotalAV) {
        this.valorTotalAV = valorTotalAV;
    }

}
