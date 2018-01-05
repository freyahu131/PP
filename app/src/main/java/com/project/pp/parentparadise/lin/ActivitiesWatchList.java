package com.project.pp.parentparadise.lin;

/**
 * Created by lin on 2017/12/10.
 */

public class ActivitiesWatchList {

    private int image, like, watch, msg;
    private String title;

    public ActivitiesWatchList() {
        super();
    }

    public ActivitiesWatchList(int image, String title, int like, int watch, int msg) {
        super();
        this.image = image;
        this.title = title;
        this.like = like;
        this.watch = watch;
        this.msg = msg;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getWatch() {
        return watch;
    }

    public void setWatch(int watch) {
        this.watch = watch;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
