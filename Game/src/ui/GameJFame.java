package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFame extends JFrame implements KeyListener, ActionListener {
        Random random1 = new Random();
        int[][] data = new int[4][4];
        int x=0;
        int y=0;

        int count = 0;//加载步数
        int [][]win=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        String path ="C:\\Users\\atom\\IdeaProjects\\Game\\Image\\";
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("退出");
    JMenu choose = new JMenu("更换图片");
    JMenuItem animal = new JMenuItem("动物");
    JMenuItem girl = new JMenuItem("美女");
    JMenuItem cartoon = new JMenuItem("二次元");

    JMenuItem accountItem = new JMenuItem("公众号");
    public GameJFame() {
        Init();

        initJMenuBar();

        initDate();
        initImage();
        this.setVisible(true);
    }

    private void initDate() {
        int[] tempArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp=tempArr[index];
            tempArr[index] = tempArr[i];
            tempArr[i]=temp;
        }



        for (int i = 0; i < tempArr.length; i++) {
            if(tempArr[i]==16){
                x=i/4;
                y=i%4;
            }
            data[i/4][i%4]=tempArr[i];
        }

    }

    private void initImage(){
        this.getContentPane().removeAll();

        if(victory()){
            JLabel winJLabel = new JLabel(new ImageIcon("C:\\Users\\atom\\IdeaProjects\\Game\\Image\\win_300x287.jpg"));
            winJLabel.setBounds(160,200,300,287);
            this.getContentPane().add(winJLabel);
        }

        JLabel setCount  = new JLabel("步数"+count);
        setCount.setBounds(0,0,100,20);
        this.getContentPane().add(setCount);
        ImageIcon bg = new ImageIcon(path+"17.jpg");



        //加jlabel
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
                jLabel.setBounds(150*j,170*i,150,170);
                jLabel.setBorder(new BevelBorder(1));
                this.getContentPane().add(jLabel);

            }
        }



        this.getContentPane().repaint();

    }
    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        functionJMenu.add(choose);
        choose.add(animal);
        choose.add(girl);
        choose.add(cartoon);
        animal.addActionListener(this);

        girl.addActionListener(this);
        cartoon.addActionListener(this);
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        this.setJMenuBar(jMenuBar);
    }

    private void Init() {
        this.setSize(608, 750);
        this.setTitle("拼图v1.0");


        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(3);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        setLocationRelativeTo(null);
        setLayout(null);

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(victory()){
            return;
        }
        if(code==65){
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path+"18.jpg"));

            all.setBounds(0,0,608,680);
            this.getContentPane().add(all);


            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上下左右判断
        if(victory()){
            return;
        }
        int code = e.getKeyCode();

        System.out.println(code);
        if(code==37){
            if(y==3){
                return;
            }
            count++;
            System.out.println("向左移动");
            data[x][y]=data[x][y+1];
            data[x][y+1]=16;
            y++;
            initImage();
        }else if(code==38){
            if(x==3){
                return;
            }
            count++;
            System.out.println("向上移动");
            data[x][y]=data[x+1][y];
            data[x+1][y]=16;
            x++;
            initImage();
        }else if (code==39){
            if(y==0){
                return;
            }
            count++;
            System.out.println("向右移动");
            data[x][y]=data[x][y-1];
            data[x][y-1]=16;
            y--;
            initImage();
        }else if(code==40){
            if(x==0){
                return;
            }
            count++;
            System.out.println("向下移动");
            data[x][y]=data[x-1][y];
            data[x-1][y]=16;
            x--;
            initImage();
        }
        else if(code==65){
            initImage();
        }else if(code==87){
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}
            };
            initImage();
        }
    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if(obj==replayItem){
            System.out.println("重新游戏");
            count=0;
            initDate();
            initImage();
        }else if(obj==reLoginItem){
            System.out.println("重新登录");
            this.setVisible(false);
            new LoginJFrame();
        }else if(obj==closeItem){
            System.out.println("关闭");
            System.exit(0);
            //直接关闭
        }else if(obj==accountItem){
            System.out.println("公众号");

            JDialog jDialog=new JDialog();
            jDialog.setSize(300,300);
            JLabel jLabel=new JLabel(new ImageIcon("C:\\Users\\atom\\IdeaProjects\\Game\\Image\\A_200x204.jpg"));
            jLabel.setBounds(0,0,200,204);
            jDialog.getContentPane().add(jLabel);

            jDialog.setAlwaysOnTop(true);

            jDialog.setLocationRelativeTo(null);

            jDialog.setModal(true);

            jDialog.setVisible(true);
        }else if(obj==cartoon){
            int num1 =random1.nextInt(8)+1;
            path="C:\\Users\\atom\\IdeaProjects\\Game\\Image\\gameImage\\cartoon\\bg"+num1+"_600x680\\";
            initDate();
            initImage();
        }else if(obj==girl){
            int num1 =random1.nextInt(6)+1;
            path="C:\\Users\\atom\\IdeaProjects\\Game\\Image\\gameImage\\girl\\"+num1+"_600x680\\";

            initDate();
            initImage();
        }else if(obj==animal){
            int num1 =random1.nextInt(9)+1;
            path="C:\\Users\\atom\\IdeaProjects\\Game\\Image\\gameImage\\animal\\download"+num1+"_600x680\\";
            initDate();
            initImage();
        }
    }
}
