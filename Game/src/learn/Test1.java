package learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        jFrame.setTitle("拼图v1.0");


        jFrame.setAlwaysOnTop(true);
        jFrame.setDefaultCloseOperation(3);

        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        JButton  jbr = new JButton("点我");

        jbr.setBounds(0,0,100,50);

//        jbr.addActionListener(new MyActionListener());
        jbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("不要点我");
            }
        });
        jFrame.getContentPane().add(jbr);
        jFrame.setVisible(true);
    }

}
