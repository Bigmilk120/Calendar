package sample;

import java.sql.*;

public class JDBCOperations {
    public static void selectAllFrom() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("note_id");
                Date date = rset.getDate("date");
                String note_text = rset.getString("note_text");
                System.out.println(id + ", " + date + ", " + note_text);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static String selectFrom(Date date) {
        String result="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            String strSelect = "select * from note where date like '"+date+"'";

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            String strSelect = "insert into note values (0,'"+date+"' , '"+note_text+"')";
            System.out.println("The SQL query is: " + strSelect);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public static void deleteFrom(int note_id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Notes?useSSL=false&serverTimezone=UTC", "root", "zaq1@WSX");
            Statement stmt = conn.createStatement();
            String strSelect = "delete from note where note_id like "+note_id;

            int rset = stmt.executeUpdate(strSelect);
            System.out.println(rset + " records inserted.\n");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
