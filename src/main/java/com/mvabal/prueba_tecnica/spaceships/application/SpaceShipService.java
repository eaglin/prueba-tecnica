package com.mvabal.prueba_tecnica.spaceships.application;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public SpaceShip save(SpaceShip entity) {
        // TODO Auto-generated method stub
        return repository.save(entity);
    }

}
