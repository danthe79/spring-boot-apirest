package com.aspsolutions.api.apirest.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;

import com.aspsolutions.api.apirest.model.Estudiante;

@RestController
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteServices;
	
	@GetMapping("api/estudiante")
	public List<Estudiante> obtenerEstudiantes(){
		List<Estudiante> listaEstudiantes=new ArrayList<>();
		
		Estudiante e = new Estudiante();
		
		e.setId(1);
		e.setNombres("Daniel Eduat}rdo");
		e.setApellidos("Haag Torrente");
		e.setEmail("danielehaag8@gmail.con");
		e.setNota(5.0);
		
        Estudiante e1 = new Estudiante();
		
		e1.setId(2);
		e1.setNombres("Angelica María");
		e1.setApellidos("Torres Besada");
		e1.setEmail("ambtorresbesada@gmail.con");
		e1.setNota(4.5);
		
		listaEstudiantes.add(e);
		listaEstudiantes.add(e1);
		
		
		
		return listaEstudiantes;
		}
		
	    @PostMapping("api/estudiantes")
		public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante) {
			System.out.println(estudiante);
			estudianteServices.guardar(estudiante);
			return estudiante;
		}
		
		@GetMapping("api/estudiantes")
		public List<Estudiante>obtener(){
		return estudianteServices.obtenerTodos();
		}
		
		@GetMapping("api/estudiantes/{id}")
		public Estudiante obtenerEstudiante(@PathVariable("id") Integer id) {
			return estudianteServices.obtenerEstudiante(id);
		}
		@PutMapping("api/estudiantes")
		public void actualizarEstudiante(@RequestBody Estudiante estudiante) {
			estudianteServices.actualizar(estudiante);
	    
		}@DeleteMapping("api/estudiantes/{id}")
		public void eliminar(@PathVariable("id") Integer id) {
			estudianteServices.eliminar(id);
		}
			
}


