package com.example.projectcode.MEMENTO;

import java.util.ArrayList;
/* EOriginator üzerinden ne hangi durumlarda kayıt yapılacağını, undo işleminin nasıl olacağını ECareTaker üzerinden
* görebiliriz. EMemento türünden elemanlar tutan bir liste ve bir originator sınıfından türemiş nesne tutulur.
* ECareTaker, kendisine gelen metine göre state'i history'e yani EMemento listesine kaydeder. Daha sonra ihtiyaç
* duyulursa undo ile bir önceki state döndürülür, ve en son state silinir.*/
public class ECareTaker {
    private EOriginator originator;
    /* history EMemento türünde bir ArrayList'tir bununla birlikte karakter karakter history tutabileceğiz.*/
    private ArrayList<EMemento> history = new ArrayList<>();
    public ECareTaker() {
        originator = new EOriginator();
    }
    public ECareTaker(String text) {
        originator = new EOriginator(text);
    }

    /* Metin null ise yeni state "", değilse gelen metin yeni state, originatorda tutulan eski state ile
    * yeni state farklı ise, yeni state memento listesine eklenir ve originator state'i yeni state ile güncellenir.*/
    public void textChanged(String text) {

        EMemento newState;
        if(text == null) {
            newState = new EMemento();
        }else {
            newState = new EMemento(text);
        }
        /* İlgili string değeri (Her karakter değiştiğinde buraya bir string gönderilir.) Mementoda tutulan
         * string'den farklı ise yeni state originator'da güncellenmelidir, eski state history'ye eklenmelidir.*/
        /* Old state Originator'un save metoduyla alındı.*/
        EMemento oldState = originator.save();
        if(oldState.getState().equals(newState.getState())){
            return;
        }

        history.add(oldState);
        /* restore metoduyle originatordaki Memento değeri yeniden atanır. Yeni state oraya atandı.*/
        originator.restore(newState);
    }
    public EMemento getState() {return this.originator.getState();}
    /* History'de zaten geçmiş stateler tutulmaktadır. Undo işlemi yapılmak istensin, ekranda AAB yazsın. Bu durumda
    * AAB origanitorda tutulurken history'deki son eleman ise AA olacak. Dolayısıyla historydeki son eleman
    * originator'a atandı (Originator bir adım gerideki değeri aldı.) Sonrasında ise histary'den AA değeri silindi.
    * AA'dan önce ne yazılmışsa (A) artık history'nin son elemanı o oldu. */
    public void undo() {
        int size = history.size() ;
        if(size == 0) {
            return ;
        }
        originator.restore(history.get(size - 1));
        history.remove(size - 1);
    }
}
