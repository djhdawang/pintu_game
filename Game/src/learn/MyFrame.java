package learn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyFrame extends JFrame implements ActionListener {
    JButton  jbr1 = new JButton("点我");
    JButton  jbr2 = new JButton("点我");
        public  MyFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图v1.0");


        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);

        setLocationRelativeTo(null);
        setLayout(null);

        jbr1.setBounds(0,0,100,50);
//        jbr.addActionListener(new MyActionListener());
        jbr1.addActionListener(this);
        getContentPane().add(jbr1);

        jbr2.setBounds(100,100,100,50);
//        jbr.addActionListener(new MyActionListener());
        jbr2.addActionListener(this);
        getContentPane().add(jbr2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object soure = e.getSource();
        if(soure==jbr1){
            jbr1.setSize(200,200);
        }else{
            Random r =new Random();
            jbr2.setLocation(r.nextInt(500),r.nextInt(500));
        }
    }
}
