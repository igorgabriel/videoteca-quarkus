package com.github.igorgabriel.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import com.github.igorgabriel.dto.MovieDto;
import com.github.igorgabriel.model.Category;
import com.github.igorgabriel.model.Movie;

import org.modelmapper.ModelMapper;

@ApplicationScoped
@Transactional
public class MovieService {
    private ModelMapper mapper = new ModelMapper();
    
    public List<MovieDto> getAll() {
        List<Movie> movies = Movie.listAll();
        
        List<MovieDto> dtos = movies.stream().map(movie -> mapper.map(movie, MovieDto.class)).toList();

        return dtos;
    }

    public MovieDto getOne(Long id) {
        Optional<Movie> movieOp = Movie.findByIdOptional(id);
        if(movieOp.isPresent()) {
            Movie movie = movieOp.get();
            MovieDto dto = mapper.map(movie, MovieDto.class);
            return dto;
        } else {
            throw new NotFoundException();
        }
    }

    public void save(MovieDto dto) {
        Movie movie = mapper.map(dto, Movie.class);

        movie.persist();
    }

    public void update(MovieDto dto) {
        Optional<Movie> movieOp = Movie.findByIdOptional(dto.getId());
        if(movieOp.isPresent()) {
            Movie movie = movieOp.get();
            movie.setCategory(Category.valueOf(dto.getCategoryName()));
            movie.setDescription(dto.getDescription());
            movie.setDirector(dto.getDirector());
            movie.setDuration(dto.getDuration());
            movie.setImage(dto.getImage());
            movie.setName(dto.getName());
            movie.setYear(dto.getYear());
            movie.persist();
        } else {
            throw new NotFoundException();
        }
    }

    public void remove(Long id) {
        Optional<Movie> movieOp = Movie.findByIdOptional(id);
        if(movieOp.isPresent()) {
            Movie movie = movieOp.get();
            movie.delete();
        } else {
            throw new NotFoundException();
        }
    }
}
