package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Category;
import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.model.Location;
import com.aconex.hackathon.opendoor.representation.CategoryDto;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.representation.LocationDto;

public final class ObjectConverter {
    public static Feedback domain(FeedbackDto feedbackDto, LocationDto location, CategoryDto category) {
        return new Feedback(feedbackDto.getTitle()
                ,feedbackDto.getMessage(),
                feedbackDto.getBliss(),
                domain(location),
                domain(category),
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
                feedback.getLocation().getId(),
                feedback.getCategory().getId());
    }

    public static CategoryDto dto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getShortDescription(), category.getFullDescription());
    }

    public static Category domain(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName(), categoryDto.getShortDescription(), categoryDto.getFullDescription());
    }

    public static LocationDto dto(Location location) {
        return new LocationDto(location.getId(), location.getName());
    }

    public static Location domain(LocationDto locationDto) {
        return new Location(locationDto.getId(), locationDto.getName());
    }
}
