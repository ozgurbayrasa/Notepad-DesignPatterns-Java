package com.example.projectcode.COMMAND;


import javafx.scene.control.TextArea;
/* SaveAsCommand, ICommand interface'ini implemente eder. Dolayısıyla execute metodu olmalıdır.*/

public class SaveAsCommand extends Command {


    @Override
    public void execute(TextArea textArea) {
        super.getOperations().saveAs(textArea);
    }
}
