package com.tsi.balwant.rai.program;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer>{

    List<Film> findByTitleLikeOrDescriptionLike(String title, String description);
}