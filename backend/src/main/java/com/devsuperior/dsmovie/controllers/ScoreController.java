package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
  
  @Autowired
  private ScoreService service;

  @PutMapping
  @Operation(summary = "Adiciona uma nova avaliação para um filme")
  public MovieDTO saveScore(@RequestBody ScoreDTO dto){
    
    MovieDTO moviedto = service.saveScore(dto);
    
    return moviedto;
 
  }

}
