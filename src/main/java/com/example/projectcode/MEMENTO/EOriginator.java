package com.example.projectcode.MEMENTO;
/* Originator, IOriginator interface'ini implemente eder, save ve restore metodlarını bulundurmalıdır. */
/* EMemento sınıfına restore ile veri kaydeder. Aynı zamanda EMemento sınıfına ait veri tutar. Kayıtlar */
/* bu sınıf üzerinden geri döndürülebilir veya EMemento değiştirilebilir. */
public class EOriginator implements IOriginator {
    /* EOriginator üzerinde EMemonte türünde stateler vardır.*/
    private EMemento state;
    /* Constructorlar basit olarak tanımlanmıştır. String değer varsa o değeri alan EMemento, yoksa parametresiz
    * constructor ile oluşan EMemento oluşturulur ve bu sınıfın field'ına tanımlanır.*/
    public EOriginator(String state) {
        this.state = new EMemento(state);
    }
    public EOriginator(){
        this.state = new EMemento();
    }

    /* getState ile EMemento türündeki state döndürülür.*/
    public EMemento getState() {
        return this.state;
    }
    /* Save metoduyla EMemento yine benzer şekilde EMemento türündeki state döndürülür.
    * getState'e göre daha anlamlı bir isimdir ve CareTaker kullanmaktadır.*/
    @Override
    public EMemento save() {
        return state;
    }

    /* Restore ile Yeni bir EMemento EOriginator field'ında tanımlanır.*/
    @Override
    public void restore(EMemento memento) {
        this.state = memento;
    }
}
