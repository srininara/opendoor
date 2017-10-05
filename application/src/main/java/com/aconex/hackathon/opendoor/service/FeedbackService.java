package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.repository.FeedbackRepository;
import com.aconex.hackathon.opendoor.representation.CategoryDto;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.representation.LocationDto;
import com.aconex.hackathon.opendoor.representation.RatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.domain;
import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;
import static java.util.stream.Collectors.toList;

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
        LocationDto location = locationService.getLocation(feedbackDto.getLocation().getId());
        CategoryDto category = categoryService.getCategory(feedbackDto.getCategory().getId());
        Feedback feedback = feedbackRepository.save(domain(feedbackDto, location, category, new RatingDto()));
        return dto(feedback);
    }

    public List<FeedbackDto> findAll(Pageable pageable) {
        return feedbackRepository.findAll(pageable).getContent()
                .stream()
                .map(ObjectConverter::dto).collect(toList());
    }

    public FeedbackDto findById(UUID id){
        return ObjectConverter.dto(feedbackRepository.findOne(id));
    }

}
