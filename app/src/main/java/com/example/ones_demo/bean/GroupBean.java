package com.example.ones_demo.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kujin
 * @version 1.0
 * @date 2019/9/18 0018 14:53
 */
public class GroupBean {
    private int img;
    private String txt;
    private List<ChildBean> list_child = new ArrayList<ChildBean>();
    public List<ChildBean> getList_child() {
        return list_child;
    }

    public void setList_child(List<ChildBean> list_child) {
        this.list_child = list_child;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
