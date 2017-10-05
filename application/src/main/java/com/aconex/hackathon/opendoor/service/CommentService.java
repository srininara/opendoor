package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Comment;
import com.aconex.hackathon.opendoor.repository.CommentRepository;
import com.aconex.hackathon.opendoor.representation.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.domain;
import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDto save(CommentDto commentDto) {
        Comment comment = commentRepository.save(domain(commentDto));
        return dto(comment);
    }

}
