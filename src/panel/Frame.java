package panel;

import javax.swing.*;
import java.awt.*;
import java.awt.Panel;
import java.awt.event.*;
import java.util.EventListener;

public class Frame{
    public String linkImage = "C:\\Users\\Elvira\\Desktop\\Stuff\\Java_projects\\Pogoda\\JOptionPane\\src\\57.PNG";
    String str = "";

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

        butGr.add(jHex);
        butGr.add(jDec);
        butGr.add(jOct);
        butGr.add(jBin);

        jHex.setActionCommand("Hex");
        jDec.setActionCommand("Dec");
        jBin.setActionCommand("Bin");
        jOct.setActionCommand("Oct");
        jDec.setSelected(true);
        str = butGr.getSelection().getActionCommand();
        //  System.out.println(butGr.getSelection().getActionCommand());

        jText.setBounds(50, 100, 180, 30);
        jText.setEditable(true);
        jText.addMouseListener(new MouseAdapter() {
            @Override
            // стирать все, что внутри, когжа мышью нажал на окно
            public void mousePressed(MouseEvent e) {
                super.mouseEntered(e);
                jText.setText("");
                outText.setText("");
            }
        });

        frame.add(jText);

        outText.setBounds(50, 150, 180, 30);
        outText.setEditable(false);

      /*  That's a removal of any entered text! Should be used when you need to
      removed text enery time the mouse is going through the panel
      outText.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                outText.setText("");
            }
        });
        */

        jText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char ch = e.getKeyChar();
                outText.setText(outText.getText() + String.valueOf(ch));

            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
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

        jHex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (str =="Bin" && jHex.isSelected())
                {
                    outText.setText(Calculation.calcHex(jText.getText(), 2));
                    System.out.println(str);
                }
                if(str == "Dec" && jHex.isSelected()) {
                    outText.setText(Convertion.divisionToNumb(Integer.parseInt(jText.getText()), 16));
                    System.out.println(str);
                }

                if(str == "Oct" && jHex.isSelected()) {
                    outText.setText(Calculation.calcHex(jText.getText(), 8));
                }

                str = e.getActionCommand();
            }
        });

        jBin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(str == "Hex") {
                    outText.setText(Calculation.calcBin(jText.getText(), 16));
                }
                if(str == "Dec") {
                    outText.setText(Calculation.calcBin(jText.getText(), 10));
                }
                if(str == "Oct") {
                    outText.setText(Calculation.calcOct(jText.getText(), 2));
                }

                str = e.getActionCommand();
            }
        });
        jDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(str == "Bin" && jDec.isSelected()) {
                    outText.setText(Convertion.multiplyMethod(jText.getText(), 2));
                }
                if(str == "Hex" && jDec.isSelected()) {
                    outText.setText(Convertion.multiplyMethod(jText.getText(), 16));
                    System.out.println(str);
                }

                if(str == "Oct" && jDec.isSelected()) {
                    outText.setText(Convertion.multiplyMethod(jText.getText(), 8));
                }

                str = e.getActionCommand();
            }
        });
        jOct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(str == "Bin") {
                    outText.setText(Calculation.calcBin(jText.getText(), 8));
                    // outText.setText(Calculation.calcOct(jText.getText(), 2));
                }
                if(str == "Dec") {
                    outText.setText(Convertion.divisionToNumb(Integer.parseInt(jText.getText()), 8));
                }
                if(str == "Hex") {
                    outText.setText(Calculation.calcOct(jText.getText(), 16));
                }

                str = e.getActionCommand();
            }
        });
    }
    JRadioButton jHex = new JRadioButton("Hex");
    JRadioButton jDec = new JRadioButton("Dec");
    JRadioButton jOct = new JRadioButton("Oct");
    JRadioButton jBin = new JRadioButton("Bin");
    ButtonGroup butGr = new ButtonGroup();
    JTextField jText = new JTextField();
    JTextField outText = new JTextField();

    public static void main(String[] args){
        new Frame();
    }
    public class Field implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}