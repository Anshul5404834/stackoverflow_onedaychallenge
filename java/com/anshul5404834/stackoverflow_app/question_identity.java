package com.anshul5404834.stackoverflow_app;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class question_identity {
    public String titles;

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getLink_stack() {
        return link_stack;
    }

    public void setLink_stack(String link_stack) {
        this.link_stack = link_stack;
    }

    public  String link_stack;

    @PrimaryKey(autoGenerate = true)
    public int pk;
}
