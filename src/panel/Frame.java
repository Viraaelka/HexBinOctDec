package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.Panel;
import java.awt.event.*;

public class Frame{
    public String linkImage = "C:\\Users\\Elvira\\Desktop\\Stuff\\Java_projects\\Pogoda\\JOptionPane\\src\\57.PNG";
    JFrame frame;

    public Frame(){
        frame = new JFrame();
        frame.setTitle("CONVERTOR");
        frame.setIconImage(new ImageIcon(linkImage).getImage());
        frame.setSize(300, 300);

        jHex.setBounds(40, 50, 50, 30);
        jDec.setBounds(90, 50, 50, 30);
        jOct.setBounds(140, 50, 50, 30);
        jBin.setBounds(190, 50, 50, 30);
        ButtonGroup butGr = new ButtonGroup();
        butGr.add(jHex);
        butGr.add(jDec);
        butGr.add(jOct);
        butGr.add(jBin);
        jText.setBounds(50, 100, 180, 30);
        jText.setEditable(true);
        jText.addMouseListener(new MouseAdapter() {
           @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                  jText.setText("");
            }
        });
        frame.add(jText);

        outText.setBounds(50, 150, 180, 30);
        outText.setEditable(false);
        outText.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                outText.setText("");
            }
        });
        frame.add(outText);

        frame.add(jHex);
        frame.add(jDec);
        frame.add(jOct);
        frame.add(jBin);

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    JRadioButton jHex = new JRadioButton("Hex");
    JRadioButton jDec = new JRadioButton("Dec");
    JRadioButton jOct = new JRadioButton("Oct");
    JRadioButton jBin = new JRadioButton("Bin");
    JTextField jText = new JTextField("Type the number");
    JTextField outText = new JTextField("Output");

    public static void main(String[] args){
        new Frame();
    }

}
