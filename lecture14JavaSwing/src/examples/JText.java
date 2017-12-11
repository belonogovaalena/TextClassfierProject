/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaswing;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author admin
 */
public class JText{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("title form");
        
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        
        
        /////////JText
     
        /*JTextField textField = new JTextField(20);
        JTextField textField2 = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.LEFT);
        //textField.setText("My Test Text");
        JButton button = new JButton("klick");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               textField2.setText(textField.getText());
                }
        });
        
       frame.add(textField);
       frame.add(textField2);
       frame.add(button);
        
        */
      
        ///////////JPasswordField
        
        
       /*JPasswordField PasFie = new JPasswordField("", 20);
       JTextField textField = new JTextField(20);
       JButton button = new JButton("klick");
       button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //textField.setText(PasFie.getText());
               textField.setText(new String(PasFie.getPassword()));
                }
        });
       //PasFie.setEchoChar('*');
       //System.out.println(PasFie.getPassword());
       frame.add(PasFie);
       frame.add(textField);
       frame.add(button);
        */
       
       //////////JTextArea
      
        /*JButton button = new JButton("klick");
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); //перенос слова на след строку
        //textArea.append("Область для ввода текстового содержимого");
        //textArea.insert("ВСТАВКА", 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //textField.setText(PasFie.getText());
                    FileWriter file = new FileWriter("testArea.txt");
                    file.write(textArea.getText());
                    file.close();
                    textArea.setText("Текст записан");
                } catch (IOException ex) {
                    System.out.println("exception");
                }
                }
        });
       
        frame.add(textArea);
        frame.add(button);
        
       */
        
        
        //////JComboBox
        
        
        /*
          String []str = {"point 1", "point 2", "point 3"};
          JComboBox myBox = new JComboBox(str);
        //myBox.setEditable(true);
        //myBox.addItem("point 4");
        //myBox.insertItemAt("new point", 2);
        //System.out.println(myBox.getItemAt(2)); 
        //myBox.removeAllItems();
        //myBox.removeItem("new point");
        //myBox.setSelectedItem("point 3"); 
        //System.out.println(myBox.getSelectedItem());
          frame.add(myBox);
        */
          
         
        //////JList
        
        
         /* String []str = {"Cat", "Dog", "Pig", "Bird", "Fish", "Rabbit", "11", "22", "33", "44", "55", "66", "77", "88", "99"};
        
          JPanel mainPanel = new JPanel();
          JList myList = new JList(str);
          myList.setLayoutOrientation(JList.VERTICAL);
          //myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          System.out.println(myList.getSelectedIndex());
 
          JScrollPane scroll = new JScrollPane(myList);
          scroll.setPreferredSize(new Dimension(200, 100));
          mainPanel.add(scroll);
          frame.getContentPane().add(mainPanel);
          */
         
          frame.setVisible(true);
                  
        
    }
    
}
