package com.example.projectcode.SINGLETON;

import com.example.projectcode.Demo;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.stage.FileChooser;

import java.io.*;

/* Bu kısım Singleton örneği oluşturur. Tek bir file varlığı bütün işlemler için yeterli olur.Yapısal olarak file işlemleri
* sadece 1 file üzerinden olması gerektiği için en uygun creational yapının singleton oldugunu dusunduk*/
public class TXTFile {
    /* SINGLETON yapısını sağlamak için TXTFile field ı oluşturmalıyız. Singleton yapısında constructor private olması
    * gerektiği için ve bu yapının singleton olması gerektiğinden txtFile field ı getInstance() metdonda tanımlanır*/
    private static TXTFile txtFile;
    private static File file; //Seçtiğimiz dosya File olarak saklanır
    private static String fileCurrentContent; //dosyanın anlık içeriğini saklar kontrol kısımlarında kullanıldı


    /* FileChooser yapısı ilgili button a tıklandığında GUI kısmında eklenti seçme yapısının açılmasını sağlar*/
    private static final FileChooser fileChooser = new FileChooser();

    /* Dosya seçiciye all file veya .txt uzantılı yapılar seçeneklerini ekler.*/
    static{
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("All files","*.*")
        );
    }


    //SINGLETON da private constructor olması gerekli
    private TXTFile(){

    }

    /* TXT dosyası null ise yeni bir TXTfile üretilir. null değilse önceki TXTFile instance i dondurulur*/
    public static TXTFile getInstance(){
        if(txtFile == null){
            txtFile = new TXTFile();
        }

        return txtFile;

    }

    /* File objesi null ise yeni file seçtirilir. Varsa o dosya döndürülür.*/
    public File getFile() {
        if(file == null){
            chooseFile();
        }
        return file;
    }


    /* İlgili bosya boşsa true, değilse false döner.*/
    public boolean isEmptyFile(){
        if(file == null){
            return true;
        }
        return false;
    }

    /* Dosya objesi null olarak atanır. Dosya artık kapanmıştır. (Dosya kapatıldıktan sonra kullanıldı)*/
    public void fileClosed(){
        file = null;
    }


    public void chooseFile(){
            /* Dosya seçme işlemi yapılır. Seçilen dosya file'a atanır. */
            file = null;
            File selectedFile = fileChooser.showOpenDialog(Demo.globalStage);
            file = selectedFile;
            /* KULLANICI HERHANGİ BİR DOSYA SEÇMEMİŞSE HATA GÖSTERİLİR. YA DA SECILEN DOSYA UZANTISI IZIN VERILENLERDEN DEGILSE */
            if(selectedFile == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.show();
                alert.setTitle("SELECT ONLY TXT FILES");
                alert.setContentText("SELECT ONLY TXT FILES!");
            }

    }
    /* Dosya okuma işlemi yapılır.*/
    public String readFile(){
        /* belgeİçeriği için sınıf tanımlanır.*/
        StringBuilder documentContent =new StringBuilder();

        /* Eğer dosya varsa...*/
        if(file !=null){
            /* Dosya okunmaya çalışılır.*/
            try {
                FileReader fileReader = new FileReader(file);


                int value ;
                /* Dosyanın sonuna gelene kadar okuma yapılır. Okunan değerler belgeİçeriği değişkenine eklenir.*/
                while((value = fileReader.read() )!= -1){
                    documentContent.append((char)value);    //file içerisinde bir variable a da atanabilir
                }
                /* Dosyanın içeriği, belgeİçeriği'nin dönüştürülmesi ile elde edilir. */
                fileCurrentContent = String.valueOf(documentContent.toString().toCharArray());

                /* EXCEPTION durumunda bu blok çalışır.*/
            } catch (IOException |NullPointerException e){
                e.printStackTrace();
            }


        }
        /* Dosya yoksa boş bir String döner.*/
        return documentContent.toString();
    }

    /* Save File ile notePad'daki içerik alındı.*/
    public void saveFile(String content){
        /* Dosya varsa, ve içeriği mevcut içeriğe eşit değilse işlemler devam eder.*/
        if(file !=null && ! fileCurrentContent.equals(content)){
            /* Dosyaya içerikler yazılır. EXCEPTION kontrol edilir.*/
            try {
                FileWriter writer = new FileWriter(getFile());
                writer.flush();
                writer.write(content);
                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* Dosyanın içeriği textArea'dan gelir.  */
    public void saveAs(String content){
        try {
            /* Dosya seçme ekranı gösterilir.*/
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("SAVE FILE");

            /* Sadece metin belgelerine izin verilir. */
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Text Documents","*.txt*"));

            /* Dosya seçilir. */
            file = fileChooser.showSaveDialog(Demo.globalStage);

            /* İlgili dosya .txt içermiyorsa EXCEPTION fırlatılır.*/
            if(!file.getName().contains(".txt")){
                throw new NullPointerException();
            }
            /* Dosyaya içerik kaydedilir. */

            FileWriter writer = new FileWriter(file);
            writer.flush();
            writer.write(content);
            writer.close();

            System.out.println(file);

            /* EXCEPTION durumunda hata mesajı bastırılır.*/
        }catch (NullPointerException | IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
            alert.setTitle("SELECT ONLY TXT FILES");
            alert.setContentText("SELECT ONLY TXT FILES!");
        }
    }




}
