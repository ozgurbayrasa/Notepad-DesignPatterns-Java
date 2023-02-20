package com.example.projectcode.FACTORY;

/* ITheme interface'ini implemenete eden DarkTheme, Koyu Tema oluşturur. Koyu tema için oluşturulan CSS
* dosyasının kaynağı ile arayüz değiştirilir. */
public class DarkTheme implements ITheme{
    /* Koyu Tema için oluşturulan CSS kayak dosyasıyle arayüz değiştirildi.*/
    @Override
    public String createTheme() {
        return getClass().getResource("/com/example/projectcode/CSS/darkThemeCss.css").toExternalForm();
    }
}
