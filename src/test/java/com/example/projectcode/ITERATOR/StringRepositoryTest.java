package com.example.projectcode.ITERATOR;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//StringRepository için yazılmış test classı
class StringRepositoryTest {
    List<String> stringList = new ArrayList<String>();
    StringRepository stringRepository;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    //Iterator kullanarak stringList içinde başka string olup olmadığını doğru mu donduruyor kontrol ederiz
    @Test
    void hasNextControl()
    {
        stringList.add("lalalla");
        stringList.add("lslslsl");
        stringRepository = new StringRepository(stringList);
        assertTrue(stringRepository.getIterator().hasNext());
    }


    //Iteratorda gösterilecek olan bir sonraki string doğru mu kontrol eder
    @Test
    void nextControl(){
        stringList.add("Word1");
        stringList.add("Word2");
        stringRepository = new StringRepository(stringList);
        assertEquals("Word1",  stringRepository.getIterator().next());
    }
    void getIterator() {
    }
}