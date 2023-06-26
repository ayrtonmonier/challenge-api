package com.ayrtonmonier.challenge.data.csv.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.data.csv.CsvDataReader;

@Component
public class UrlCsvReaderImpl implements CsvDataReader {

    private final String csvUrl;

    @Autowired
    public UrlCsvReaderImpl(String csvUrl) {
        this.csvUrl = csvUrl;
    }

    @Override
    public List<String[]> readCsvData() throws IOException {
        URL url = new URL(csvUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<String[]> csvData = new ArrayList<>();

        try {
            for (CSVRecord csvRecord : csvParser) {
                String[] values = extractValues(csvRecord);
                csvData.add(values);
            }
        } catch (Exception e) {
            throw new IOException("Erro ao processar o CSV: " + e.getMessage(), e);
        } finally {
            csvParser.close();
            reader.close();
        }

        return csvData;
    }

    private String[] extractValues(CSVRecord csvRecord) {
        String[] values = new String[csvRecord.size()];
        for (int i = 0; i < csvRecord.size(); i++) {
            values[i] = csvRecord.get(i);
        }
        return values;
    }
}

