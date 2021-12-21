package repo;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import models.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

	// filtrar por titulo
	@Query ("SELECT p FROM Movie m WHERE m.title LIKE %:title%")
	List<Movie> findTitle(@Param("title") String title);

	
	// filtrar los populares
	@Query ("SELECT p FROM  Movie m ORDER BY m.rate DESC")
	List<Movie> findPopular(PageRequest pageRequest);


	//filtrar por clasificación
	@Query ("SELECT p FROM Movie m WHERE m.classified LIKE %:classified%")
	List<Movie> findClass(@Param("classified") String classified);
}
