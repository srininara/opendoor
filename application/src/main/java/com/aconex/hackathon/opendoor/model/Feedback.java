package com.aconex.hackathon.opendoor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Feedback {

    @Id
    private UUID id;

    private int bliss;

    private String message;

    private String respondent;

    private Timestamp createdAt;

    @ManyToOne
    private Location location;

    public Feedback() {
    }

    public Feedback(String message, int bliss, Location location) {
        this(message, bliss, location, null);
    }

    public Feedback(String message, int bliss, Location location, String respondent) {
        this.message = message;
        this.bliss = bliss;
        this.respondent = respondent;
        this.id = UUID.randomUUID();
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.location = location;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Location getLocation() {
        return location;
    }
}
