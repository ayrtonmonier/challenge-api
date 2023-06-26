package com.ayrtonmonier.challenge.data.csv;

import java.io.IOException;
import java.util.List;

public interface CsvDataReader {
    List<String[]> readCsvData() throws IOException;
}
