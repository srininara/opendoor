package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.repository.FeedbackRepository;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedbackDto save(FeedbackDto feedbackDto) {
        Feedback feedback = feedbackRepository.save(new Feedback(feedbackDto.getMessage(), feedbackDto.getBliss()));
        return new FeedbackDto(feedback.getMessage(), feedback.getId(), feedback.getBliss());
    }
}
