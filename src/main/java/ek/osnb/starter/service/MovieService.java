package ek.osnb.starter.service;

import ek.osnb.starter.exceptions.NotFoundException;
import ek.osnb.starter.model.Movie;
import ek.osnb.starter.model.MovieDTO;
import ek.osnb.starter.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException("Movie not found with id:" + id));

        return new MovieDTO(
                movie.getTitle(),
                movie.getReleaseYear(),
                movie.getGenre()
        );
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}