package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
  
  @Autowired
  private MovieRepository repository;

  @Transactional(readOnly = true) //determina como um m�todo que trata da JPA e a propriedade readOnly define o m�todo como s� de leitura tornando-o mais eficiente no banco de dados
  public Page<MovieDTO> findAll(Pageable pageable){
   
    Page<Movie> result =  repository.findAll(pageable);
    Page<MovieDTO> page = result.map(m -> new MovieDTO(m)); //fun��o map do page executa um m�todo pra cada ocorrencia na lista (convertendo movie para movieDTO)
    return page;
  
  }

  @Transactional(readOnly = true)
  public MovieDTO findById(Long id){

    Movie result = repository.findById(id).get();
    MovieDTO dto = new MovieDTO(result);
    return dto;
  }


}
