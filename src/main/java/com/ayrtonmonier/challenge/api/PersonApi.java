package com.ayrtonmonier.challenge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayrtonmonier.challenge.dto.PaginationDTO;
import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.service.PersonService;

@RestController
public class PersonApi {

    private final PersonService personService;

    @Autowired
    public PersonApi(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/persons")
    public ResponseEntity<PaginationDTO<Person>> getPersons(
            @RequestParam(value = "region", required = false) String region,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        PaginationDTO<Person> paginationResult;

        if (region != null && type != null) {
            paginationResult = personService.getEligiblePersons(region, type, page, size);
        } else {
            paginationResult = personService.findAllPersons(page, size);
        }

        return ResponseEntity.ok(paginationResult);
    }
}