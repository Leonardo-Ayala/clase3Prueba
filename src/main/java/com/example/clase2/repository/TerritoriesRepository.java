package com.example.clase2.repository;

import com.example.clase2.entity.Shipper;
import com.example.clase2.entity.Territories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoriesRepository extends JpaRepository<Territories,String> {
}
