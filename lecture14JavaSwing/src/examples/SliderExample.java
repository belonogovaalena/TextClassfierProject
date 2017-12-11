package examples;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Alena
 */
public class SliderExample {

    public SliderExample() {
        JFrame frame = new JFrame();
        JSlider slider = new JSlider();
        slider.setOrientation(0);
        slider.setMaximum(100);
        slider.setMinimum(0);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);
        slider.setValue(30);
        JLabel label = new JLabel();
        label.setText("0");
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText(String.valueOf(slider.getValue()));
            }
        });
        frame.getContentPane().setLayout(new GridLayout(2, 1));
        frame.getContentPane().add(slider);
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);
    }
    
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SliderExample();
            }
        });
    }
}