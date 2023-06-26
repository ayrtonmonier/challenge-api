package com.ayrtonmonier.challenge.data.json.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.data.json.JsonDataProcessor;
import com.ayrtonmonier.challenge.entities.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonStreamParser;

@Component
public class JsonDataProcessorImpl implements JsonDataProcessor {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Person.class, new PersonDeserializer())
            .create();

    @Override
    public List<Person> processJsonData(String jsonData) {
        List<Person> personList = new ArrayList<>();

        JsonStreamParser parser = new JsonStreamParser(jsonData);
        if (parser.hasNext()) {
            JsonElement rootElement = parser.next();
            if (rootElement.isJsonObject()) {
                JsonArray resultsArray = rootElement.getAsJsonObject().getAsJsonArray("results");
                if (resultsArray != null) {
                    for (JsonElement resultElement : resultsArray) {
                        Person person = gson.fromJson(resultElement, Person.class);
                        personList.add(person);
                    }
                }
            }
        }

        return personList;
    }

    // Outros métodos relacionados à leitura e análise de dados JSON

}
