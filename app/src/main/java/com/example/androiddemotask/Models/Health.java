package com.example.androiddemotask.Models;

public class Health {
    private String title;
    private String image;
    private String summary;
    private String total_views;
    private String total_likes;

    public Health(String title, String image, String summary, String total_views, String total_likes) {
        this.title = title;
        this.image = image;
        this.summary = summary;
        this.total_views = total_views;
        this.total_likes = total_likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTotal_views() {
        return total_views;
    }

    public void setTotal_views(String total_views) {
        this.total_views = total_views;
    }

    public String getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(String total_likes) {
        this.total_likes = total_likes;
    }
}
