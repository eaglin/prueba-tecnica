package com.mvabal.prueba_tecnica.spaceships.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShipRepository;

@Service
public class FindSpaceShipById {

    @Autowired
    @Qualifier("h2SpaceShipRepository")
    private SpaceShipRepository repository;

    public Optional<SpaceShip> execute(Long id) {
        return repository.findById(id);
    }
}
