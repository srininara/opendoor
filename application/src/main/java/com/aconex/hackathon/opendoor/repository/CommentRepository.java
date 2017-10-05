package com.aconex.hackathon.opendoor.repository;


import com.aconex.hackathon.opendoor.model.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {

    Comment save(Comment comment);
}
