package com.ayrtonmonier.challenge.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayrtonmonier.challenge.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT p FROM Person p WHERE LOWER(p.type) = LOWER(:type) AND LOWER(p.location.region) = LOWER(:region)")
	Page<Person> findEligiblePersons(@Param("type") String type, @Param("region") String region, Pageable pageable);



    @Query("SELECT p FROM Person p")
    Page<Person> findAllPersons(Pageable pageable);

}
