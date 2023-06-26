package com.ayrtonmonier.challenge.data.json;

import java.util.List;

import com.ayrtonmonier.challenge.entities.Person;


public interface JsonDataProcessor {
    List<Person> processJsonData(String jsonData);
}

