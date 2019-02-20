package sample;

import java.sql.*;

public class JDBCOperations {
    public static void selectAllFrom(Statement stmt) {
        try {
            String strSelect = "select * from note";
            System.out.println("The SQL query is: " + strSelect);
            System.out.println();

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
    public static void insertInto(Statement stmt, int note_id, Date date, String note_text){
        try {
            String strSelect = "insert into note values ("+note_id+" , '"+date+"' , '"+note_text+"')";
            System.out.println("The SQL query is: " + strSelect);
            System.out.println();

            int rset = stmt.executeUpdate(strSelect);
            System.out.println(rset + " records inserted.\n");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void deleteFrom(Statement stmt, int note_id){
        try {
            String strSelect = "delete from note where note_id like "+note_id;

            int rset = stmt.executeUpdate(strSelect);
            System.out.println(rset + " records inserted.\n");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

}
