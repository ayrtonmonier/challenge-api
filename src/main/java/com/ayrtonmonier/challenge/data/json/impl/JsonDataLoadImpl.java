package com.ayrtonmonier.challenge.data.json.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.data.json.JsonDataLoad;
import com.ayrtonmonier.challenge.data.json.JsonDataProcessor;
import com.ayrtonmonier.challenge.data.json.JsonDataReader;
import com.ayrtonmonier.challenge.entities.Person;

@Component
public class JsonDataLoadImpl implements JsonDataLoad {

    private final JsonDataReader jsonDataReader;
    private final JsonDataProcessor jsonDataProcessor;

    public JsonDataLoadImpl(JsonDataReader jsonDataReader, JsonDataProcessor jsonDataProcessor) {
        this.jsonDataReader = jsonDataReader;
        this.jsonDataProcessor = jsonDataProcessor;
    }

    @Override
    public List<Person> loadPeopleFromJSON() throws IOException {
        String jsonData = jsonDataReader.readJsonData();
        List<Person> people = jsonDataProcessor.processJsonData(jsonData);
        return people;
    }
}


