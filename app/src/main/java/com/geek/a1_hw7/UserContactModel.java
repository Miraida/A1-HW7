package com.geek.a1_hw7;

import java.io.Serializable;

public class UserContactModel implements Serializable {
    private  String name, title;
    private int image;

    public UserContactModel(){}
    public UserContactModel(String name, String title, int image) {
        this.name = name;
        this.title = title;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
