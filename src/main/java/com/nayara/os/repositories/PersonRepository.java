package com.nayara.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nayara.os.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT obj FROM person obj WHERE obj.cpf =:cpf")
	Person findByCPF(@Param("cpf") String cpf);
}
