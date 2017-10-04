package com.aconex.hackathon.opendoor.repository;

import com.aconex.hackathon.opendoor.model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {

    @Override
    List<Location> findAll();

}
