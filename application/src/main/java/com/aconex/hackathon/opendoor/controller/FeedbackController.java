package com.aconex.hackathon.opendoor.controller;

import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private static final Logger logger = LoggerFactory.getLogger(FeedbackController.class);

    private FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public FeedbackDto save(@RequestBody FeedbackDto feedbackDto) {
        logger.info(feedbackDto.toString());
        return feedbackService.save(feedbackDto);
    }

    @RequestMapping(method=RequestMethod.GET)
    List<FeedbackDto> list(Pageable pageable){
        return feedbackService.findAll(pageable);
    }
}
