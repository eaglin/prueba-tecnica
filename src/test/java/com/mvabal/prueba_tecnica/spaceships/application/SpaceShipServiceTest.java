package com.mvabal.prueba_tecnica.spaceships.application;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.mvabal.prueba_tecnica.shared.domain.PaginationDto;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShipRepository;

public class SpaceShipServiceTest {

    @Mock
    private SpaceShipRepository repository;

    @InjectMocks
    private SpaceShipService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        SpaceShip spaceShip = new SpaceShip();
        spaceShip.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(spaceShip));

        Optional<SpaceShip> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindByName() {
        SpaceShip spaceShip1 = new SpaceShip();
        spaceShip1.setName("Falcon");
        SpaceShip spaceShip2 = new SpaceShip();
        spaceShip2.setName("Eagle");

        List<SpaceShip> spaceShips = Arrays.asList(spaceShip1, spaceShip2);
        PaginationDto pagination = new PaginationDto();
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getLimit());

        when(repository.findByNameContainingIgnoreCase("a", pageable)).thenReturn(spaceShips);

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

        verify(repository, times(1)).save(spaceShip);
    }
}
