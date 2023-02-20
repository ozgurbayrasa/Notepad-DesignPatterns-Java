package com.example.projectcode.ITERATOR;

import javafx.scene.control.TextArea;

import java.util.Arrays;

/* Bu sınıfta metinler otomatik olarak constructor'da regular expression ile tanımlanan şekilde ayrılır. (Iterator
* kelime kelime olacak.) */
public class FindWithIterator {
    private StringRepository wordsFromTextArea;


    /* Regular Expression ile split sonucunda array oluşur. String Repository consturctorı için Liste yapısı gerekli
    * olduğu için ilgili Array, List yapısında String Repository'ye gönderilir. Bu noktada
    * Array'de tanımlnmış olan asList metodu kullanılmıştır.*/
    public FindWithIterator(TextArea textArea) {
        this.wordsFromTextArea = new StringRepository(Arrays.asList(textArea.getText().split("[!'^+%&/()=?_£#$½{}|*-+@`,;.:¨<> \n\t]+")));

    }

    /* String olarak gelen bir kelime, iterator yardımıyla kelimelerin regular expression ile bölünmüş listesi kelime
    kelime dolaşılır. İlgili iterator'un sonraki değeri olduğu sürece çalışan for döngüsünde, aranan kelime yakalandığı
    * zaman count değeri arttırılır. Böylece eşleşen kelime sayısı bulunur.*/
    public int findCount(String word){
        int count=0 ;
        for(Iterator iterator = wordsFromTextArea.getIterator(); iterator.hasNext();){
            if(iterator.next().equals(word)) count++;
        }
        return count;
    }
}

