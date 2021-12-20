package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
