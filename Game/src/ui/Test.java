package ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
       jFrame.setTitle("拼图v1.0");


        jFrame.setAlwaysOnTop(true);
        jFrame.setDefaultCloseOperation(3);

        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        JButton  jbr = new JButton("点我");

        jbr.setBounds(0,0,100,0);
    }
}
