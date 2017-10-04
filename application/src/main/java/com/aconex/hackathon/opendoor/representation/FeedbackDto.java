package com.aconex.hackathon.opendoor.representation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeedbackDto {
    private String message;

    public FeedbackDto() {
    }

    public FeedbackDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
