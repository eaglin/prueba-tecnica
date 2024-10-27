package com.mvabal.prueba_tecnica.spaceships.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;

import com.mvabal.prueba_tecnica.shared.domain.PaginationDto;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShipRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@ComponentScan(basePackages = "com.mvabal.prueba_tecnica.spaceships.application")
public class SpaceShipServiceIntegrationTest {

    @Autowired
    @Qualifier("h2SpaceShipRepository")
    private SpaceShipRepository repository;

    @Autowired
    private SpaceShipService service;

    @BeforeEach
    void restart() {
        System.err.println("setUp");
        repository.deleteAll();
    }

    @Test
    void testFindById() {
        SpaceShip spaceShip = new SpaceShip(null, "Falcon", "Starwars");
        SpaceShip savedShip = repository.save(spaceShip);
        repository.flush();
        Optional<SpaceShip> result = service.findById(savedShip.getId());

        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), spaceShip.getName());
        assertEquals(savedShip.getId(), result.get().getId());
    }

    @Test
    void testFindByName() {
        SpaceShip spaceShip1 = new SpaceShip();
        spaceShip1.setName("Falcon");
        SpaceShip spaceShip2 = new SpaceShip();
        spaceShip2.setName("Eagle");

        repository.save(spaceShip1);
        repository.save(spaceShip2);

        PaginationDto pagination = new PaginationDto();

        List<SpaceShip> result = service.findByName("a", pagination);

        assertEquals(2, result.size());
        assertEquals("Falcon", result.get(0).getName());
        assertEquals("Eagle", result.get(1).getName());
    }

    @Test
    void testSave() {
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setId(1L);

        service.save(spaceShip);

        Optional<SpaceShip> result = repository.findById(1L);
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }
}
