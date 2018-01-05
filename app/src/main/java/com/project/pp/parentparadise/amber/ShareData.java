package com.project.pp.parentparadise.amber;

import android.widget.Spinner;

import java.util.List;

/**
 * Created by amberyang on 2017/12/6.
 */

public class ShareData {

    private int head;
    private String name;
    private String time;
    private int[] photos;
    private String bookName;
    private String author;
    private String publisher;
    private String isbn;
    private String describe;
    private int goodCount;
    private int messageCount;
    private String actID;
    private String message;

    public ShareData(int head, String name, String time,int[] photos,
                     String describe, int goodCount, int messageCount){
        this.head = head;
        this.name = name;
        this.time = time;
        this.photos = photos;
        this.describe = describe;
        this.goodCount = goodCount;
        this.messageCount = messageCount;
    }



    public ShareData(int head, String name, String time,int[] photos,
                     String describe, int goodCount, int messageCount, String actID){
        this.head = head;
        this.name = name;
        this.time = time;
        this.photos = photos;
        this.describe = describe;
        this.goodCount = goodCount;
        this.messageCount = messageCount;
        this.actID = actID;
    }

    public ShareData(int head, String name, String time, int[] photos,
                          String bookName, String author, String publisher, String isbn,
                          String describe, int goodCount, int messageCount) {
        this.head = head;
        this.name = name;
        this.time = time;
        this.photos = photos;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.describe = describe;
        this.goodCount = goodCount;
        this.messageCount = messageCount;
    }





    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public int[] getPhotos() {
        return photos;
    }

    public void setPhotos(int[] photos) {
        this.photos = photos;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(int goodCount) {
        this.goodCount = goodCount;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}