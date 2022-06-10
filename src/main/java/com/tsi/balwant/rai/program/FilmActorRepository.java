package com.tsi.balwant.rai.program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, Integer>{

    List<FilmActor> findByActorId(int actorId);

}