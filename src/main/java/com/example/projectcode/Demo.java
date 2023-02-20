package com.example.projectcode;

import com.example.projectcode.CONTROLLER.NOTEPADCONTROLLER;
import com.example.projectcode.FACTORY.ThemeFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/* Java FX uygulaması oluşturulur.*/
public class Demo extends Application {
    /* Scene => Görünen Kısım. */
    /* Stage => Genel progrem yapısıdır. */
    public static Scene globalScene ;
    public static Stage globalStage;

    /* Start ile program başlar.*/
    @Override
    public void start(Stage stage) throws IOException {
        /* Notepad FXML kaynağı yüklenir.*/
        FXMLLoader fxmlLoader = new FXMLLoader(Demo.class.getResource("NOTEPAD.fxml"));
        /* Notepad için size ayarlanır.*/
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        /* Title belirlenir ve Scene set edilir.*/
        stage.setTitle("NOTEPAD");
        stage.setScene(scene);

        /* Default olarak aydınlık tema seçilir.*/
        scene.getStylesheets().add(ThemeFactory.getTheme("light").createTheme());

        /* scene ve stage static değerleri tanımlanır ve program gösterilir.*/
        globalScene = scene;
        globalStage = stage;

        stage.show();
    }
    /* Program çalıştırılır.*/
    public static void main(String[] args) {
        launch();
    }

}