package com.example.ChristianReto1Springboot.domain.repository;

import com.example.ChristianReto1Springboot.persistence.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository <Plato, Long> {
}
