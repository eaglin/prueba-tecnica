package com.mvabal.prueba_tecnica.spaceships.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mvabal.prueba_tecnica.shared.domain.PaginationDto;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShipRepository;

@Service
public class FindSpaceShipByName {

    @Autowired
    @Qualifier("h2SpaceShipRepository")
    private SpaceShipRepository repository;

    public List<SpaceShip> findByName(String name, PaginationDto pagination) {
        return repository.findByName(name);
    }
}
