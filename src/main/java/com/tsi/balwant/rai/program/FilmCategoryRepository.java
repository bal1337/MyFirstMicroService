package com.tsi.balwant.rai.program;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.Table;


public interface FilmCategoryRepository extends CrudRepository<FilmCategory, Integer> {

}