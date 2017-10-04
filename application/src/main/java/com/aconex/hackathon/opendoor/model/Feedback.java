package com.aconex.hackathon.opendoor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Feedback {

    @Id
    private UUID id;

    private int bliss;

    private String message;

    private String respondent;

    public Feedback() {
    }

    public Feedback(String message, int bliss) {
        this(message, bliss, null);
    }

    public Feedback(String message, int bliss, String respondent) {
        this.message = message;
        this.bliss = bliss;
        this.respondent = respondent;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getBliss() {
        return bliss;
    }

    public String getRespondent() {
        return respondent;
    }
}
