package com.mvabal.prueba_tecnica.spaceships.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spaceships")
public class SpaceShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String appearence;

    public SpaceShip() {
    }

    public SpaceShip(Long id2, String name2, String appearence2) {
        this.id = id2;
        this.name = name2;
        this.appearence = appearence2;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAppearence() {
        return appearence;
    }

    public void setName(String name2) {
        // TODO Auto-generated method stub
        this.name = name2;
    }

    public void setAppearence(String appearence2) {
        // TODO Auto-generated method stub
        this.appearence = appearence2;
    }

    public void setId(Long id2) {
        // TODO Auto-generated method stub
        this.id = id2;
    }

}
