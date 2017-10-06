package com.aconex.hackathon.opendoor.model;

import org.springframework.util.StringUtils;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Feedback {

    private static final String ANONYMOUS = "Anonymous";

    @Id
    private UUID id;

    private int bliss;

    private String title;

    private String message;

    private String respondent;

    private Timestamp createdAt;

    @Embedded
    private Rating rating;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Category category;

    private int discussionCount;

    public Feedback() {
    }

    public Feedback(UUID id, String title, String message, int bliss, Location location, Category category, String respondent, Rating rating, int discussionCount) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.bliss = bliss;
        this.respondent = StringUtils.isEmpty(respondent)?ANONYMOUS:respondent;
        this.rating = rating;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.location = location;
        this.category = category;
        this.discussionCount = discussionCount;
    }

    public Feedback(String title, String message, int bliss, Location location, Category category, String respondent, Rating rating, int discussionCount) {
        this(UUID.randomUUID(), title, message, bliss, location, category, respondent, rating, discussionCount);
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public Category getCategory() {
        return category;
    }

    public Rating getRating() {
        return rating;
    }

    public int getDiscussionCount() {
        return discussionCount;
    }
}
