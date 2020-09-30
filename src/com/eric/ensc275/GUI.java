package com.eric.ensc275;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI implements ActionListener {

    private static JLabel voltageLable,capacitorLable,inductorLable,resistorLable,endTimeLable,timeStepLable;
    private static JTextField voltageField,capacitorField,inductorField,resistorField,endTimeField,timeStepField;
    private static JButton button;

    public static void panel(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        voltageLable = new JLabel("Voltage");
        voltageLable.setBounds(10,20,80,25);
        panel.add(voltageLable);

        voltageField = new JTextField(10);
        voltageField.setBounds(80,20,100,25);
        panel.add(voltageField);

        capacitorLable = new JLabel("Capacitor");
        capacitorLable.setBounds(10,50,100,25);
        panel.add(capacitorLable);

        capacitorField = new JTextField(10);
        capacitorField.setBounds(80,50,100,25);
        panel.add(capacitorField);

        inductorLable = new JLabel("Inductor");
        inductorLable.setBounds(10,80,100,25);
        panel.add(inductorLable);

        inductorField = new JTextField(10);
        inductorField.setBounds(80,80,100,25);
        panel.add(inductorField);

        resistorLable = new JLabel("Resistor");
        resistorLable.setBounds(10,110,100,25);
        panel.add(resistorLable);

        resistorField = new JTextField(10);
        resistorField.setBounds(80,110,100,25);
        panel.add(resistorField);

        endTimeLable = new JLabel("End Time");
        endTimeLable.setBounds(10,200,100,25);
        panel.add(endTimeLable);

        endTimeField = new JTextField(10);
        endTimeField.setBounds(80,200,100,25);
        panel.add(endTimeField);

        timeStepLable = new JLabel("Tiem Step");
        timeStepLable.setBounds(10,230,100,25);
        panel.add(timeStepLable);

        timeStepField = new JTextField(10);
        timeStepField.setBounds(80,230,100,25);
        panel.add(timeStepField);

        button = new JButton("Submit");
        button.setBounds(10,260,80,25);
        button.addActionListener(new GUI());
        panel.add(button);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("button clicked");
        String voltageText = voltageField.getText();
        String capacitorText = capacitorField.getText();
        String inductorText = inductorField.getText();
        String resistorText = resistorField.getText();
        String endTimeText = endTimeField.getText();
        String timeStepText = timeStepField.getText();

        Components components = new Components();

        if(Double.parseDouble(voltageText) >= 4 ||  Double.parseDouble(voltageText) <= 15){
            components.setVoltage(Double.parseDouble(voltageText));
        }
        if(Double.parseDouble(capacitorText) >= 1E-9 ||  Double.parseDouble(capacitorText) <= 1E-7){
            components.setCapacitor(Double.parseDouble(capacitorText));
        }
        if(Double.parseDouble(inductorText) >= 1E-3 ||  Double.parseDouble(inductorText) <= 1E-1){
            components.setInductor(Double.parseDouble(inductorText));
        }
        if(Double.parseDouble(resistorText) >= 5 ||  Double.parseDouble(resistorText) <= 10){
            components.setResistor(Double.parseDouble(resistorText));
        }
        if(Double.parseDouble(timeStepText) <= Double.parseDouble(endTimeText)){
            components.setEndTime(Double.parseDouble(endTimeText));
            components.setTimeStep(Double.parseDouble(timeStepText));
        }


        List<Double> oscillatesValueList = components.Calculation(components.getVoltage(),components.getCapacitor(),components.getInductor(),components.getResistor(),
                components.getEndTime(),components.getTimeStep());

        System.out.println(oscillatesValueList);

    }


}
