package com.ayrtonmonier.challenge.data.csv.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.data.csv.CsvDataLoad;
import com.ayrtonmonier.challenge.data.csv.CsvDataProcessor;
import com.ayrtonmonier.challenge.data.csv.CsvDataReader;
import com.ayrtonmonier.challenge.entities.Person;

@Component
public class CsvDataLoadImpl implements CsvDataLoad {

    private final CsvDataReader csvDataReader;
    private final CsvDataProcessor csvDataProcessor;

    public CsvDataLoadImpl(CsvDataReader csvDataReader, CsvDataProcessor csvDataProcessor) {
        this.csvDataReader = csvDataReader;
        this.csvDataProcessor = csvDataProcessor;
    }

    @Override
    public List<Person> loadPeopleFromCSV() throws IOException {
        List<String[]> csvData = csvDataReader.readCsvData();
        List<Person> people = csvDataProcessor.processCsvData(csvData);
        return people;
    }
}


