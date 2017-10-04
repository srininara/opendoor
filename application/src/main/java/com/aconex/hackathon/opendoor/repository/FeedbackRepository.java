package com.aconex.hackathon.opendoor.repository;

import com.aconex.hackathon.opendoor.model.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

    Feedback save(Feedback feedback);

}
