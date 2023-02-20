package com.example.projectcode.FACTORY;

/* ITheme interface'ini implemenete eden LightTheme, Açık Tema oluşturur. Açık tema için oluşturulan CSS
 * dosyasının kaynağı ile arayüz değiştirilir. */
public class LightTheme implements ITheme{
    /* Açık Tema için oluşturulan CSS kayak dosyasıyle arayüz değiştirildi.*/
    @Override
    public String createTheme() {
        return getClass().getResource("/com/example/projectcode/CSS/lightThemeCss.css").toExternalForm();
    }
}
