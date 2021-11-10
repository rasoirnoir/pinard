package fr.william.vin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.william.vin.model.Vin;

@Repository
public interface VinRepository extends JpaRepository<Vin, Integer> {

}