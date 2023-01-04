package com.example.coursspringdata.repository;

import com.example.coursspringdata.entity.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Integer> {

    public List<Personne> findPersonnesByNom(String nom);

    public List<Personne> findPersonnesByNomContainingOrPrenomContaining(String nom, String prenom);
}
