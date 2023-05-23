package com.example.game.mysocialmedia.Model;

public class dashboarModel {
    int profileImg,post;
    String name,about,like,comment,share;

    public dashboarModel(int profileImg, int post, String name, String about, String like, String comment, String share) {
        this.profileImg = profileImg;
        this.post = post;
        this.name = name;
        this.about = about;
        this.like = like;
        this.comment = comment;
        this.share = share;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
}
