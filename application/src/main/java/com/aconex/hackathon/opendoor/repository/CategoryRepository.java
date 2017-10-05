package com.aconex.hackathon.opendoor.repository;

import com.aconex.hackathon.opendoor.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Override
    List<Category> findAll();

    @Override
    Category findOne(Integer id);

}
