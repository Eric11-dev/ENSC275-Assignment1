package com.eric.ensc275;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GUI implements ActionListener {
    /*Initialize the Labels, Fields And Buttons*/
    private static JLabel componentsLable,voltageLable,capacitorLable,inductorLable,resistorLable, runTimeLable,timeStepLable;
    private static JLabel timeLable,fileLable,fileNameLable,filePathLable,plotNameLable;
    private static JLabel voltageError,capacitorError,inductorError,resistorError,timeError;
    private static JLabel voltageRange,capacitorRange,inductorRange,resistorRange;
    private static JTextField voltageField,capacitorField,inductorField,resistorField, runTimeField,timeStepField,fileNameField,filePathField,plotNameField;
    private static JButton submitButton,checkButton,imageButton;

    public static void panel(){
        /*Panel Initialize*/
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("RLC Circuit Discharge Panel");
        frame.setSize(500,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        /*Components Data*/
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

        voltageError = new JLabel("Unverified");
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

        capacitorError = new JLabel("Unverified");
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

        inductorError = new JLabel("Unverified");
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

        resistorError = new JLabel("Unverified");
        resistorError.setBounds(330,140,120,25);
        panel.add(resistorError);
        /*Time Inputs*/
        timeLable = new JLabel("Running Time and time step: ");
        timeLable.setBounds(10,180,180,25);
        panel.add(timeLable);
        /*Running Time Inputs*/
        runTimeLable = new JLabel("Running Time (s)");
        runTimeLable.setBounds(10,210,100,25);
        panel.add(runTimeLable);

        runTimeField = new JTextField(10);
        runTimeField.setBounds(90,210,100,25);
        panel.add(runTimeField);
        /*Time Step Inputs*/
        timeStepLable = new JLabel("Time Step (s)");
        timeStepLable.setBounds(10,240,100,25);
        panel.add(timeStepLable);

        timeStepField = new JTextField(10);
        timeStepField.setBounds(90,240,100,25);
        panel.add(timeStepField);

        timeError = new JLabel("Time Unverified");
        timeError.setBounds(200,240,250,25);
        panel.add(timeError);
        /*Check Validate Button*/
        checkButton = new JButton("Check Validate");
        checkButton.setBounds(10,280,150,25);
        checkButton.addActionListener(new GUI());
        panel.add(checkButton);
        /*File Name And Path*/
        fileLable = new JLabel("Enter file name and file path: ");
        fileLable.setBounds(10,310,200,25);
        panel.add(fileLable);
        /*File Name Inputs*/
        fileNameLable = new JLabel("File name: ");
        fileNameLable.setBounds(10,340,100,25);
        panel.add(fileNameLable);

        fileNameField = new JTextField(10);
        fileNameField.setBounds(90,340,100,25);
        panel.add(fileNameField);
        /*Plot Name Inputs*/
        plotNameLable = new JLabel("Plot name: ");
        plotNameLable.setBounds(10,370,100,25);
        panel.add(plotNameLable);

        plotNameField = new JTextField(10);
        plotNameField.setBounds(90,370,100,25);
        panel.add(plotNameField);
        /*File Path Input*/
        filePathLable = new JLabel("Files path: ");
        filePathLable.setBounds(10,400,100,25);
        panel.add(filePathLable);

        filePathField = new JTextField(100);
        filePathField.setBounds(90,400,100,25);
        panel.add(filePathField);
        /*Data Submit Button*/
        submitButton = new JButton("Submit");
        submitButton.setBounds(10,430,80,25);
        submitButton.addActionListener(new GUI());
        panel.add(submitButton);

        imageButton = new JButton("Image");
        imageButton.setBounds(300,430,80,25);
        imageButton.addActionListener(new GUI());
        panel.add(imageButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Action On The Inputs*/
        /*Initialize Inputs To String Type*/
        String voltageText = voltageField.getText();
        String capacitorText = capacitorField.getText();
        String inductorText = inductorField.getText();
        String resistorText = resistorField.getText();
        String runTimeText = runTimeField.getText();
        String timeStepText = timeStepField.getText();
        String fileNameText = fileNameField.getText();
        String plotNameText = plotNameField.getText();
        String filePathText = filePathField.getText();

        /*Execute The Check Validate Button*/
        if(e.getSource() == checkButton){
            checkValidate(voltageText,capacitorText,inductorText,resistorText,runTimeText,timeStepText);
        }
        /*Execute The Submit Button*/
        if(e.getSource() == submitButton){
            /*Data Validate Check*/
            checkValidate(voltageText,capacitorText,inductorText,resistorText,runTimeText,timeStepText);
            Components components = checkValidate(voltageText,capacitorText,inductorText,resistorText,runTimeText,timeStepText);
            /*Initialize The Value Of q*/
            List<Double> oscillatesValueList = null;
            try {
                /*Calculate The q(t) and Store To a List*/
                oscillatesValueList = components.DischargeCalculation(components.getVoltage(),components.getCapacitor(),
                        components.getInductor(),components.getResistor(),
                        components.getEndTime(),components.getTimeStep(),plotNameText,filePathText);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            /*Write Log file*/
            String filePath = filePathText + fileNameText + ".txt";
            try {
                FileWriter fileWriter = new FileWriter(filePath);
                for(int i =0; i < oscillatesValueList.size();i++){
                    fileWriter.write(String.valueOf(oscillatesValueList.get(i)));
                    fileWriter.write("\r\n");
                }
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if(e.getSource() == imageButton){
            CheckTheImage(plotNameText,filePathText);
        }
    }
    /*Image File Open Method*/
    public void CheckTheImage(String plotName,String filePath){
        JFrame frame = new JFrame("Image");
        frame.setSize(900,800);
        String plotPath = filePath + plotName + ".png";
        ImageIcon icon = new ImageIcon(plotPath);
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.setVisible(true);
    }

    /*Input value validate check method*/
    public Components checkValidate(String voltageText, String capacitorText,String inductorText, String resistorText, String runTimeText, String timeStepText){
        Components components = new Components();
        /*Check Input Data's Validation*/
        if(Double.parseDouble(voltageText) >= 4 && Double.parseDouble(voltageText) <= 15){
            /*Assign The Data To The Components Model*/
            components.setVoltage(Double.parseDouble(voltageText));
            /*Input Data Validated And Show the Validated message*/
            voltageError.setForeground(Color.BLUE);
            voltageError.setText("Value Validated");
        }else {
            /*Input Data Invalidated And Show Error Message*/
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
        return components;
    }
}
