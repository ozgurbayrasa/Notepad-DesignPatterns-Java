package com.example.projectcode.MEMENTO;
/* IOriginator interface'ine sahip olacak olan sınıflar, EMemento döndüren save metoduyla, değer döndürmeyen ancak
*  EMemento değeri alan bir restore metodu bulundurmaldır.*/
public interface IOriginator {
    EMemento save();
    void restore(EMemento memento);
}
