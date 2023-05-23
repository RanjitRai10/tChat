package com.example.game.mysocialmedia.Model;

public class storyModel {
    String name;
    int story,profile;

    public storyModel(String name,  int story, int profile) {
        this.name = name;
        this.story = story;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStory() {
        return story;
    }

    public void setStory(int story) {
        this.story = story;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }
}
