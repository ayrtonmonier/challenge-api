package com.ayrtonmonier.challenge.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ayrtonmonier.challenge.entities.Location;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;


public class PersonUtils {
	
    private static final ResourceBundle MESSAGES;

    static {
        // Obtém o idioma do sistema
        Locale systemLocale = Locale.getDefault();
        // Carrega o arquivo de recursos correspondente ao idioma do sistema
        MESSAGES = ResourceBundle.getBundle("com.ayrtonmonier.challenge.i18n.messages", systemLocale);
    }
	
    public static String classifyRegionLocation(String state) {
        // Região Norte
        if (state.equalsIgnoreCase("acre") || state.equalsIgnoreCase("amapá") || state.equalsIgnoreCase("amazonas") ||
                state.equalsIgnoreCase("pará") || state.equalsIgnoreCase("rondônia") || state.equalsIgnoreCase("roraima") ||
                state.equalsIgnoreCase("tocantins"))
            return "Norte";

        // Região Nordeste
        if (state.equalsIgnoreCase("bahia") || state.equalsIgnoreCase("ceará") || state.equalsIgnoreCase("maranhão") ||
                state.equalsIgnoreCase("paraíba") || state.equalsIgnoreCase("pernambuco") || state.equalsIgnoreCase("piauí") ||
                state.equalsIgnoreCase("rio grande do norte") || state.equalsIgnoreCase("sergipe") ||
                state.equalsIgnoreCase("alagoas"))
            return "Nordeste";

        // Região Centro-Oeste
        if (state.equalsIgnoreCase("distrito federal") || state.equalsIgnoreCase("goiás") ||
                state.equalsIgnoreCase("mato grosso") || state.equalsIgnoreCase("mato grosso do sul"))
            return "Centro-Oeste";

        // Região Sudeste
        if (state.equalsIgnoreCase("espírito santo") || state.equalsIgnoreCase("minas gerais") ||
                state.equalsIgnoreCase("rio de janeiro") || state.equalsIgnoreCase("são paulo"))
            return "Sudeste";

        // Região Sul
        if (state.equalsIgnoreCase("paraná") || state.equalsIgnoreCase("rio grande do sul") ||
                state.equalsIgnoreCase("santa catarina"))
            return "Sul";

        // Caso o estado não esteja mapeado, retorna "Desconhecida"
        return "Desconhecida";
    }

   
    public static String classifyType(Location location) {
        return GeolocationClassifier.classifyType(location, MESSAGES);
    }


    
    public static List<String> phoneNumberE164(String phoneNumber, String defaultRegion) {
        List<String> transformedNumbers = new ArrayList<>();
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        try {
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(phoneNumber, defaultRegion);

            if (phoneNumberUtil.isValidNumber(parsedNumber)) {
                transformedNumbers.add(phoneNumberUtil.format(parsedNumber, PhoneNumberUtil.PhoneNumberFormat.E164));
            }
        } catch (NumberParseException e) {
            // Tratar a exceção de parsing do número de telefone
        }

        return transformedNumbers;
    }
    
    public static String formatGender(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            return "F";
        } else if (gender.equalsIgnoreCase("male")) {
            return "M";
        } else {
            // Outros casos podem ser tratados aqui, como gênero não especificado
            return "";
        }
    }
}
