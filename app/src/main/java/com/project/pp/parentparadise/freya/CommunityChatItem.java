package com.project.pp.parentparadise.freya;

/**
 * Created by mac on 2017/12/13.
 */

public class CommunityChatItem {

    private int chatimage;
    private String chatName;




    public CommunityChatItem(int chatimage, String chatName) {
        super();
        this.chatimage = chatimage;
        this.chatName = chatName;


    }


    public int getImage() {
        return chatimage;
    }

    public void setImage(int chatimage) {
        this.chatimage = chatimage;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
}
