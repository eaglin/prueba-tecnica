package com.mvabal.prueba_tecnica.spaceships.infraestructure;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShipRepository;

@Repository
public interface H2SpaceShipRepository extends SpaceShipRepository {

    List<SpaceShip> findByName(String name);
}
