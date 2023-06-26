package com.ayrtonmonier.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ayrtonmonier.challenge.dto.PaginationDTO;
import com.ayrtonmonier.challenge.entities.Person;
import com.ayrtonmonier.challenge.repositories.PersonRepository;
import com.ayrtonmonier.challenge.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PaginationDTO<Person> getEligiblePersons(String region, String type, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Person> personPage = personRepository.findEligiblePersons(type, region, pageRequest);

        PaginationDTO<Person> paginationDTO = new PaginationDTO<>();
        paginationDTO.setUsers(personPage.getContent());
        paginationDTO.setPageNumber(personPage.getNumber() + 1);
        paginationDTO.setPageSize(personPage.getSize());
        paginationDTO.setTotalCount(personPage.getTotalElements());

        return paginationDTO;
    }


    @Override
    public PaginationDTO<Person> findAllPersons(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Person> personPage = personRepository.findAllPersons(pageRequest);

        PaginationDTO<Person> paginationDTO = new PaginationDTO<>();
        paginationDTO.setUsers(personPage.getContent());
        paginationDTO.setPageNumber(personPage.getNumber() + 1);
        paginationDTO.setPageSize(personPage.getSize());
        paginationDTO.setTotalCount(personPage.getTotalElements());

        return paginationDTO;
    }
}
