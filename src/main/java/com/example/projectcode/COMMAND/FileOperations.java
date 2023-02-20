package com.example.projectcode.COMMAND;

import com.example.projectcode.CONTROLLER.NOTEPADCONTROLLER;
import com.example.projectcode.Demo;
import com.example.projectcode.FACTORY.ThemeFactory;
import com.example.projectcode.ITERATOR.FindWithIterator;
import com.example.projectcode.MEMENTO.ECareTaker;
import com.example.projectcode.SINGLETON.TXTFile;
import javafx.scene.control.TextArea;

/* Metotlar nasıl çalışmakta, buna buradan bakabiliriz. IOperations implemente edildiğinden
* ilgili metotlar tanımlanmalıdır.*/
public class FileOperations implements IOperations{
    /* open metodu Textarea alır. */
    /* Openda seçilen txt dosyasının içeriği okunur ve textArea'ya eklenir.*/
    @Override
    public void open(TextArea textArea) {
        TXTFile.getInstance().chooseFile();
        textArea.setText(TXTFile.getInstance().readFile());
    }

    /* close metodu TextArea alır. Eğer dosya seçilmemişse save as kullanılarak kaydedilecektir çünkü elimizde path bilgisi yok. Değilse
    * dosyanın içeriği kaydedilip sonra da kapatılacaktır. En son olarak metin içeriği null olarak atanır.*/
    @Override
    public void close(TextArea textArea) {
        if(TXTFile.getInstance().isEmptyFile()) saveAs(textArea);
        else save(textArea);
        TXTFile.getInstance().fileClosed();
        textArea.setText(null);
    }

    /* İlgili metinin içeriği ile dosya kaydedilir. */
    @Override
    public void save(TextArea textArea) {
        TXTFile.getInstance().saveFile(textArea.getText());
    }

    /* İlgili metinin içeriği ile dosya farklı kaydedilir. */
    @Override
    public void saveAs(TextArea textArea) {
        TXTFile.getInstance().saveAs(textArea.getText());
    }

    @Override
    public void undo(TextArea textArea, ECareTaker careTaker) {
        /* careTaker.undo() ile originator bir önceki state'e set edildi.*/
        careTaker.undo();
        /* Sonrasında textArea'ya originator'da tutulan state (bir önceki state) bastırıldı.*/
        /* İlk getstate EMemento döndürür. Sonraki getState String döndürür (Memento.getState())*/
        textArea.setText(careTaker.getState().getState());
    }


    /* İlgili textArea'daki aranan kelim kaç adet var? Find metodu ile bu hesabı sağlayan yapılara ilgili
    * değerler gönderilir, yapılar oluştrulur.*/
    @Override
    public int find(TextArea textArea,String searchString) {

        /* Eğer textArea boş ise, arama kısmı boş ise, text kısmı null ise 0 değeri dönsün.*/
        if(textArea.getText().isEmpty() || searchString.isEmpty() ||textArea.getText() == null) return 0;

        /* Hesaplama için FindWithPattern constructurona textArea gönderilir. Obje üretilir.*/
        FindWithIterator findWithPattern = new FindWithIterator(textArea);

        /* Bu objee üzerindeki findCount metodu hesaplamayı yapar. Değer döndürülür. Aranan metin gönderilmelidir.*/
        return findWithPattern.findCount(searchString);

    }
}


