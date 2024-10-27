package com.mvabal.prueba_tecnica.spaceships.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mvabal.prueba_tecnica.controller.RequestSpaceShipDto;
import com.mvabal.prueba_tecnica.shared.domain.PaginationDto;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShipRepository;

@Service
public class SpaceShipService {

    @Autowired
    @Qualifier("h2SpaceShipRepository")
    private SpaceShipRepository repository;

    @Cacheable(value = "spaceships", key = "#name")
    public List<SpaceShip> findByName(String name, PaginationDto pagination) {

        // Simulate long process
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        final Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getLimit());
        List<SpaceShip> spaceshiptList = repository.findByNameContainingIgnoreCase(name, pageable);
        return spaceshiptList;

    }

    public Optional<SpaceShip> findById(Long id) {

        return repository.findById(id);
    }

    @CacheEvict(value = "spaceships", allEntries = true)
    public void save(SpaceShip entity) {
        // TODO Auto-generated method stub
        repository.save(entity);
    }

}
