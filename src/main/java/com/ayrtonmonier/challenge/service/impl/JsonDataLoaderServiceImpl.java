package com.ayrtonmonier.challenge.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayrtonmonier.challenge.data.json.JsonDataLoad;
import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.service.JsonDataLoaderService;

@Service
public class JsonDataLoaderServiceImpl implements JsonDataLoaderService {

    private final JsonDataLoad jsonDataLoad;
    
    public JsonDataLoaderServiceImpl(JsonDataLoad jsonDataLoad) {
        this.jsonDataLoad = jsonDataLoad;
    }

    @Override
    public List<Person> loadPeopleFromJSON() throws IOException {
        return jsonDataLoad.loadPeopleFromJSON();
    }
}
