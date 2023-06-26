package com.ayrtonmonier.challenge.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayrtonmonier.challenge.service.CsvDataLoaderService;
import com.ayrtonmonier.challenge.data.csv.CsvDataLoad;
import com.ayrtonmonier.challenge.entities.Person;

@Service
public class CsvDataLoaderServiceImpl implements CsvDataLoaderService {

    private final CsvDataLoad csvDataLoad;

    public CsvDataLoaderServiceImpl(CsvDataLoad csvDataLoad) {
        this.csvDataLoad = csvDataLoad;
    }

    @Override
    public List<Person> loadPeopleFromCSV() throws IOException {
        return csvDataLoad.loadPeopleFromCSV();
    }

}
