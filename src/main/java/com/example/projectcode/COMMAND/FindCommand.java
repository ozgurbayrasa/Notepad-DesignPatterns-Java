package com.example.projectcode.COMMAND;


import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
/* FindCommand, ICommand interface'ini implemente eder. Dolayısıyla execute metodu olmalıdır.*/

public class FindCommand extends Command {
    /* Sonuç ve textArea'da aranacak string değeri belirtilmiştir.*/
    int result;
    private String changeString;

    /* Aranacak string değeri FindCommand constructur'ına gönderilmiştir.*/
    public FindCommand(String changeString) {
        this.changeString = changeString;
    }

    /* execute metoduyla, sonuç belirlenmiştir. Sonucun belirlenmesi için operationslardan find metodu kullanılmıştır.
    * kullanılmıştır. Bu metod FileOperations içinde detaylı tanımlanmıştır.
    * find ile ilgili textArea'da aranan string değerinin adedi sonuca atanmıştır. */
    @Override
    public void execute(TextArea textArea) {
        result = super.getOperations().find(textArea,changeString);
    }

    /* Sonuç değeri notePad içerisinde ilgili alana eklenmiştir. */
    public void changeField(Text text){
        text.setText(Integer.toString(result));
    }
}
