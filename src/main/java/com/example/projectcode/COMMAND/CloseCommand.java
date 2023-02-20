package com.example.projectcode.COMMAND;


import javafx.scene.control.TextArea;
/* CloseCommand, ICommand interface'ini implemente eder. Dolayısıyla execute metodu olmalıdır.*/
public class CloseCommand extends Command {
    @Override
    public void execute(TextArea textArea){
        super.getOperations().close(textArea);
    }
}
