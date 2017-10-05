package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.model.Rating;
import com.aconex.hackathon.opendoor.repository.FeedbackRepository;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.representation.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import javax.transaction.Transactional;

@Service
@Transactional
public class RatingService {
    private final FeedbackRepository feedbackRepository;

    @Autowired
    public RatingService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public FeedbackDto updateRating(UUID feedbackId, RatingDto ratingDto) {
        Feedback feedback = feedbackRepository.findOne(feedbackId);
        updateRating(ratingDto, feedback);
        Feedback savedFeedback = feedbackRepository.save(feedback);
        return ObjectConverter.dto(savedFeedback);
    }

    private void updateRating(RatingDto ratingDto, Feedback feedback) {
        Rating rating = feedback.getRating();
        rating.incrementUpvotes(ratingDto.getUpvotes());
        rating.incrementDownvotes(ratingDto.getDownvotes());
    }
}
