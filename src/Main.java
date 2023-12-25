import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
  File f1=new File("TreasureInput.txt");
        BufferedReader br=new BufferedReader(new FileReader(f1));

        new Treasure(br);

    }
}
class Treasure extends JFrame implements ActionListener
{   JFrame frame;
    BufferedReader br;
   int randomnum;
    String s1;
    int win=0;
    int value=1;
    int countclk=3;
    Container container;
    JLabel treasure,count,countshow,into;
    JPanel panelTreasure,panelGuess,panel1,panel2,panel3;
    JButton[] btn=new JButton[3];
    JButton btn4;
    Treasure(BufferedReader br) throws IOException {//container=new Container();
        frame=new JFrame("Treasure Hunt");
this.br=br;
        Random random=new Random();
        randomnum=random.nextInt(3)+1;
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setSize(800,750);
        frame.getContentPane().setBackground(Color.green);
        ImageIcon imageIcon=new ImageIcon("treasure.jpg");
        frame.setIconImage(imageIcon.getImage());
       s1= br.readLine();
        treasure=new JLabel(s1);
        treasure.setBounds(350,230,80,40);
        treasure.setFont(new Font("serif",Font.BOLD,20));
        frame.add(treasure);
        panelTreasure=new JPanel();
        panelTreasure.setLayout(null);
        panelTreasure.setBounds(270,200,200,100);
         panelTreasure.setBackground(Color.CYAN);
        into=new JLabel("GUESS THE TREASURE\n:)");
        into.setFont(new Font("Ink Free",Font.BOLD,20));
        into.setBounds(250,70,250,40);
        frame.add(into);
         frame.add(panelTreasure);
         count=new JLabel("Remaining life  :");
         count.setFont(new Font("Ink Free",Font.BOLD,20));
         count.setBounds(20,20,150,40);
        countshow=new JLabel("3");
        countshow.setFont(new Font("Ink Free",Font.BOLD,20));
        countshow.setBounds(170,20,50,40);

         frame.add(count);
         frame.add(countshow);

        btn[0]=new JButton("1");
        btn[0].addActionListener(this);
        btn[0].setBounds(200,500,100,40);
        btn[1]=new JButton("2");
        btn[1].addActionListener(this);
        btn[1].setBounds(330,500,100,40);
        btn[2]=new JButton("3");
        btn[2].addActionListener(this);
        btn[2].setBounds(460,500,100,40);
        btn4=new JButton("CHANGE TREASURE");
        btn4.setBounds(250,600,250,40);
        btn4.setFont(new Font("Ink Free",Font.BOLD,20));
btn4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

            try {
                s1=br.readLine();
            } catch (IOException ex) {
                System.out.println("Treasure Not Found");
            }
            treasure.setText(s1);


    }
});
        btn[0].setFocusable(false);
        btn[1].setFocusable(false);
        btn[2].setFocusable(false);
        btn4.setFocusable(false);
        frame.add(btn[0]);
        frame.add(btn[1]);
        frame.add(btn[2]);
        frame.add(btn4);

        panel1=new JPanel();
        panel1.setBackground(new Color(0x957B16));
        panel1.setBounds(0,400,800,350);
        frame.add(panel1);

        frame.repaint();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0] && randomnum == 1 && countclk >= 0)
            Winner();
        if (e.getSource() == btn[1] && randomnum == 1)
            Winner();
        if (e.getSource() == btn[2] && randomnum == 3 && countclk >= 0)
            Winner();

        countclk--;
        Random random = new Random();
        randomnum = random.nextInt(3) + 1;
        countshow.setText(String.valueOf(countclk));


}
    public void Winner()
    {
        win=1;

        frame.setVisible(false);
        JFrame fwin=new JFrame("CONGRATULATIONS");
        fwin.setVisible(true);
        JLabel jwin=new JLabel("WINNER!");
        fwin.setSize(500,500);
        fwin.setLayout(null);
        jwin.setBounds(200,100,100,40);
        jwin.setFont(new Font("Ink Free",Font.BOLD,20));
        fwin.add(jwin);
        fwin.getContentPane().setBackground(new Color(0xD924E724, true));
        fwin.setLocation(500,200);
        fwin.repaint();
    }
    public void Lost()
    {

        frame.setVisible(false);
        JFrame fwin=new JFrame("SORRY");
        fwin.setVisible(true);
        JLabel jwin=new JLabel("BETTER LUCK NEXT TIME");
        fwin.setSize(500,500);
        fwin.setLayout(null);
        jwin.setBounds(100,100,300,40);
        jwin.setFont(new Font("Ink Free",Font.BOLD,20));
        fwin.add(jwin);
        fwin.getContentPane().setBackground(new Color(0xF97A0227, true));
        fwin.setLocation(500,200);
        fwin.repaint();
    }


}