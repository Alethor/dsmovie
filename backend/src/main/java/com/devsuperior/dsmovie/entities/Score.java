package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {
  
  @EmbeddedId //anotação de ID composto
  private ScorePK id = new ScorePK(); //precisa ser uma classe auxiliar pois é uma chave composta no banco
  private Double value;

  public Score(){

  }

  public void setMovie(Movie movie){ //necessário para realizar o relacionamento de um filme com um score
    this.id.setMovie(movie);
  }

  public void setUser(User user){ //necessário para realizar o relacionamento do usuario com o score
    this.id.setUser(user);
  }

  public ScorePK getId() {
    return id;
  }

  public void setId(ScorePK id) {
    this.id = id;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  

}
