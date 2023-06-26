package com.ayrtonmonier.challenge.service;

import java.io.IOException;
import java.util.List;

import com.ayrtonmonier.challenge.entities.Person;

public interface JsonDataLoaderService {
    List<Person> loadPeopleFromJSON() throws IOException;
}
