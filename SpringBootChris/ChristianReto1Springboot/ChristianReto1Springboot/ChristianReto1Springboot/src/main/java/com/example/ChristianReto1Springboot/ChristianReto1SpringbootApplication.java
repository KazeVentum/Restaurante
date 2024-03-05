package com.example.ChristianReto1Springboot;

import com.example.ChristianReto1Springboot.persistence.entity.Plato;
import com.example.ChristianReto1Springboot.domain.service.PlatoServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ChristianReto1SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChristianReto1SpringbootApplication.class, args);
//		PlatoServiceImp platoServiceImp = contexto.getBean(PlatoServiceImp.class);
////
////		Plato plato = new Plato();
////
////		plato.setNombrePlato("Mango");
////		plato.setDescripcionPlato("Mango maracaton");
////		plato.setMenuPlato("Menu de Barrio/Pan de luka");
////		plato.setPrecioPlato(2000);
////
////		platoServiceImp.savePlato(plato);
//////		platoService.deletePlato(2L);
//////		platoService.updatePlato(1L, plato);
////
//////		List<Plato> platoObj = platoService.getAllPlatos();
//////		for(Plato platoList : platoObj){
//////			System.out.println(platoList);
//////		}
////
//////		System.out.println(platoService.getPlatoById(3L));

	}



}
