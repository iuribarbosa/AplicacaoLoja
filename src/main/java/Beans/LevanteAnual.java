/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Mapeamento.ListaAnos;
import RN.PedidosRN;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author ibarbosa
 */
@ManagedBean(name = "LevanteAnual")
@SessionScoped
public class LevanteAnual {
    
    
    private LineChartModel lineModel1;
    private PedidosRN ped;
    private String ano;
    private Integer anoInt;
    private String valorTotal;
    private String valorTotalAP;
    private String valorTotalAV;
    private Double valorTotalD;
    private Double valorTotalAPD;
    private Double valorTotalAVD;
    private Double maiorValor;
    private String mes;
    private List<ListaAnos> listaAnos;
    private List<ListaAnos> listaAnos2;
    private ListaAnos objAno;
    private ListaAnos objAnoSelecionado;

    
    @PostConstruct
    public void init() {
        Calendar cal = GregorianCalendar.getInstance();
        ano = Integer.toString(cal.get(Calendar.YEAR));
        anoInt = cal.get(Calendar.YEAR);
        getListaAnos();
        iniciarAno();
        createLineModels();
    }
    
    public void mudarAno(){
        createLineModels();
        getListaAnos();
    }
    public void iniciarAno(){
        for(int i = 0; i<= (listaAnos2.size()-1);i++){
            if(anoInt == listaAnos2.get(i).getAno()){
               objAnoSelecionado = listaAnos2.get(i);
            }
        }     
    }
    public void createLineModels() {
        lineModel1 = initLinearModel();
        Axis xAxis = lineModel1.getAxis(AxisType.X);
        xAxis.setMin(1);
        xAxis.setMax(12);
        xAxis.setTickCount(12);
        xAxis.setLabel("Meses");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        int qntQuadros = (int)(maiorValor/2000)+1;
        yAxis.setMin(0);
        yAxis.setMax(qntQuadros * 2000);
        yAxis.setTickCount(qntQuadros + 1);
        yAxis.setLabel("Reais");
    }
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
        model.setLegendPosition("ne");
        LineChartSeries series1 = new LineChartSeries();
        LineChartSeries series2 = new LineChartSeries();
        LineChartSeries series3 = new LineChartSeries();
        valorTotalD = 0.0;
        valorTotalAPD = 0.0;
        valorTotalAVD = 0.0;
        maiorValor = 0.0;
        for (int i = 1; i <= 12; i++) {
            ped = new PedidosRN();
            //Lugar onde configura o ano
            Double valor = ped.listarPorMêsTotal(Integer.toString(objAnoSelecionado.getAno()),Integer.toString(i));
            Double valorAP = ped.listarPorMêsAP(Integer.toString(objAnoSelecionado.getAno()),Integer.toString(i));
            Double valorAV = ped.listarPorMêsAV(Integer.toString(objAnoSelecionado.getAno()),Integer.toString(i));
            if(maiorValor<valor){
                maiorValor = valor;
            }
            valorTotalD = valorTotalD + valor;
            valorTotalAPD = valorTotalAPD + valorAP;
            valorTotalAVD = valorTotalAVD + valorAV;
            valorTotalAVD = Double.valueOf(String.format(Locale.US, "%.2f", valorTotalAVD));
            valorTotalD = Double.valueOf(String.format(Locale.US, "%.2f", valorTotalD));
            valorTotalAPD = Double.valueOf(String.format(Locale.US, "%.2f", valorTotalAPD));
            valorTotal = valorTotalD.toString();
            valorTotalAP = valorTotalAPD.toString();
            valorTotalAV = valorTotalAVD.toString();
            
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
    
    
    
    public void getListaAnos(){
            Integer anoInicial = 2015;
		Calendar dataFinal=Calendar.getInstance();
		Integer anoAtual = dataFinal.get(Calendar.YEAR);
		listaAnos2=new ArrayList<ListaAnos>();
		for(Integer ano=anoInicial; ano<=anoAtual;ano++){
                        objAno = new ListaAnos();
                        objAno.setAno(ano);
			listaAnos2.add(objAno);
		}
	}

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    public Integer getAnoInt() {
        return anoInt;
    }

    public void setAnoInt(Integer anoInt) {
        this.anoInt = anoInt;
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }

    public ListaAnos getObjAnoSelecionado() {
        return objAnoSelecionado;
    }

    public void setObjAnoSelecionado(ListaAnos objAnoSelecionado) {
        this.objAnoSelecionado = objAnoSelecionado;
    }

    public List<ListaAnos> getListaAnos2() {
        return listaAnos2;
    }

    public void setListaAnos2(List<ListaAnos> listaAnos2) {
        this.listaAnos2 = listaAnos2;
    }

    public void setListaAnos(List<ListaAnos> listaAnos) {
        this.listaAnos = listaAnos;
    }
    
    
    
}
