package com.web;

import org.primefaces.model.chart.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Component
@Scope("request")
public class ChartController implements Serializable {

    private LineChartModel areaModel;

    public LineChartModel getAreaModel() {
        if (areaModel == null) {
            createAreaModel();
        }
        return areaModel;
    }

    private void createAreaModel() {
        FacesContext.getCurrentInstance().getViewRoot().getViewMap().put("now", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        areaModel = new LineChartModel();

        LineChartSeries s1 = new LineChartSeries();
//        boys.setFill(true);
        s1.setLabel("2014");
        s1.set("20/1", new Random().nextInt(300));
        s1.set("21/1", new Random().nextInt(300));
        s1.set("22/1", new Random().nextInt(300));
        s1.set("23/1", new Random().nextInt(300));
        s1.set("24/1", new Random().nextInt(300));

        LineChartSeries s2 = new LineChartSeries();
        //      girls.setFill(true);
        s2.setLabel("2015");
        s2.set("20/1", new Random().nextInt(300));
        s2.set("21/1", new Random().nextInt(300));
        s2.set("22/1", new Random().nextInt(300));
        s2.set("23/1", new Random().nextInt(300));
        s2.set("24/1", new Random().nextInt(300));

        areaModel.addSeries(s1);
        areaModel.addSeries(s2);

        areaModel.setTitle("Antal sålda däck");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        Axis xAxis = new CategoryAxis("Datum");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Antal");
        yAxis.setMin(0);
        yAxis.setMax(800);
    }

    public void newChart() {
        createAreaModel();
    }
}
