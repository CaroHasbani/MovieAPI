package services;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Movie;
import repo.MovieRepo;

@Service
public class Services {
	
	
	private final MovieRepo movieRepository;
	@Autowired
	public Services( MovieRepo movieRepository){
	this.movieRepository=movieRepository;
	}
	
	//al inicio de la API aparece lo siguiente
		public String init() {
			return "<h1>Bienvenido a mi API de Peliculas<h1>";
			};
	
	//para Leer el listado de películas

	public List<Movie> getMovies() {
		return movieRepository.findAll();
		}
	
	//agregar una pelicula a la bd
	public Movie createMovie(Movie movie) {
	/* TODO Auto-generated method stub*/
	return movieRepository.save(movie);

	/* la logica del negocio iria aca, si la pelicula ya existe no agregarla y cosas asi*/		
	}
	
	
	
	//borrar peliculas
		public void deleteMovie(Integer id) {
			movieRepository.deleteById(id);
		}

	//Update movie
		public Movie updateMovie(Movie movie) {
			/* TODO Auto-generated method stub*/
			return movieRepository.save(movie);
			}
		//buscar por id
		public Optional < Movie> findId(Integer id) {
			return movieRepository.findById(id);
			}
		
		
		
//	 private List <Movie>movies;
//	/* constructor de la lista de movies*/
//	public Services (List <Movie>movies) {
//		this.movies=movies;
//	} 
//
//	/* public List<Movie> getMovies() {
//		
//		return movies;
//		/* devuelve el array de peliculas*/
//	}
//
//	public Movie createMovie(Movie movie) {
//		/* TODO Auto-generated method stub*/
//		movies.add(movie);
//		return movie;
//		/* la logica del negocio iria aca, si la pelicula ya existe no agregarla y cosas asi*/
//		
//	}
//
//	public boolean deleteMovie(Integer id) {
//		/* TODO Auto-generated method stub*/
//		for(Movie m: movies) {
//			if(m.getId().equals(id)) {
//				movies.remove(m);
//				return true;
//			}
//	}
//		return false;
//	}
//
//	public Optional<Movie> updateMovie(Movie movie, Integer id) {
//		// TODO Auto-generated method stub
//		for(Movie m: movies) {
//			if(m.getId().equals(movie.getId())) {
//				/*definimos update como encontrar el dato y reemplazarlo*/
//				movies.remove(m);
//				movies.add(movie);
//				return Optional.ofNullable(movie);
//			}
//		}
//		return null;
//	} 


}
