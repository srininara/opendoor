package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Comment;
import com.aconex.hackathon.opendoor.repository.CommentRepository;
import com.aconex.hackathon.opendoor.representation.CommentDto;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.domain;
import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;
import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final FeedbackService feedbackService;

    @Autowired
    public CommentService(CommentRepository commentRepository, FeedbackService feedbackService) {
        this.commentRepository = commentRepository;
        this.feedbackService = feedbackService;
    }

    public CommentDto save(CommentDto commentDto) {
        Comment comment = commentRepository.save(domain(commentDto));
        FeedbackDto feedbackDto = feedbackService.findById(comment.getFeedbackId());
        updateCommentCount(feedbackDto);
        feedbackService.save(feedbackDto);
        return dto(comment);
    }

    public List<CommentDto> comments(UUID feedbackId, Pageable pageable) {
        return commentRepository.findAllByFeedbackId(feedbackId, pageable).getContent()
                .stream()
                .map(ObjectConverter::dto).collect(toList());
    }

    private void updateCommentCount(FeedbackDto feedback) {
        feedback.setDiscussionCount(feedback.getDiscussionCount() + 1);
    }

}
