package com.example.projectcode.FACTORY;

/* Tıklanılan butonun ID'sine göre yeni bir tema class'ı döndürülür. Böylece Factory patterni sağlanır.
* NotePad üzerinde bulunan Dark ve Light butonlarına tıklandığında ilgili butonun ID'sine göre tema
* değişir, o temayla ilgili class döndürülür.  */

public class ThemeFactory {
    /* Buton ID'si lightThemeButton ise veya light kelimesini içeriyorsa light tema döndür. Yoksa dark tema döndür.*/
    public static ITheme getTheme(String clickedButtonId){
        if(clickedButtonId.equals("lightThemeButton") || clickedButtonId.contains("light")){
            return new LightTheme();
        }
        else {
            return new DarkTheme();
        }

    }
}




