package com.example.projectcode.COMMAND;

import com.example.projectcode.MEMENTO.ECareTaker;
import javafx.scene.control.TextArea;
/* UndoCommand, ICommand interface'ini implemente eder. Dolayısıyla execute metodu olmalıdır.*/

public class UndoCommand extends Command {

    /* Bir careTaker oluşturulur ve UndoCommand constructor'ına gönderilir.*/
    private ECareTaker careTaker;
    public UndoCommand(ECareTaker careTaker) {
        this.careTaker = careTaker;
    }
    /* ICommand implemente edildiği için execute metodu olmalıdır. Burada FileOperations'daki
    * undo metoduna textArea ve careTaker gönderilir.*/
    @Override
    public void execute(TextArea textArea) {
        super.getOperations().undo(textArea,careTaker);
    }
}
