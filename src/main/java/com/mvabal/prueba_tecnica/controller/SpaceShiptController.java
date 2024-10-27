package com.mvabal.prueba_tecnica.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mvabal.prueba_tecnica.shared.domain.PaginationDto;

import com.mvabal.prueba_tecnica.spaceships.application.SpaceShipService;
import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/spaceships")
public class SpaceShiptController {

    @Autowired
    private SpaceShipService service;

    @GetMapping("/name")
    public List<SpaceShip> getSpaceshipsByName(@RequestParam(required = true, name = "name") String name,
            @RequestParam(required = false, name = "page") Optional<Integer> page,
            @RequestParam(required = false, name = "size") Optional<Integer> size) {
        PaginationDto pagination = new PaginationDto(page, size);
        List<SpaceShip> response = service.findByName(name, pagination);
        return response;
    }

    @GetMapping("/{id}")
    public SpaceShip getById(@PathVariable Long id) {
        Optional<SpaceShip> response = service.findById(id);
        return response.orElse(null);
    }

    @PostMapping("")
    public void postMethodName(@RequestBody RequestSpaceShipDto entity) {
        // TODO: process POST request
        SpaceShip spaceShip = new SpaceShip(null, entity.getName(), entity.getAppearence());
        this.service.save(spaceShip);

    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody RequestSpaceShipDto entity) {

        // TODO: process PUT request

        SpaceShip spaceShip = this.service.findById(id).orElse(null);
        if (spaceShip == null)
            return;

        if (entity.getName() != null)
            spaceShip.setName(entity.getName());
        if (entity.getAppearence() != null)
            spaceShip.setAppearence(entity.getAppearence());
        this.service.save(spaceShip);

    }

}
