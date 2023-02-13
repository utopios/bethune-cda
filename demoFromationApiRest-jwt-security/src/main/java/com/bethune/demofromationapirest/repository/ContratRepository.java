package com.bethune.demofromationapirest.repository;


import com.bethune.demofromationapirest.model.Contrat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContratRepository extends CrudRepository<Contrat, Integer> {


}
