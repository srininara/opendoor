package com.aconex.hackathon.opendoor.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto {
    private String title;
    private String message;
    private UUID id;
    private Integer bliss;
    private String respondent;
    private Timestamp createdAt;
    private RatingDto rating;

    private LocationDto location;
    private CategoryDto category;
}
