package com.ayrtonmonier.challenge.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private static final String BUNDLE_NAME = "com.ayrtonmonier.challenge.i18n.messages";
    private static final ResourceBundle RESOURCE_BUNDLE;

    static {
        // Define o idioma padrão como Português
        // Locale defaultLocale = new Locale("pt");
        // Obtém o idioma do sistema
        Locale systemLocale = Locale.getDefault();
        // Carrega o arquivo de recursos correspondente ao idioma do sistema
        RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, systemLocale);
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (Exception e) {
            return '!' + key + '!';
        }
    }
}


