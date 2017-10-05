package com.aconex.hackathon.opendoor.controller;

import com.aconex.hackathon.opendoor.representation.CommentDto;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.service.CommentService;
import com.aconex.hackathon.opendoor.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    private FeedbackService feedbackService;
    private CommentService commentService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, CommentService commentService) {
        this.feedbackService = feedbackService;
        this.commentService = commentService;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public FeedbackDto save(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.save(feedbackDto);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    List<FeedbackDto> list(Pageable pageable) {
        return feedbackService.findAll(pageable);
    }

    @PostMapping(path = "{feedbackId}/comments", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public CommentDto addComment(@RequestBody CommentDto commentDto, @PathVariable("feedbackId") UUID feedbackId) {
        commentDto.setFeedbackId(feedbackId);
        return commentService.save(commentDto);
    }

    @GetMapping(path = "{feedbackId}/comments", produces = APPLICATION_JSON_VALUE)
    List<CommentDto> feedbackComments(Pageable pageable, @PathVariable("feedbackId") UUID feedbackId) {
        return commentService.comments(feedbackId, pageable);
    }

}
