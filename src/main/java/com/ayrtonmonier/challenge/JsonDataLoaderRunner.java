package com.ayrtonmonier.challenge;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.repositories.PersonRepository;
import com.ayrtonmonier.challenge.service.JsonDataLoaderService;

@Component
public class JsonDataLoaderRunner {

    private final PersonRepository personRepository;
    private final JsonDataLoaderService jsonDataLoaderService;

    public JsonDataLoaderRunner(PersonRepository personRepository, JsonDataLoaderService csvDataLoaderService) {
        this.personRepository = personRepository;
        this.jsonDataLoaderService = csvDataLoaderService;
    }

    public void loadDataFromJSON() {
        try {
        	        	
            List<Person> peoples = jsonDataLoaderService.loadPeopleFromJSON();
            personRepository.saveAll(peoples);
            
            System.out.println("Dados do JSON carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados do JSON.");
            System.out.println("Mensagem de erro: " + e.getMessage());
        }
    }
}
