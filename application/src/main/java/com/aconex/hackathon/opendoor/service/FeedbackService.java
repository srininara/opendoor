package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.repository.FeedbackRepository;
import com.aconex.hackathon.opendoor.representation.CategoryDto;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.representation.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.domain;
import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final LocationService locationService;
    private final CategoryService categoryService;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, LocationService locationService, CategoryService categoryService) {
        this.feedbackRepository = feedbackRepository;
        this.locationService = locationService;
        this.categoryService = categoryService;
    }

    public FeedbackDto save(FeedbackDto feedbackDto) {
        LocationDto location = locationService.getLocation(feedbackDto.getLocationId());
        CategoryDto category = categoryService.getCategory(feedbackDto.getCategoryId());
        Feedback feedback = feedbackRepository.save(domain(feedbackDto, location, category));
        return dto(feedback);
    }

}
