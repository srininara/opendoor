package com.aconex.hackathon.opendoor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Comment {

    private UUID feedbackId;

    @Id
    private UUID commentId;

    private String comment;

    private Timestamp createdAt;

    public Comment(){

    }

    public Comment(UUID feedbackId, String comment) {
        this(feedbackId, UUID.randomUUID(), comment);
    }

    public Comment(UUID feedbackId, UUID commentId, String comment) {
        this.feedbackId = feedbackId;
        this.commentId = commentId;
        this.comment = comment;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public UUID getFeedbackId() {
        return feedbackId;
    }

    public UUID getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "feedbackId=" + feedbackId +
                ", commentId=" + commentId +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
