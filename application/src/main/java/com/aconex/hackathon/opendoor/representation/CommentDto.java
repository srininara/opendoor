package com.aconex.hackathon.opendoor.representation;

import java.util.UUID;

public class CommentDto {

    private UUID feedbackId;
    private UUID commentId;
    private String comment;

    public CommentDto() {

    }

    public CommentDto(UUID feedbackId, UUID commentId, String comment) {
        this.feedbackId = feedbackId;
        this.commentId = commentId;
        this.comment = comment;
    }

    public void setFeedbackId(UUID feedbackId) {
        this.feedbackId = feedbackId;
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


}
