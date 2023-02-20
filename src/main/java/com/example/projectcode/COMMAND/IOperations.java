package com.example.projectcode.COMMAND;


import com.example.projectcode.MEMENTO.ECareTaker;
import javafx.scene.control.TextArea;

/* IOperations interface'i tanımlanmıştır.*/
public interface IOperations {
    /* TextArea değerleri alan open, close, save, saveAs, undo ve find metotları, bu interface'i implemente edecek
    * olan class'ların tanımlamak zorunda olduğu metotlardır. undo ve find için ek olarak sırayla CareTaker ve
    * String türünden parametreler de gereklidir.*/
    void open(TextArea textArea);
    void close(TextArea textArea);
    void save(TextArea textArea);
    void saveAs(TextArea textArea);
    void undo(TextArea textArea, ECareTaker careTaker);
    int find(TextArea textArea,String searchString);




}
