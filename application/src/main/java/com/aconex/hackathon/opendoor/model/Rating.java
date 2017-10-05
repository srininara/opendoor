package com.aconex.hackathon.opendoor.model;

public class Rating {
    private int upvotes;
    private int downvotes;

    public Rating() {
    }

    public Rating(int upvotes, int downvotes) {
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void incrementUpvotes(int count) {
        upvotes += count;
    }

    public void incrementDownvotes(int count) {
        downvotes += count;
    }
}
