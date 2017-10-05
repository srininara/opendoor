package com.aconex.hackathon.opendoor.repository;

import com.aconex.hackathon.opendoor.model.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FeedbackRepository extends PagingAndSortingRepository<Feedback, UUID> {

    Feedback findOne(UUID id);

    Feedback save(Feedback feedback);

    Page<Feedback> findAll(Pageable pageable);

}
