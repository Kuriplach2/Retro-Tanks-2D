import java.awt.Color;
import javax.swing.JFrame;

public class Main {
    public Main(){

    }

    public static void main(String[] args) {
        //vytvorí JFrame
        JFrame frame = new JFrame();
        
        //vytvorí hru s tankami
        Hra hra = new Hra();

        //frame.setBounds(10, 10, 800, 630);
        frame.setSize(800, 630);
        frame.setTitle("Retro Tanks 2D");
        frame.setBackground(Color.gray);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(hra);
        frame.setVisible(true);
    }

}
