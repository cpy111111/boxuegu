package com.example.boxuegu.activity.bean;

import java.io.Serializable;
import java.util.List;

public class ExercisesBean implements Serializable{
    private static final long serialVersionUID =1L;
    private int id;
    private String chapterName;
    private int totalNum;
    private int background;
    private List<ExercisesDetailBean> detailList;

    public int getId() {
        return id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public int getBackground() {
        return background;
    }

    public List<ExercisesDetailBean> getDetailList() {
        return detailList;
    }
}