package com.eric.ensc275;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI implements ActionListener {

    private static JLabel componentsLable,voltageLable,capacitorLable,inductorLable,resistorLable, runTimeLable,timeStepLable;
    private static JLabel timeLable,fileLable,fileNameLable,filePathLable;
    private static JLabel voltageError,capacitorError,inductorError,resistorError,timeError;
    private static JLabel voltageRange,capacitorRange,inductorRange,resistorRange;
    private static JTextField voltageField,capacitorField,inductorField,resistorField, runTimeField,timeStepField,fileNameField,filePathField;
    private static JButton submitButton,checkButton;

    public static void panel(){
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        /*Components inputs*/
        componentsLable = new JLabel("Components value:");
        componentsLable.setBounds(10,20,150,25);
        panel.add(componentsLable);
        /*Voltage Inputs*/
        voltageLable = new JLabel("Voltage (V)");
        voltageLable.setBounds(10,50,80,25);
        panel.add(voltageLable);

        voltageField = new JTextField(10);
        voltageField.setBounds(90,50,100,25);
        panel.add(voltageField);

        voltageRange = new JLabel("(Range: 4V to 15V)");
        voltageRange.setBounds(200,50,150,25);
        panel.add(voltageRange);

        voltageError = new JLabel("...");
        voltageError.setBounds(330,50,120,25);
        panel.add(voltageError);

        /*Capacitor Inputs*/
        capacitorLable = new JLabel("Capacitor (F)");
        capacitorLable.setBounds(10,80,100,25);
        panel.add(capacitorLable);

        capacitorField = new JTextField(10);
        capacitorField.setBounds(90,80,100,25);
        panel.add(capacitorField);

        capacitorRange = new JLabel("(Range: 1E-9 to 1E-7)");
        capacitorRange.setBounds(200,80,150,25);
        panel.add(capacitorRange);

        capacitorError = new JLabel("...");
        capacitorError.setBounds(330,80,120,25);
        panel.add(capacitorError);

        /*Inductor Inputs*/
        inductorLable = new JLabel("Inductor (H)");
        inductorLable.setBounds(10,110,100,25);
        panel.add(inductorLable);

        inductorField = new JTextField(10);
        inductorField.setBounds(90,110,100,25);
        panel.add(inductorField);

        inductorRange = new JLabel("(Range: 1E-3 to 1E-1)");
        inductorRange.setBounds(200,110,150,25);
        panel.add(inductorRange);

        inductorError = new JLabel("...");
        inductorError.setBounds(330,110,120,25);
        panel.add(inductorError);

        /*Resistor Inputs*/
        resistorLable = new JLabel("Resistor (Ω)");
        resistorLable.setBounds(10,140,100,25);
        panel.add(resistorLable);

        resistorField = new JTextField(10);
        resistorField.setBounds(90,140,100,25);
        panel.add(resistorField);

        resistorRange = new JLabel("(Range: 5Ω to 10Ω)");
        resistorRange.setBounds(200,140,150,25);
        panel.add(resistorRange);

        resistorError = new JLabel("...");
        resistorError.setBounds(330,140,120,25);
        panel.add(resistorError);
        /*Time inputs*/
        timeLable = new JLabel("Running Time and time step: ");
        timeLable.setBounds(10,180,180,25);
        panel.add(timeLable);
        /*Running time inputs*/
        runTimeLable = new JLabel("End Time (s)");
        runTimeLable.setBounds(10,210,100,25);
        panel.add(runTimeLable);

        runTimeField = new JTextField(10);
        runTimeField.setBounds(90,210,100,25);
        panel.add(runTimeField);
        /*Time step inputs*/
        timeStepLable = new JLabel("Tiem Step (s)");
        timeStepLable.setBounds(10,240,100,25);
        panel.add(timeStepLable);

        timeStepField = new JTextField(10);
        timeStepField.setBounds(90,240,100,25);
        panel.add(timeStepField);

        timeError = new JLabel("...");
        timeError.setBounds(200,240,250,25);
        panel.add(timeError);
        /*Check Validate button*/
        checkButton = new JButton("Check validate");
        checkButton.setBounds(10,280,150,25);
        checkButton.addActionListener(new GUI());
        panel.add(checkButton);
        /*File name and path*/
        fileLable = new JLabel("Enter file name and file path: ");
        fileLable.setBounds(10,310,200,25);
        panel.add(fileLable);
        /*File name inputs*/
        fileNameLable = new JLabel("File name: ");
        fileNameLable.setBounds(10,340,100,25);
        panel.add(fileNameLable);

        fileNameField = new JTextField(10);
        fileNameField.setBounds(90,340,100,25);
        panel.add(fileNameField);
        /*File path input*/
        filePathLable = new JLabel("File path: ");
        filePathLable.setBounds(10,370,100,25);
        panel.add(filePathLable);

        filePathField = new JTextField(100);
        filePathField.setBounds(90,370,100,25);
        panel.add(filePathField);


        submitButton = new JButton("Submit");
        submitButton.setBounds(10,400,80,25);
        submitButton.addActionListener(new GUI());
        panel.add(submitButton);


        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("button clicked");
        String voltageText = voltageField.getText();
        String capacitorText = capacitorField.getText();
        String inductorText = inductorField.getText();
        String resistorText = resistorField.getText();
        String runTimeText = runTimeField.getText();
        String timeStepText = timeStepField.getText();

        Components components = new Components();


        if(e.getSource() == checkButton){
            System.out.println("check button clicked");
            checkValidate(voltageText,capacitorText,inductorText,resistorText,runTimeText,timeStepText);
        }

        if(e.getSource() == submitButton){
            /*System.out.println("submit button clicked");*/
            List<Double> oscillatesValueList = components.Calculation(components.getVoltage(),components.getCapacitor(),components.getInductor(),components.getResistor(),
                    components.getEndTime(),components.getTimeStep());

            System.out.println(oscillatesValueList);
        }

    }


    public void checkValidate(String voltageText, String capacitorText,String inductorText, String resistorText, String runTimeText, String timeStepText){
        Components components = new Components();
        if(Double.parseDouble(voltageText) >= 4 && Double.parseDouble(voltageText) <= 15){
            components.setVoltage(Double.parseDouble(voltageText));
            voltageError.setForeground(Color.BLUE);
            voltageError.setText("Value Validated");
        }else {
            voltageError.setForeground(Color.RED);
            voltageError.setText("Value out of range.");
        }
        if(Double.parseDouble(capacitorText) >= 1E-9 && Double.parseDouble(capacitorText) <= 1E-7){
            components.setCapacitor(Double.parseDouble(capacitorText));
            capacitorError.setForeground(Color.BLUE);
            capacitorError.setText("Value Validated");
        }else {
            capacitorError.setForeground(Color.RED);
            capacitorError.setText("Value out of range.");
        }
        if(Double.parseDouble(inductorText) >= 1E-3 && Double.parseDouble(inductorText) <= 1E-1){
            components.setInductor(Double.parseDouble(inductorText));
            inductorError.setForeground(Color.BLUE);
            inductorError.setText("Value Validated");
        }else {
            inductorError.setForeground(Color.RED);
            inductorError.setText("Value out of range.");
        }
        if(Double.parseDouble(resistorText) >= 5 && Double.parseDouble(resistorText) <= 10){
            components.setResistor(Double.parseDouble(resistorText));
            resistorError.setForeground(Color.BLUE);
            resistorError.setText("Value Validated");
        }else {
            resistorError.setForeground(Color.RED);
            resistorError.setText("Value out of range.");
        }

        if(Double.parseDouble(timeStepText) <= Double.parseDouble(runTimeText)){
            components.setEndTime(Double.parseDouble(runTimeText));
            components.setTimeStep(Double.parseDouble(timeStepText));
            timeError.setForeground(Color.BLUE);
            timeError.setText("Value Validated");
        }else {
            timeError.setForeground(Color.RED);
            timeError.setText("Time step must less than Running time");
        }
    }


}
