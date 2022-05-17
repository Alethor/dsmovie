package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping(value="/movies")
public class MovieController {
  
  @Autowired
  private MovieService service;

  @GetMapping()
  @Operation(summary = "Lista todos os filmes paginados")
  public Page<MovieDTO> findAll(@Parameter(hidden = true) Pageable pageable){

    return service.findAll(pageable);

  }

  @GetMapping(value = "/{id}")
  @Operation(summary = "Lista um filme por id")
  public MovieDTO findById(@PathVariable Long id){

    return service.findById(id);

  }
}
