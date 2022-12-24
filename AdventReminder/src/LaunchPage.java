
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.util.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micah
 */
public class LaunchPage implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton myButton = new JButton("New Window");
    int callTime;
    public static Timer t;

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static class MyTimeTask extends TimerTask{
        int callTime;
        MyTimeTask(int callTime){
            this.callTime = callTime;
        }
    public void run(){
             try {
                 NewWindow window = new NewWindow(callTime);
                 callTime++;
             } catch (IOException ex) {
                 Logger.getLogger(LaunchPage.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
    
    LaunchPage() throws ParseException{
        callTime = 0;
        
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(false);
        
        //the Date and time at which you want to execute
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter .parse("2023-12-21 16:00:00");

        //Now create the time and schedule it
        Timer timer = new Timer();

        //Use this if you want to execute it multiple times
        int period = 86400000;//1 day
        if(callTime < 4)
            timer.schedule(new MyTimeTask(callTime), date, period);
    }
}
