package com.ayrtonmonier.challenge.data.csv;

import java.io.IOException;
import java.util.List;

import com.ayrtonmonier.challenge.entities.Person;

public interface CsvDataLoad {
    List<Person> loadPeopleFromCSV() throws IOException;
}
