package com.example.projectcode.MEMENTO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//ECareTake sınıfı için oluşturulan Test
public class ECareTakerTest {

    ECareTaker careTaker;
    @BeforeEach
    void setUp() {
        //test her başlatıldığında yeni bir caretaker nesnesi oluşturulur.
        careTaker= new ECareTaker();
    }

    @AfterEach
    void tearDown() {
    }


    //yeni bir state ekleyip caretaker o sırada doğru statede mi kontrol ederiz.
    @Test
    void dogruStateMi() {
        careTaker.textChanged("Deneme");
        EMemento memento = careTaker.getState();
        System.out.println(memento.toString());

        //bir state ekledikten sonra getState den null dönmemesi gerekiyor
        assertNotEquals(memento,null);

        //getState den yeni eklediğimiz statein dönmesi gerekir.
        assertEquals(memento.getState(),"Deneme");
    }

    //caretakerin texti değiştirildiğinde doğru state mi döndürülüyor kontrol edilir
    @Test
    void nullTextControlChange() {
        careTaker.textChanged(null);
        EMemento memento = careTaker.getState();
        assertEquals("",memento.getState());
    }

    @Test
    void textChanged() {

    }

    @Test
    void getState() {
    }

    //undo fonksiyonuyla historyden bir önceki state dönüldüğünde doğru state mi geldik kontrol eder
    @Test
    void undo() {
        careTaker.textChanged("AAAA");
        careTaker.textChanged("AAAAB");
        careTaker.undo();
        EMemento memento = careTaker.getState();
        assertEquals("AAAA", memento.getState());
    }
}