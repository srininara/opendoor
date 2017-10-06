package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Category;
import com.aconex.hackathon.opendoor.model.Comment;
import com.aconex.hackathon.opendoor.model.Feedback;
import com.aconex.hackathon.opendoor.model.Location;
import com.aconex.hackathon.opendoor.model.Rating;
import com.aconex.hackathon.opendoor.representation.CategoryDto;
import com.aconex.hackathon.opendoor.representation.CommentDto;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.representation.LocationDto;
import com.aconex.hackathon.opendoor.representation.RatingDto;

import java.util.Optional;

public final class ObjectConverter {
    public static Feedback domain(FeedbackDto feedbackDto, LocationDto location, CategoryDto category, RatingDto rating) {
        return new Feedback(feedbackDto.getTitle()
                ,feedbackDto.getMessage(),
                Optional.ofNullable(feedbackDto.getBliss()).orElse(0),
                domain(location),
                domain(category),
                feedbackDto.getRespondent(), domain(rating));
    }

    public static FeedbackDto dto(Feedback feedback) {
        return new FeedbackDto(
                feedback.getTitle(),
                feedback.getMessage(),
                feedback.getId(),
                feedback.getBliss(),
                feedback.getRespondent(),
                feedback.getCreatedAt(),
                dto(feedback.getRating()),
                dto(feedback.getLocation()),
                dto(feedback.getCategory()));
    }

    public static CategoryDto dto(Category category) {
        return new CategoryDto(category.getId(), category.getName(), category.getIcon(), category.getShortDescription(), category.getFullDescription());
    }

    public static Category domain(CategoryDto categoryDto) {
        return new Category(categoryDto.getId(), categoryDto.getName(), categoryDto.getIcon(), categoryDto.getShortDescription(), categoryDto.getFullDescription());
    }

    public static LocationDto dto(Location location) {
        return new LocationDto(location.getId(), location.getName());
    }

    public static Location domain(LocationDto locationDto) {
        return new Location(locationDto.getId(), locationDto.getName());
    }

    public static CommentDto dto(Comment comment) {
        return new CommentDto(comment.getFeedbackId(), comment.getCommentId(), comment.getComment(), comment.getCreatedAt());
    }

    public static Comment domain(CommentDto commentDto) {
        return new Comment(commentDto.getFeedbackId(), commentDto.getComment());
    }

    public static RatingDto dto(Rating rating) {
        return new RatingDto(rating.getUpvotes(), rating.getDownvotes());
    }

    public static Rating domain(RatingDto rating) {
        return new Rating(rating.getUpvotes(), rating.getDownvotes());
    }
}
