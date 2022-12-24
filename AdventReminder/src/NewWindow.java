
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micah
 */
public class NewWindow extends JComponent{
    
    JFrame frame = new JFrame("Advent Time");
    BufferedImage[] slides = new BufferedImage[4];
    
    
    NewWindow(int callTime) throws IOException{
        //loads images
        loadImages();
        ImageIcon icon = new ImageIcon(slides[callTime]);
        
        
        frame.setLayout(new FlowLayout());
        frame.setBounds(1240, 690, 1240, 745);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        if(callTime==3){
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
    }
    
    
    //set up the game window size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1240, 690);
    }
    
    private void loadImages() throws IOException{
        //load slides
        slides[0] = ImageIO.read(new File("src/Images/S1.png"));
        slides[1] = ImageIO.read(new File("src/Images/S2.png"));
        slides[2] = ImageIO.read(new File("src/Images/S3.png"));
        slides[3] = ImageIO.read(new File("src/Images/S4.png"));
    }
}
