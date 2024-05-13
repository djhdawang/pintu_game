package learn;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame3 extends JFrame implements KeyListener {
    public MyFrame3(){
        this.setSize(603, 680);
        this.setTitle("拼图v1.0");


        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);

        setLocationRelativeTo(null);
        setLayout(null);

        JButton jbr1=new JButton();
        jbr1.setBounds(0,0,100,50);
//        jbr.addActionListener(new MyActionListener());
        jbr1.addKeyListener(this);
        getContentPane().add(jbr1);


        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不送");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开");

        int code = e.getKeyCode();
        System.out.println(code);
        if(code==65){
            System.out.println("按的a");
        }
        if(code==66){
            System.out.println("按的b");
        }
    }
}
