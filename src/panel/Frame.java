package panel;

import javax.swing.*;
import java.awt.Panel;

public class Frame extends JFrame{
    public String linkImage = "C:\\Users\\Elvira\\Desktop\\Stuff\\Java_projects\\Pogoda\\JOptionPane\\src\\57.PNG";

    public Frame(){
        super("CONVERTOR");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(linkImage).getImage());
        setSize(500, 300);
        add(new Panel());

        // setResizable(true);

        setLocationRelativeTo(null); // == setLocation(400, 200);
        setVisible(true);
    }
    public static void main(String[] args){
       // SwingUtilities.invokeLater(new Runnable() {
        new Frame();
    }

}
