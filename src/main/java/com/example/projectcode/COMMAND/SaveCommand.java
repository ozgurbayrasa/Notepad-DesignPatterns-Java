package com.example.projectcode.COMMAND;

import javafx.scene.control.TextArea;
/* SaveCommand, ICommand interface'ini implemente eder. Dolayısıyla execute metodu olmalıdır.*/

public class SaveCommand extends Command {


    @Override
    public void execute(TextArea textArea) {
        super.getOperations().save(textArea);
    }
}
