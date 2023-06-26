package com.ayrtonmonier.challenge;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.repositories.PersonRepository;
import com.ayrtonmonier.challenge.service.CsvDataLoaderService;

@Component
public class CsvDataLoaderRunner {

    private final PersonRepository personRepository;
    private final CsvDataLoaderService csvDataLoaderService;

    public CsvDataLoaderRunner(PersonRepository personRepository, CsvDataLoaderService csvDataLoaderService) {
        this.personRepository = personRepository;
        this.csvDataLoaderService = csvDataLoaderService;
    }


    public void loadDataFromCSV() {
        try {
        	
            List<Person> peoples = csvDataLoaderService.loadPeopleFromCSV();
            personRepository.saveAll(peoples);
            System.out.println("Dados do CSV carregados com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados do CSV.");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
    }
}
