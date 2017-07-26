/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import RN.PedidosRN;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
     
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Relatorio por Mês");
        Axis xAxis = lineModel1.getAxis(AxisType.X);
        xAxis.setMin(1);
        xAxis.setMax(31);
        xAxis.setTickCount(31);
        xAxis.setLabel("Dias");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(30000);
        yAxis.setTickCount(7);
        yAxis.setLabel("Reais");
    }
     
    private LineChartModel initLinearModel() {
        List<Double> valores = new ArrayList<>();
        LineChartModel model = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        ped = new PedidosRN();
        Calendar cal = GregorianCalendar.getInstance();
        Calendar calendar = Calendar.getInstance();
//        int qntDias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//        String mes = Integer.toString(cal.get(Calendar.MONTH)+1);
//        String ano = Integer.toString(cal.get(Calendar.YEAR));
//        for(int i = 1; i<=qntDias;i++){
//            String dia = Integer.toString(i);
//            Double  valor = ped.listarPorDia(ano,mes,dia);
//            valores.add(valor);
//        }
        
        
//        series1.set(1, valores.get(0));
//        series1.set(2, valores.get(1));
//        series1.set(3, valores.get(2));
//        series1.set(4, valores.get(3));
//        series1.set(5, valores.get(4));
//        series1.set(6, valores.get(5));
//        series1.set(7, valores.get(6));
//        series1.set(8, valores.get(7));
//        series1.set(9, valores.get(8));
        series1.set(10, 8);
        series1.set(11, 8);
        series1.set(12, 8);
        series1.set(13, 8);
        series1.set(14, 8);
        series1.set(15, 8);
        series1.set(16, 8);
        series1.set(17, 10);
        series1.set(18, 8);
        series1.set(19, 8);
        series1.set(20, 10734);
        series1.set(21, 8);
        series1.set(22, 8);
        series1.set(23, 8);
        series1.set(24, 8);
//        series1.set(25, valores.get(24));
        series1.set(26, 8);
        series1.set(27, 8);
        series1.set(28, 8);
        series1.set(29, 8);
        series1.set(30, 8);
        series1.set(31, 5438.60);
        
        model.addSeries(series1);
        
         
        return model;
    }
     
    
 
}
