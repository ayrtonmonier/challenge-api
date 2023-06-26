package com.ayrtonmonier.challenge.data.json.impl;


import java.lang.reflect.Type;
import java.util.List;

import com.ayrtonmonier.challenge.entities.Birthday;
import com.ayrtonmonier.challenge.entities.Coordinates;
import com.ayrtonmonier.challenge.entities.Location;
import com.ayrtonmonier.challenge.entities.Name;
import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.entities.Picture;
import com.ayrtonmonier.challenge.entities.Registered;
import com.ayrtonmonier.challenge.entities.Timezone;
import com.ayrtonmonier.challenge.utils.PersonUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class PersonDeserializer implements JsonDeserializer<Person> {

    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject node = json.getAsJsonObject();

        // Verificar se existe o campo de nacionalidade
        String nationality = node.has("nationality") ? node.get("nationality").getAsString() : "BR";


        
        List<String> phone = PersonUtils.phoneNumberE164(node.get("phone").getAsString(), nationality);
        List<String> cell  = PersonUtils.phoneNumberE164(node.get("cell").getAsString(), nationality);

        // Alterar o valor do campo gender para F ou M em vez de female ou male
        String gender = node.get("gender").getAsString();
        gender = PersonUtils.formatGender(gender);

        // Restante do código
        String title = node.get("name").getAsJsonObject().get("title").getAsString();
        String first = node.get("name").getAsJsonObject().get("first").getAsString();
        String last = node.get("name").getAsJsonObject().get("last").getAsString();
        String street = node.get("location").getAsJsonObject().get("street").getAsString();
        String city = node.get("location").getAsJsonObject().get("city").getAsString();
        String state = node.get("location").getAsJsonObject().get("state").getAsString();
        int postcode = node.get("location").getAsJsonObject().get("postcode").getAsInt();
        String latitude = node.get("location").getAsJsonObject().get("coordinates").getAsJsonObject().get("latitude").getAsString();
        String longitude = node.get("location").getAsJsonObject().get("coordinates").getAsJsonObject().get("longitude").getAsString();
        String timezoneOffset = node.get("location").getAsJsonObject().get("timezone").getAsJsonObject().get("offset").getAsString();
        String timezoneDescription = node.get("location").getAsJsonObject().get("timezone").getAsJsonObject().get("description").getAsString();
        String email = node.get("email").getAsString();
        String large = node.get("picture").getAsJsonObject().get("large").getAsString();
        String medium = node.get("picture").getAsJsonObject().get("medium").getAsString();
        String thumbnail = node.get("picture").getAsJsonObject().get("thumbnail").getAsString();

        Picture picture = new Picture(large, medium, thumbnail);
        Coordinates coordinates = new Coordinates(latitude, longitude);
        Timezone timezone = new Timezone(timezoneOffset, timezoneDescription);
        Location location = new Location(PersonUtils.classifyRegionLocation(state), street, city, state, postcode, coordinates, timezone);

        String dob = node.get("dob").getAsJsonObject().get("date").getAsString();
        String registered = node.get("registered").getAsJsonObject().get("date").getAsString();

        // Definir type
        String type = PersonUtils.classifyType(location);
        return new Person(type, gender, new Name(title, first, last), location, email, new Birthday(dob), new Registered(registered), phone, cell, nationality, picture);
    }
}
