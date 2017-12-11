package examples;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Alena
 */
public class ProgressBarExample {

    final static int interval = 1000;
    int i;
    Timer t;
    JButton button;
    JProgressBar progress;
    
    public ProgressBarExample() {
        
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new GridLayout(2, 1));
        button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                i = 0;
                t.start();
                button.setEnabled(false);
            }
        });
        progress = new JProgressBar(0, 20);
        progress.setValue(0);
        progress.setStringPainted(true);
        t = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i==20) {
                    t.stop();
                    button.setEnabled(true);
                } else {
                    i = i+2;
                    progress.setValue(i);
                    System.out.println(progress.getPercentComplete());
                }
            }
        });
        frame.getContentPane().add(progress);
        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setResizable(false);
        frame.setVisible(true);
    }
      
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProgressBarExample();
            }
        });
    }
    
}
