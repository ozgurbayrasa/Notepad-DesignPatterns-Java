package com.example.projectcode.COMMAND;


import javafx.scene.control.TextArea;

/* OpenCommand, ICommand interface'ini implemente eder. Dolayısıyla execute metodu olmalıdır.*/
public class OpenCommand extends Command {


    @Override
    public void execute(TextArea textArea) {
        super.getOperations().open(textArea);

    }
}
