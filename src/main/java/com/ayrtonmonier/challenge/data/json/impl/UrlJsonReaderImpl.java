package com.ayrtonmonier.challenge.data.json.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.data.json.JsonDataReader;

@Component
public class UrlJsonReaderImpl implements JsonDataReader {

    private final String jsonUrl;

    @Autowired
    public UrlJsonReaderImpl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }
    
    @Override
    public String readJsonData() throws IOException {
  	  URL url = new URL(jsonUrl);
      BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
      StringBuilder jsonString = new StringBuilder();

      String line;
      while ((line = reader.readLine()) != null) {
          jsonString.append(line);
          
      }
      reader.close();
      return jsonString.toString();
  }

}

