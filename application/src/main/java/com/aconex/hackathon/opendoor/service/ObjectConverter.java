package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.model.Location;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;

public final class ObjectConverter {
    public static Feedback domain(FeedbackDto feedbackDto, Location location) {
        return new Feedback(feedbackDto.getTitle(), feedbackDto.getMessage(),
                feedbackDto.getBliss(),
                location,
                feedbackDto.getRespondent());
    }

    public static FeedbackDto dto(Feedback feedback) {
        return new FeedbackDto(
                feedback.getTitle(),
                feedback.getMessage(),
                feedback.getId(),
                feedback.getBliss(),
                feedback.getRespondent(),
                feedback.getCreatedAt(),
                feedback.getLocation().getId());
    }
}
