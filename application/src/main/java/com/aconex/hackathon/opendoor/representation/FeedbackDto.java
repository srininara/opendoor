package com.aconex.hackathon.opendoor.representation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FeedbackDto {
    private String message;
    private Integer id;
    private Integer bliss;
    private String respondent;

    public FeedbackDto() {
    }

    public FeedbackDto(String message, Integer id, Integer bliss, String respondent) {
        this.message = message;
        this.id = id;
        this.bliss = bliss;
        this.respondent = respondent;
    }

    public String getMessage() {
        return message;
    }

    public Integer getId() {
        return id;
    }

    public Integer getBliss() {
        return bliss;
    }

    public String getRespondent() {
        return respondent;
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "message='" + message + '\'' +
                ", id=" + id +
                ", bliss=" + bliss +
                ", respondent='" + respondent + '\'' +
                '}';
    }
}
