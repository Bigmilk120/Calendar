package sample;

import java.sql.*;

public class JDBCOperations {

    static String username = Login.giveUsername();
    static String password = Login.givePassword();

    public static String selectAllFrom() {
        String res = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", username, password);
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note"+username;

            ResultSet rset = stmt.executeQuery(strSelect);

            int rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("note_id");
                Date date = rset.getDate("date");
                String note_text = rset.getString("note_text");
                res += id + ", " + date + ", " + note_text+ "\n";
                ++rowCount;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return res;
    }
    public static String selectFrom(Date date) {
        String result="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", username, password);
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note"+username+" where date like '"+date+"'";

            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("note_id");
                date = rset.getDate("date");
                String note_text = rset.getString("note_text");
                result+=id + ", " + date + ", " + note_text+"  \n";
                ++rowCount;
            }

        }catch(Exception ex){
            System.out.println(ex);
        }
        return result;
    }
    public static void insertInto(Date date, String note_text){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", username, password);
            Statement stmt = conn.createStatement();
            int id = giveLastID();
            String strSelect = "insert into note"+username+" values ("+id+",'"+date+"' , '"+note_text+"')";
            stmt.executeUpdate(strSelect);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void deleteFrom(int note_id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", username, password);
            Statement stmt = conn.createStatement();
            String strSelect = "delete from note"+username+" where note_id like "+note_id;

            int rset = stmt.executeUpdate(strSelect);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static int giveLastID() {
        int temp_id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", username, password);
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note"+username;

            ResultSet rset = stmt.executeQuery(strSelect);

            int rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("note_id");
                if(temp_id<=id)
                    temp_id=id;
                ++rowCount;
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        temp_id++;
        return temp_id;
    }
}
