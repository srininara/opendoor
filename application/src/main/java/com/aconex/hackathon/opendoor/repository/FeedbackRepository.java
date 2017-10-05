package com.aconex.hackathon.opendoor.repository;

import com.aconex.hackathon.opendoor.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, Integer> {

    Feedback save(Feedback feedback);

    Page<Feedback> findAll(Pageable pageable);

}
