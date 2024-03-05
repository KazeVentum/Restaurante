package com.example.ChristianReto1Springboot.web.controller;

import com.example.ChristianReto1Springboot.domain.service.PlatoService;
import com.example.ChristianReto1Springboot.domain.service.PlatoServiceImp;
import com.example.ChristianReto1Springboot.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/plato")
public class PlatoController {
    private final PlatoService platoService;
    @Autowired
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public List<Plato> getAllPlatos(){
        return platoService.getAllPlatos();
    }

    @GetMapping("/{id}")
    public Plato getPlatoById(@PathVariable Long id){
        return platoService.getPlatoById(id);
    }

    @PostMapping
    public Plato savePlato(@RequestBody Plato plato){
        return platoService.savePlato(plato);
    }

    @PutMapping("/{id}")
    public void updatePlato(@PathVariable Long id, @RequestBody Plato plato){
        platoService.updatePlato(id, plato);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id){
        platoService.deletePlato(id);
    }

}
