package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteDAO {

    //*******************************
    //SELECT an Employee
    //*******************************
    public static Notes searchNotes (String empId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM notes WHERE note_id="+empId;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Notes note = getNoteFromResultSet(rsEmp);

            //Return employee object
            return note;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + empId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Notes getNoteFromResultSet(ResultSet rs) throws SQLException
    {
        Notes emp = null;
        if (rs.next()) {
            emp = new Notes();
            emp.setNoteId(rs.getInt("NOTE_ID"));
            emp.setDate(rs.getDate("DATE"));
            emp.setNoteText(rs.getString("NOTE_TEXT"));
        }
        return emp;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Notes> searchEmployees () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM notes";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Notes> empList = getNotesList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Notes> getNotesList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Notes> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Notes emp = new Notes();
            emp.setNoteId(rs.getInt("NOTE_ID"));
            emp.setDate(rs.getDate("DATE"));
            emp.setNoteText(rs.getString("NOTE_TEXT"));
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }

    //*************************************
    //DELETE an employee
    //*************************************
    public static void deleteEmpWithId (String empId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM notes\n" +
                        "         WHERE note_id ="+ empId +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT an employee
    //*************************************
    public static void insertEmp (String name, Date date, String note_text) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO notes\n" +
                        "(NOTE_ID, DATE, NOTE_TEXT)\n" +
                        "VALUES\n" +
                        "(sequence_employee.nextval, '"+name+"', '"+date+"','"+note_text+"', SYSDATE, 'IT_PROG');\n" +
                        "END;";

        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}