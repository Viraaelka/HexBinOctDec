package panel;


import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{

    public Panel(){
        setLayout(null);
     //   setFocusable(true);
      //  grabFocus();
      //  setBackground(Color.BLACK);
       // setBounds(410, 220, 90, 90);
        textField.setBounds(10, 50, 50, 50);
        textField.setEditable(true);
        textField.setFont(font);
        add(textField);

        label.setBounds(50, 100, 50, 50);
        label.setForeground(Color.BLUE);
        add(label);

        button.setBounds(100, 5, 100, 100);
        add(button);

    }

    private JTextField textField = new JTextField();
    private JLabel label = new JLabel("label");
    private Font font = new Font("SanSerIf",Font.BOLD, 20);
    private JButton button = new JButton();
    public String linkImage = "C:\\Users\\Elvira\\Desktop\\Stuff\\Java_projects\\Pogoda\\JOptionPane\\src\\57.PNG";

}
