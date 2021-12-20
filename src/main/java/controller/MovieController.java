package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Movie;
import services.Services;
@RestController

@RequestMapping


public class MovieController {
 private final Services service;


	@Autowired
	public MovieController(Services service) {
		// TODO Auto-generated constructor stub
	this.service=service;
	}

	public Services getService() {
		return service;
	}
	//metodo para mostrar las  peliculas
	@GetMapping("/movie")
	public List<Movie> getMovies(){
		return service.getMovies();
	}
	// metodo de inicio
	@GetMapping("/inicio")
	public String Init() {
		return service.init();
	}
	
	//metodo para generar  peliculas
	@PostMapping("/addMovie")
	public Movie createMovie(@RequestBody Movie movie){
		return service.createMovie(movie);
	}
	
	//metodo para eliminar las peliculas
	@DeleteMapping("/deleteMovie/{id}")
	public void deleteMovie( @PathVariable Integer id) {
		service.deleteMovie(id);
	}

	//metodo para actualizar las peliculas

	@PutMapping("/updateMovie/{id}")
	public Movie updateMovie( @RequestBody Movie movie) {
		return service.updateMovie(movie);
	}
	//metodo para buscar por id
	@GetMapping("/searchId/{id}")
	public Optional < Movie> findId(@PathVariable Integer id) {
		return service.findId(id);
	}
	
}
