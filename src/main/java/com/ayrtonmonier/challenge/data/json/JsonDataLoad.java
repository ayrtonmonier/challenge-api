package com.ayrtonmonier.challenge.data.json;

import java.io.IOException;
import java.util.List;

import com.ayrtonmonier.challenge.entities.Person;

public interface JsonDataLoad {
    List<Person> loadPeopleFromJSON() throws IOException;
}
