package com.mvabal.prueba_tecnica.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController("/spaceships")
public class SpaceShiptController {

    @GetMapping
    public String getSpaceships(@RequestParam String name) {
        return "Spaceship name: " + name;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id) {
        return "Spaceship by id: " + id;
    }

}
