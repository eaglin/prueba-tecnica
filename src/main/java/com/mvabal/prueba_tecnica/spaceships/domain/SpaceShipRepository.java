package com.mvabal.prueba_tecnica.spaceships.domain;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceShipRepository extends JpaRepository<SpaceShip, Long> {

    List<SpaceShip> findByNameContainingIgnoreCase(String name, Pageable pagination);

}