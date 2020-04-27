package com.example.clase2.repository;

import com.example.clase2.entity.Region;
import com.example.clase2.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {
}
