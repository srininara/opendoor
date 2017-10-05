package com.aconex.hackathon.opendoor.repository;


import com.aconex.hackathon.opendoor.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface CommentRepository extends PagingAndSortingRepository<Comment, UUID> {

    Comment save(Comment comment);

    Page<Comment> findAllByFeedbackId(UUID feedbackId, Pageable pageable);

}
