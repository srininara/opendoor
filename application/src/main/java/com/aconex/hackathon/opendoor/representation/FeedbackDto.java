package com.aconex.hackathon.opendoor.representation;

import com.aconex.hackathon.opendoor.model.Location;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.sql.Timestamp;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeedbackDto {
    private String message;
    private UUID id;
    private Integer bliss;
    private String respondent;
    private Timestamp createdAt;

    private String location;

    public FeedbackDto() {
    }

    public FeedbackDto(String message, UUID id, Integer bliss, String respondent, Timestamp createdAt, String location) {
        this.message = message;
        this.id = id;
        this.bliss = bliss;
        this.respondent = respondent;
        this.createdAt = createdAt;
        this.location = location;
    }

    public String getMessage() {
        return message;
    }

    public UUID getId() {
        return id;
    }

    public Integer getBliss() {
        return bliss;
    }

    public String getRespondent() {
        return respondent;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "message='" + message + '\'' +
                ", id=" + id +
                ", bliss=" + bliss +
                ", respondent='" + respondent + '\'' +
                ", createdAt=" + createdAt +
                ", location='" + location + '\'' +
                '}';
    }


}
