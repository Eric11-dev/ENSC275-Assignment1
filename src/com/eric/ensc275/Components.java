package com.eric.ensc275;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Components {
    private double voltage;
    private double capacitor;
    private double inductor;
    private double resistor;
    private double endTime;
    private double timeStep;

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(double timeStep) {
        this.timeStep = timeStep;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCapacitor() {
        return capacitor;
    }

    public void setCapacitor(double capacitor) {
        this.capacitor = capacitor;
    }

    public double getInductor() {
        return inductor;
    }

    public void setInductor(double inductor) {
        this.inductor = inductor;
    }

    public double getResistor() {
        return resistor;
    }

    public void setResistor(double resistor) {
        this.resistor = resistor;
    }

    public List<Double> DischargeCalculation(double voltageValue, double capacitorValue, double inductorValue, double resistorValue, double endTime, double timeStep) throws IOException {

        double dampingFactor = resistorValue/(2*inductorValue);
        double q;
        /*Initialize qList And timeList*/
        List<Double> qlist= new ArrayList<>();
        List<Double> timeList = new ArrayList<>();
        /*Calculation Process*/
        for(double t = 0; t<= endTime;){
            q = (voltageValue*capacitorValue)*Math.exp(dampingFactor*t*(-1))*
                    Math.cos(t*Math.sqrt((1/(inductorValue*capacitorValue))-Math.pow(dampingFactor,2)));
            qlist.add(q);
            timeList.add(t);
            t = t + timeStep;
        }
        /*Implement Plot Method*/
        plot(qlist,timeList,endTime);
        return qlist;
    }
    /*Plot Method*/
    public static void plot(List<Double> q, List<Double> time, double endTime) throws IOException {
        Plot plot = Plot.plot(Plot.plotOpts().
                title("Capacitor Charge vs Time").
                legend(Plot.LegendFormat.RIGHT)).
                        xAxis("t(sec)", Plot.axisOpts().
                         // x Axis Range
                        range(0, endTime)).
                        // y Axis Range
                        yAxis("q(t)", Plot.axisOpts().
                                range(q.get(0)*(-1), q.get(0))).
                        // Configuring Data Series
                        series("Data", Plot.data().xy(time, q),
                        Plot.seriesOpts().color(Color.black));
        plot.save("Plot_output", "png");
    }
}
