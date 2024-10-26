package com.mvabal.prueba_tecnica.spaceships.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceShipRepository extends JpaRepository<SpaceShip, Long> {

    List<SpaceShip> findByName(String name);

}