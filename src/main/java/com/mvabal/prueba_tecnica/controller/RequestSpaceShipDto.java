package com.mvabal.prueba_tecnica.controller;

import com.mvabal.prueba_tecnica.spaceships.domain.SpaceShip;

public class RequestSpaceShipDto {

    private String name;

    private String appearence;

    public String getName() {
        return name;
    }

    public String getAppearence() {
        return appearence;
    }

    RequestSpaceShipDto(
            String name, String appearence) {
        this.name = name;
        this.appearence = appearence;
    }

}
