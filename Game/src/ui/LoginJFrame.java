package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class LoginJFrame extends JFrame implements ActionListener {
    String path = "C:\\Users\\atom\\IdeaProjects\\Game\\Image\\bg\\bg";
    Random r = new Random();
    int num =r.nextInt(9);
    JTextField jtf1,jtf2,jtf3;
    ArrayList<User> list = new ArrayList<>();
    String user = "123";
    String pass = "123";
    String codes = geCode();
    Button codeAns = new Button(codes);
    Button login = new Button("login");
    public LoginJFrame(){
        String codeUni = geCode();

        this.setSize(488, 430);
        this.setTitle("登陆界面");
        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();

        JLabel bg = new JLabel(new ImageIcon(path+num+"_488x430.jpg"));
        bg.setBounds(0,0,488,430);

        JLabel username = new JLabel("username:");
        username.setBounds(120, 100,200,30);;
        JLabel password = new JLabel("password:");
        JLabel code = new JLabel("code:");
        initCode();


        password.setBounds(120, 150, 200,30);
        code.setBounds(120, 200, 200,30);
        login.setBounds(200, 300, 200,30);
        add(username);
        add(password);
        add(code);
        add(login);
        setLayout(null);

        //设置绝对布局
        jtf1.setBounds(200, 100,200,30);
        jtf2.setBounds(200, 150, 200,30);
        jtf3.setBounds(200, 200, 200,30);

        add(jtf1);
        add(jtf2);
        add(jtf3);



        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);

        add(bg);
        codeAns.addActionListener(this);
        login.addActionListener(this);
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private  void initCode(){
        codes=geCode();
        codeAns.setLabel(codes);
        codeAns.setBounds(200, 250, 200,30);
        add(codeAns);


    }
    private static String geCode(){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        StringBuilder sb = new StringBuilder();
        Random r =new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);

        }
        int num = r.nextInt(10);
        sb.append(num);
        char [] arr=sb.toString().toCharArray();
        int randIndex = r.nextInt(sb.length());
        char temp = arr[randIndex];
        arr[randIndex] = arr[arr.length-1];
        arr[arr.length-1]=temp;
        return new String(arr);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object object=e.getSource();
        if(object==codeAns){
            System.out.println(codes);
            initCode();
        }else if(object==login){
            System.out.println("登录");
            login();
        }
    }

    private void login(){
        String userName = jtf1.getText();
        String password = jtf2.getText();
        String code = jtf3.getText();
        if(userName.length()==0||password.length()==0||code.length()==0){

            JOptionPane.showMessageDialog(this,"账号，密码，验证码没输入");
        }else if(!code.equals(codes)){
            JOptionPane.showMessageDialog(this,"验证码错误");
            initCode();
        }else if(!(userName.equals(user)&&password.equals(pass))){
            JOptionPane.showMessageDialog(this,"账号或者密码错误，请重新输入");
            initCode();
        }else{
            System.out.println("登陆成功");
            this.setVisible(false);
            GameJFame gameJFame = new GameJFame();

        }
    }
}
