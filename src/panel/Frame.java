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

        butGr.add(jHex);
        butGr.add(jDec);
        butGr.add(jOct);
        butGr.add(jBin);
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
                if (jDec.isValid() && jHex.isSelected()) {
                    outText.setText("Hey broo");
                }

                    // outText.setText(Calculation.calcHex(jText.getText(), 10));

                    if (jDec.isSelected()) outText.setText(Calculation.calcHex(jText.getText(), 10));
                    if (jOct.isSelected()) outText.setText(Calculation.calcHex(jText.getText(), 8));
                    if (jBin.isSelected()) outText.setText(Calculation.calcHex(jText.getText(), 2));

             /*   if (jBin.isValid()){
                    if (jDec.isSelected()) outText.setText(Calculation.calcBin(jText.getText(), 10));
                    if (jOct.isSelected()) outText.setText(Calculation.calcBin(jText.getText(), 8));
                    if (jHex.isSelected()) outText.setText(Calculation.calcBin(jText.getText(), 16));
                } */
            }
        });
       /* jBin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jBin.isValid()){
                    if (jDec.isSelected()){}
                    if (jOct.isSelected()){}
                    if (jHex.isSelected()){}
                }
            }
        }); */
    /*    jDec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jDec.isValid()){
                    if (jHex.isSelected()){}
                    if (jOct.isSelected()){}
                    if (jBin.isSelected()){}
                }
            }
        }); */
     /*   jOct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jOct.isValid()) {
                    if (jDec.isSelected()){}
                    if (jHex.isSelected()){}
                    if (jBin.isSelected()){}
                }
            }
        }); */
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
