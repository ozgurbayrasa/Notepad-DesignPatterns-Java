package com.example.projectcode.COMMAND;


import javafx.scene.control.TextArea;
/* ICommand abstract class'tır, Bu class'ı extend edenler mutlaka bir Textarea alan execute metodunu tanımlamalıdır.*/
public abstract class Command {
    /* FileOperations türünden operations tanımlanmıştır. Tanımlanma türünden dolayı
    * IOperationslardaki metotlar mutlaka FileOperations sınıfında yazılmış olmalıdır.*/
    private IOperations operations = new FileOperations();

    public abstract void execute(TextArea textArea);

    public IOperations getOperations() {
        return operations;
    }
}
