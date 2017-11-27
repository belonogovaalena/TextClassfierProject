
package JDBC;

/**
 *
 * @author Алена
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDatabaseJDBC {
    public Connection con;
    public Statement stat;
    public int size;
    public ArrayList loginAndAge, idAndPass;

    public WorkWithDatabaseJDBC(){
        createTableUsers();
        createListForSwing();
    }

    private void createTableUsers()  {
       toConnect();
       try {
            stat.execute("CREATE TABLE users("+
                    "id INTEGER PRIMARY KEY,"+
                    "login VARCHAR(20),"+
                    "age INTEGER);"); 
            stat.execute("CREATE TABLE pass("+
                        "id INTEGER PRIMARY KEY,"+
                        "pass VARCHAR(20));");   
            con.commit();

        } catch (SQLException ex) {
            try {
                con.rollback(); 
                con.close();
                //System.out.println("SQL exception when table was creating.");
            } catch (SQLException ex1) {
                System.out.println("Can't roll back");
            }
        }  
    }


public void insertInto(String login, int age, String password) {
    toConnect();
    try {
        size++;
        stat.executeUpdate("INSERT INTO users "
                + "VALUES ("+size+",'"+login+"',"+age+");");
       stat.executeUpdate("INSERT INTO pass "
            + "VALUES (" + size + ", '" + password + "');");
        con.commit();
        con.close();
        
    } catch (SQLException ex) {
            System.out.println("SQL exception was created when something had been adding.");
        }
    }

    public void deleteFrom (int id) {
        toConnect();
        try {
            stat.executeUpdate("DELETE FROM users "
                    + "WHERE id = " + id + ";");
            stat.executeUpdate("DELETE FROM pass "
                    + "WHERE id = " + id + ";");
            con.commit();
            con.close();
        } catch (SQLException ex) {
            System.out.println("SQL exception was created when something had been deleting");
        }
    }

    public boolean checkPass (String login, String pass) {
        toConnect();
        int id = 0;
        String passFrom="";
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM users WHERE login = '" + login + "';");
            while (result.next())
                id = result.getInt("id");
            if (id==0)
                return false;
            else {
                ResultSet result2 = stat.executeQuery("SELECT * FROM pass WHERE id = '"+id+"';");
                while (result2.next())
                    passFrom = result2.getString("pass"); 
            con.close();
            if (passFrom.equals(pass))
                return true;
            else
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("SQL exception was created when something was cheecking");
        }
        return false;
    }


    private void toConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Can't find this class.");
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseforjdbc", "root", "1111");
            stat = con.createStatement();
            con.setAutoCommit(false);
        } catch (SQLException ex) {
                System.out.println("SQL exception was created.");
        }
    }

    private void createListForSwing()  {
        toConnect();

        List<String[]> arrayList1 = new ArrayList<>();
        List<String[]> arrayList2 = new ArrayList<>();
         try {
           ResultSet result1 = stat.executeQuery("SELECT * FROM users;");
            while (result1.next()) {
                String[] value1 = new String[3];
                value1[0] = String.valueOf(result1.getInt("id"));
                value1[1] = result1.getString("login");
                value1[2] = String.valueOf(result1.getInt("age"));
                size = result1.getInt("id");
                arrayList1.add(value1);
            }
            loginAndAge = (ArrayList) arrayList1;
            ResultSet result2 = stat.executeQuery("SELECT * FROM pass;");
            while (result2.next()) {
                String[] value2 = new String[2];
                value2[0] = String.valueOf(result2.getInt("id"));
                value2[1] = result2.getString("pass");
                arrayList2.add(value2);
            }
            idAndPass = (ArrayList) arrayList2;
            con.close();   
       } catch (SQLException e) {
           System.out.println("Can't create it.");
       }
    }
}    