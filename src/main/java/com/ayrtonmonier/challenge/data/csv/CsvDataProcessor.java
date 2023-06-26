package com.ayrtonmonier.challenge.data.csv;

import java.util.List;

import com.ayrtonmonier.challenge.entities.Person;


public interface CsvDataProcessor {
    List<Person> processCsvData(List<String[]> csvData);
}

