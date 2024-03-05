package com.example.ChristianReto1Springboot.domain.service;

import com.example.ChristianReto1Springboot.domain.repository.PlatoRepository;
import com.example.ChristianReto1Springboot.persistence.entity.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImp implements PlatoService {

    private final PlatoRepository platoRepository;

    @Autowired
    public PlatoServiceImp(PlatoRepository platoRepository){
        this.platoRepository = platoRepository;
    }

    // ----- CRUD ----- //

    // Get All
    @Override
    public List<Plato> getAllPlatos() {
        System.out.println("Mostrando todos los Platos...");
        return platoRepository.findAll();
    }

    // Get Plato By Id
    @Override
    public Plato getPlatoById(Long id) {
        Optional<Plato> optionalPlato =  platoRepository.findById(id);
        if (optionalPlato.isPresent()){
            System.out.println("Mostrando Plato...");
            return optionalPlato.get();
        }
        else {
            throw new Error("Error: El ID ingresado no se encuentra en la entidad Plato");
        }
    }

    // Save
    @Override
    public Plato savePlato(Plato plato) {
        System.out.println("El plato ha sido guardado con exito");
        return platoRepository.save(plato);
    }

    // Delete
    @Override
    public void deletePlato(Long id) {
        Optional<Plato> optionalPlato =  platoRepository.findById(id);
        if (optionalPlato.isPresent()){
            platoRepository.deleteById(id);
            System.out.println("El plato numero: " + " ha sido eliminado");
        }
        else {
            throw new Error("Error: El ID ingresado no se encuentra en la entidad y no se puede eliminar");
        }
    }

    @Override
    public void updatePlato(Long id, Plato plato) {
        Plato platoEnviar = platoRepository.findById(id).orElse(null);

        platoEnviar.setNombrePlato(plato.getNombrePlato());
        platoEnviar.setDescripcionPlato(plato.getDescripcionPlato());
        platoEnviar.setMenuPlato(plato.getMenuPlato());
        platoEnviar.setPrecioPlato(plato.getPrecioPlato());

        platoRepository.save(platoEnviar);
        System.out.println("El plato ha sido actualizado con exito.");
    }



}
