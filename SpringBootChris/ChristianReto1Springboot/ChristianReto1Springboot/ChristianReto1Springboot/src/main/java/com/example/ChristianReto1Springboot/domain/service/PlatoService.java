package com.example.ChristianReto1Springboot.domain.service;

import com.example.ChristianReto1Springboot.persistence.entity.Plato;

import java.util.List;

public interface PlatoService {
    List<Plato> getAllPlatos();
    Plato getPlatoById(Long id);
    Plato savePlato(Plato plato);
    void deletePlato(Long id);
    void updatePlato(Long id, Plato plato);
}
