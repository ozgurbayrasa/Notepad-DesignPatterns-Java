package com.example.projectcode.CONTROLLER;

import com.example.projectcode.COMMAND.*;
import com.example.projectcode.Demo;
import com.example.projectcode.FACTORY.ThemeFactory;
import com.example.projectcode.MEMENTO.ECareTaker;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class NOTEPADCONTROLLER{

    /* undo için caretaker */
    private ECareTaker careTaker = new ECareTaker();

    /* Üst kısımdaki butonlar.*/
    @FXML
    private Button openButton,closeButton,saveButton,saveAsButton,findButton,undoButton;

    /* Metin alanı*/
    @FXML
    private TextArea textArea;

    /* DARK THEME butonu */
    @FXML
    private Button darkThemeButton;
    /* LIGHT THEME butonu */
    @FXML
    private Button lightThemeButton;

    /* Metin girilme alanı (eşleşme metini bulma)*/
    @FXML
    private TextField findInput;
    /* Eşleşme sonuç alanı*/
    @FXML
    private Text findResult;


    /* Kullanıcı her karakter girdiğinde, girilen değer careTaker'a gönderilsin.
    * Mesela ekranda A yazıyorsa CareTaker('A') olur. */
    @FXML
    private void initialize() {
        textArea.textProperty().addListener((observableValue, oldValue, newValue) -> careTaker.textChanged(newValue));
    }


    /* Üst butonların tetikleyicileri tanımlanır. */
    @FXML
    public void upperButtonHandler(MouseEvent event){
        /* Butona tıklanınca id'leri alınsın.*/
        Button clickedButton = (Button) event.getSource();
        String clickedButtonId = clickedButton.getId();

        /* İlgili ID'ye göre işlemler switch ile gösterilir. */
        Command commandToExecute;
        switch (clickedButtonId){
            /* openButton için ilgili Command oluşturulur. O Commandın execute metodu
             uygun parametre ile çalıştırılır.*/
            case "openButton":
                commandToExecute = new OpenCommand();
                commandToExecute.execute(textArea);
                break;
            /* closeButton için ilgili Command oluşturulur. O Commandın execute metodu
             uygun parametre ile çalıştırılır.*/
            case "closeButton":
                commandToExecute = new CloseCommand();
                commandToExecute.execute(textArea);
                break;
            /* saveButton için ilgili Command oluşturulur. O Commandın execute metodu
             uygun parametre ile çalıştırılır.*/
            case "saveButton":
                commandToExecute = new SaveCommand();
                commandToExecute.execute(textArea);
                break;
            /* saveAsButton için ilgili Command oluşturulur. O Commandın execute metodu
             uygun parametre ile çalıştırılır.*/
            case "saveAsButton":
                commandToExecute = new SaveAsCommand();
                commandToExecute.execute(textArea);
                break;
            /* findButton için ilgili Command oluşturulur. O Commandın execute metodu
             uygun parametre ile çalıştırılır.*/
            case "findButton":
                commandToExecute = new FindCommand(findInput.getText());
                commandToExecute.execute(textArea);
                ((FindCommand) commandToExecute).changeField(findResult);
                break;
            /* undoButton için ilgili Command oluşturulur. O Commandın execute metodu
             uygun parametre ile çalıştırılır.*/
            case "undoButton":
                commandToExecute = new UndoCommand(careTaker);
                commandToExecute.execute(textArea);
                break;

        }

    }

    /* Alt kısımdaki tema değiştirme butonları.*/
    @FXML
    public void lowerButtonHandler(MouseEvent event){
        /* Butona tıklanınca id'leri alınsın.*/
        Button clickedButton = (Button) event.getSource();
        String clickedButtonId = clickedButton.getId();
        /* CSS kısmı temizlensin ve ilgili butonun ID'sine göre yeni tema eklensin.*/
        Demo.globalScene.getStylesheets().clear();
        Demo.globalScene.getStylesheets().add(ThemeFactory.getTheme(clickedButtonId).createTheme());
    }


}


