package com.ayrtonmonier.challenge.service;

import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.dto.PaginationDTO;

public interface PersonService {
    PaginationDTO<Person> getEligiblePersons(String region, String type, int page, int size);
    PaginationDTO<Person> findAllPersons(int page, int size);
}
