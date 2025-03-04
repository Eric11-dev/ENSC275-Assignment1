package com.eric.ensc275;

public class Main {
    /**
     * Simple implementation of RLC circuit q(t) oscillates.
     * This application generate log data and simple plot of q(t) in given running time.
     *
     * Click the 'Check Validate' button to check your input value.
     * Click the 'Submit' button to execute the calculation.
     * Click the 'Plot' button to view your latest plot.
     *
     * The Plot class is the source from github author Yuriy Guskov
     *
     * @author: ZhaoQi Huang (Eric)
     * @Student#: 301320726
     * @Sfu mail: zha44@sfu.ca
     *
     */
    public static void main(String[] args) {
	// Execute The GUI
        new GUI();
        GUI.panel();
    }
}
