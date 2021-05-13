package com.nayara.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayara.os.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
