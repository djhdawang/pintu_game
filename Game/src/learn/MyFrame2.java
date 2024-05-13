package learn;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame2 extends JFrame implements MouseListener {
    public MyFrame2(){
        this.setSize(603, 680);
        this.setTitle("拼图v1.0");


        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);

        setLocationRelativeTo(null);
        setLayout(null);

        JButton jbr1=new JButton();
        jbr1.setBounds(0,0,100,50);
//        jbr.addActionListener(new MyActionListener());
        jbr1.addMouseListener(this);
        getContentPane().add(jbr1);


        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");
    }
}
