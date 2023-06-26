package com.ayrtonmonier.challenge.data.csv.impl;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.data.csv.CsvDataProcessor;
import com.ayrtonmonier.challenge.entities.Birthday;
import com.ayrtonmonier.challenge.entities.Coordinates;
import com.ayrtonmonier.challenge.entities.Location;
import com.ayrtonmonier.challenge.entities.Name;
import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.entities.Picture;
import com.ayrtonmonier.challenge.entities.Registered;
import com.ayrtonmonier.challenge.entities.Timezone;
import com.ayrtonmonier.challenge.utils.PersonUtils;

@Component
public class CsvDataProcessorImpl implements CsvDataProcessor {

    @Override
    public List<Person> processCsvData(List<String[]> csvData) {
        List<Person> people = new ArrayList<>();
        for (String[] values : csvData) {
            try {
            	
                Person person = createPersonFromCsv(values);
                people.add(person);
            } catch (DateTimeParseException e) {
                System.out.println("Erro ao analisar a data/hora. Linha ignorada: " + String.join(",", values));
            } catch (Exception e) {
                System.out.println("Erro ao processar linha do CSV: " + String.join(",", values));
                System.out.println("Mensagem de erro: " + e.getMessage());
            }
        }
        return people;
    }

    private Person createPersonFromCsv(String[] values) throws DateTimeParseException {
        Person person = new Person();

        person.setNationality("BR");
        String gender = PersonUtils.formatGender(values[0]);
        String title = values[1];
        String firstName = values[2];
        String lastName = values[3];
        String street = values[4];
        String city = values[5];
        String state = values[6];
        int    postcode = Integer.parseInt(values[7]);
        String latitude = values[8];
        String longitude = values[9];
        String timezoneOffset = values[10];
        String timezoneDescription = values[11];
        String email = values[12];
        String dob = values[13];
        //String dob_age = values[14];
        String reg = values[15];
        //String reg_age = values[16];
        List<String> phone = PersonUtils.phoneNumberE164(values[17], person.getNationality());
        List<String> cell  = PersonUtils.phoneNumberE164(values[18], person.getNationality());
        String largePicture = values[19];
        String mediumPicture = values[20];
        String thumbnailPicture = values[21];
        String region = PersonUtils.classifyRegionLocation(state);

        Coordinates coordinates = new Coordinates(latitude, longitude);
        Timezone timezone = new Timezone(timezoneOffset, timezoneDescription);
        Location location = new Location(region, street, city, state, postcode, coordinates, timezone);
        Birthday birthday = new Birthday(dob);
        Registered registered = new Registered(reg);
        String type = PersonUtils.classifyType(location);

        person.setGender(gender);
        person.setName(new Name(title, firstName, lastName));
        person.setLocation(location);
        person.setEmail(email);
        person.setBirthday(birthday);
        person.setRegistered(registered);
        person.setTelephoneNumbers(phone);
        person.setMobileNumbers(cell);
        person.setPicture(new Picture(largePicture, mediumPicture, thumbnailPicture));
        person.setType(type);

        return person;
    }
}
