package com.aconex.hackathon.opendoor.representation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RatingDto {
    private Integer upvotes;
    private Integer downvotes;

    public RatingDto() {
    }

    public RatingDto(Integer upvotes, Integer downvotes) {
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    @Override
    public String toString() {
        return "RatingDto{" +
                "upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                '}';
    }
}
