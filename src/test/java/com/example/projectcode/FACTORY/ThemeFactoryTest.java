package com.example.projectcode.FACTORY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeFactoryTest {

    //bütün testler theme butonlarının doğru seçilip seçilmediğini tespit etmek için yazıldı.

    //Light buton doğru seçiliyor mu
    @Test
    void getThemeLightTest() {
        Object returnObject = ThemeFactory.getTheme("lightThemeButton");
        String returnObjectName = returnObject.getClass().getSimpleName();
        LightTheme lightTheme = new LightTheme();
        String expectedObjectName = lightTheme.getClass().getSimpleName();
        assertEquals(returnObjectName, expectedObjectName);
    }


    //Light button doğru seçiliyor mu
    //Bunda dogru secilmemis olacak bize ITheme döndürecek olan fonskiyona baska bir string gönderiyoruz
    @Test
    void getThemeLightTest2() {
        Object returnObject = ThemeFactory.getTheme("try try light try try");
        String returnObjectName = returnObject.getClass().getSimpleName();
        LightTheme lightTheme = new LightTheme();
        String expectedObjectName = lightTheme.getClass().getSimpleName();
        assertEquals(returnObjectName, expectedObjectName);
    }

    //Dark button doğru mu calısıyor
    @Test
    void getThemeDarkTest() {
        Object returnObject = ThemeFactory.getTheme("DarkThemeButton");
        String returnObjectName = returnObject.getClass().getSimpleName();
        DarkTheme darkTheme = new DarkTheme();
        String expectedObjectName = darkTheme.getClass().getSimpleName();
        assertEquals(returnObjectName, expectedObjectName);
    }
}