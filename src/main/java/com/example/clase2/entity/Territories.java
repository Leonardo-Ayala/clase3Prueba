package com.example.clase2.entity;


import javax.persistence.*;

@Entity
@Table(name = "territories")
public class Territories {
    @Id
    @Column(nullable = false)
    private String territoryid;
    @Column(nullable = false)
    private String territorydescription;

    public String getTerritoryid() {
        return territoryid;
    }

    public void setTerritoryid(String territoryid) {
        this.territoryid = territoryid;
    }

    public String getTerritorydescription() {
        return territorydescription;
    }

    public void setTerritorydescription(String territorydescription) {
        this.territorydescription = territorydescription;
    }

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    @Column(nullable = false)
    private int regionid;

}
