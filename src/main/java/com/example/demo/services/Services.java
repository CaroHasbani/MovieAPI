package com.example.demo.services;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.models.Movie;
import com.example.demo.repo.MovieRepo;

@Service
public class Services {
	
	
	private final MovieRepo movieRepository;
	@Autowired
	public Services( MovieRepo movieRepository){
	this.movieRepository=movieRepository;
	}
	
	//al inicio de la API aparece lo siguiente
		public String init() {
			return "<h1>Welcome to my movie's API<h1>";
			
		};
	
		// Leer el listado de películas

		public List<Movie> getMovies() {
			return movieRepository.findAll();
		}
	
		//Agregar una pelicula a la bd
		public Movie createMovie(Movie movie) {
			return movieRepository.save(movie);	
		}
	
		//Borrar peliculas
		
		public void deleteMovie( Integer id) {
			
		Optional <Movie> movieToBeDeleted= movieRepository.findById(id);
		
		if (!movieToBeDeleted.isEmpty()) {
			movieRepository.deleteById(id);
		}else {
			throw new RuntimeException("Movie not found");
		}
		}
	

		//actualizar la pelicula
		public Movie  updateMovie(Movie movie, Integer id){

			Optional<Movie> movieToBeUpdated = movieRepository.findById(id);

			if (!movieToBeUpdated.isEmpty()) {
				return movieRepository.save(movie);
			}else {
				throw new RuntimeException("Movie not found");
			}
			}
	
		//buscar por id
		public Optional < Movie> findId(Integer id) {
			return movieRepository.findById(id);
			}
		
		//buscar por titulo
		public List<Movie> findTitle(String title) {
			return movieRepository.findTitle(title);
		}
		
		//buscar por popular
		public List<Movie> findPopular() {
			return movieRepository.findPopular(PageRequest.of(0,3));
		}
		
		//buscar por clasificación de pelicula

		public List<Movie> findClass(String classified) {
			return movieRepository.findClass(classified);
		}
		
}
