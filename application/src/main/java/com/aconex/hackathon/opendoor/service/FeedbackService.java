package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.model.Location;
import com.aconex.hackathon.opendoor.repository.FeedbackRepository;
import com.aconex.hackathon.opendoor.repository.LocationRepository;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.domain;
import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, LocationRepository locationRepository) {
        this.feedbackRepository = feedbackRepository;
        this.locationRepository = locationRepository;
    }

    public FeedbackDto save(FeedbackDto feedbackDto) {
        Location location = locationRepository.findOne(feedbackDto.getLocationId());
        Feedback feedback = feedbackRepository.save(domain(feedbackDto, location));
        return dto(feedback);
    }

}
