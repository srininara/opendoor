package com.aconex.hackathon.opendoor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Comment {

    private UUID feedbackId;

    @Id
    private UUID commentId;

    private String comment;

    public Comment(){

    }

    public Comment(UUID feedbackId, String comment) {
        this(feedbackId, UUID.randomUUID(), comment);
    }

    public Comment(UUID feedbackId, UUID commentId, String comment) {
        this.feedbackId = feedbackId;
        this.commentId = commentId;
        this.comment = comment;
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

    @Override
    public String toString() {
        return "Comment{" +
                "feedbackId=" + feedbackId +
                ", commentId=" + commentId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
