package com.anshul5404834.stackoverflow_app;

public class stack_pojo {

public  stack_pojo(String title,String link){
    this.TITLE=title;
    this.link_stack=link;

}

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getLink_stack() {
        return link_stack;
    }

    public void setLink_stack(String link_stack) {
        this.link_stack = link_stack;
    }

    public String TITLE;
    public String link_stack;
}
