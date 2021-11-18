package com.github.igorgabriel.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.igorgabriel.dto.MovieDto;
import com.github.igorgabriel.service.MovieService;

@Path("v1/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieController {
    
    @Inject
    private MovieService service;

    @GET
    public List<MovieDto> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public MovieDto getOne(@PathParam("id") Long id) {
        return service.getOne(id);
    }

    @POST
    public void save(MovieDto movie) {
        service.save(movie);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, MovieDto movie) {
        movie.setId(id);
        service.update(movie);
    }

    @DELETE
    @Path("/{id}")
    public void remove(@PathParam("id") Long id) {
        service.remove(id);
    }
}
