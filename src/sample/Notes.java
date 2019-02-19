package sample;

import javafx.beans.property.*;

import java.sql.Date;

public class Notes {
    //Declare Employees Table Columns
    private IntegerProperty note_id;
    private SimpleObjectProperty<Date> date;
    private StringProperty noteText;

    //Constructor
    public Notes() {
        this.note_id = new SimpleIntegerProperty();
        this.date = new SimpleObjectProperty<Date>();
        this.noteText = new SimpleStringProperty();
    }

    //note_id
    public int getNoteId() {
        return note_id.get();
    }

    public void setNoteId(int note_id){
        this.note_id.set(note_id);
    }

    public IntegerProperty noteIdProperty(){
        return note_id;
    }

    //date
    public Object getDate () {
        return date.get();
    }

    public void setDate(Date date){
        this.date.set(date);
    }

    public SimpleObjectProperty<Date> DateProperty() {
        return date;
    }

    //note_text
    public String getNoteText () {
        return noteText.get();
    }

    public void setNoteText(String noteText){
        this.noteText.set(noteText);
    }

    public StringProperty lastNoteText() {
        return noteText;
    }
}