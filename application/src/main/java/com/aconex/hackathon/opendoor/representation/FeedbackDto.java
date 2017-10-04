package com.aconex.hackathon.opendoor.representation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeedbackDto {
    private String message;
    private Integer id;

    public FeedbackDto() {
    }

    public FeedbackDto(String message, Integer id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
