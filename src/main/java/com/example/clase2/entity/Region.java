package com.example.clase2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="region")
public class Region {
    @Id
    @Column(nullable = false)
    private int regionid;

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public String getRegiondescription() {
        return regiondescription;
    }

    public void setRegiondescription(String regiondescription) {
        this.regiondescription = regiondescription;
    }

    @Column(nullable = false)
    private String regiondescription;
}
