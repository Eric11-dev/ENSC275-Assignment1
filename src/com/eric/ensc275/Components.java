package com.eric.ensc275;

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

    public List<Double> Calculation(double voltageValue, double capacitorValue, double inductorValue, double resistorValue, double endTime, double timeStep){
        double dampingFactor = resistorValue/(2*inductorValue);
        double q;

        List<Double> qlist= new ArrayList<>();

        for(double t = 0; t<= endTime;){
            q = (voltageValue*capacitorValue)*Math.exp(dampingFactor*t*(-1))*
                    Math.cos(t*Math.sqrt((1/(inductorValue*capacitorValue))-Math.pow(dampingFactor,2)));
            System.out.println(q);
            qlist.add(q);
            t = t + timeStep;
        }
        return qlist;
    }
}
