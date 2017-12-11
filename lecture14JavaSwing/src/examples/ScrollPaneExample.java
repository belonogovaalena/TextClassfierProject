package examples;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alena
 */
public class ScrollPaneExample {
    
    ScrollPaneExample() {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new GridLayout(2, 1));
        JTextArea text = new JTextArea();
        text.setText("Ученые также предполагают, что черно-белый окрас панды связан" 
                + "\n" + "с неспособностью животного переваривать какие-либо продукты," 
                + "\n" + "кроме бамбука. Это означает, что панда не может накопить " 
                + "\n" + "достаточное количество жира, чтобы зимой впадать в спячку," 
                + "\n" + "как это делают медведи. Таким образом, панда вынуждена "
                + "\n" +  "оставаться активной круглый год, постоянно меняя места "
                +  "\n" + "обитания, которые варьируются от снежных гор "
                + "\n" +  "до тропических лесов. Вместе с тем ученые полагают, "
                + "\n" + "что темные уши панды пугают хищников, придавая им более"
                + "\n" + "свирепый вид, а черные пятна вокруг глаз помогают "
                + "\n" + "пандам узнавать друг друга среди других животных."); 
        JScrollPane pane = new JScrollPane(text);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //frame.getContentPane().add(text);
        frame.getContentPane().add(pane);
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
                new ScrollPaneExample();
            }
        });
    }
}