package examples.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alena
 */
public class TableExample {
    
    TableExample() {
        JFrame frame = new JFrame();
        JTable myTable = createTable();
        frame.getContentPane().add(myTable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(400,200);
        frame.setVisible(true);
    }
    
    private JTable createTable() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"Metallica", "Master of Puppets", "Disposable Heroes"});
        list.add(new String[]{"Megadeth", "Rust In Peace", "Dawn Patrol"});
        list.add(new String[]{"Deep Purple", "Machine Head", "Smoke on the Water"});
        ModelForTable model = new ModelForTable((ArrayList<String[]>) list);
        JTable myTable = new JTable(model);
        return myTable;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableExample();
            }
        });
    }
}