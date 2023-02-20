package com.example.projectcode.MEMENTO;
/* Memento sınıfı IMemento interface'ini implemente eder.*/
/* String türünde state tutar. CareTaker history'sinde saklanacak değerler string olacaktır. */
/* Çünkü undo işlemini metinsel anlamda yapmak amaçlanmaktadır. */
public class EMemento implements IMemento {
    /* Metin türünde değerleri undo etmek istediğimiz için state String türündedir.*/
    private String state;
    public EMemento(String state) {
        this.state = state;
    }
    /* String gelmeden EMemento oluşursa boş string state'e atanır. */
    public EMemento() {
        this.state = "";
    }
    /* Memento'daki string state döndürülür.*/
    @Override
    public String getState() {
        return state;
    }
}
