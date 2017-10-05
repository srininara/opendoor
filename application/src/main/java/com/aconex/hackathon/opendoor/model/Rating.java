package com.aconex.hackathon.opendoor.model;

public class Rating {
    private Integer upvotes;
    private Integer downvotes;

    public Rating() {
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void incrementUpvotes(Integer count) {
        upvotes += count;
    }

    public void incrementDownvotes(Integer count) {
        downvotes += count;
    }
}
