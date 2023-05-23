package com.example.game.mysocialmedia.Model;

public class Follow {

    private String followedBy;
    private long followedAt;

    public Follow(String followedBy, long followedAt) {
        this.followedBy = followedBy;
        this.followedAt = followedAt;
    }

    public Follow() {
    }

    public String getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(String followedBy) {
        this.followedBy = followedBy;
    }

    public long getFollowedAt() {
        return followedAt;
    }

    public void setFollowedAt(long followedAt) {
        this.followedAt = followedAt;
    }
}
