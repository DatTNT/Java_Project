/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.ManageTask;
import java.util.ArrayList;

/**
 *
 * @author dattn
 */
public class Task {

//    public static int taskUserID = 1;
//    ManageTask manage = new ManageTask();
    
    private int id;
    private String requirmentName;
    private int taskType;
    private String date;
    private double from;
    private double to;
    private String Assignee;
    private String reviewer;

    

    public Task() {
    }

    public Task(int id,String requirmentName, int taskType, String date, double from, double to, String Assignee, String reviewer) {

        
        this.id = id;
        this.requirmentName = requirmentName;
        this.taskType = taskType;
        this.date = date;
        this.from = from;
        this.to = to;
        this.Assignee = Assignee;
        this.reviewer = reviewer;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getRequirmentName() {
        return requirmentName;
    }

    public void setRequirmentName(String requirmentName) {
        if (this.requirmentName != null) {
            this.requirmentName = requirmentName;
        }
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        if (taskType > 0) {
            this.taskType = taskType;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null) {
            this.date = date;
        }
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        if (from > 0) {
            this.from = from;
        }
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        if (to > 0) {
            this.to = to;
        }
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        if (Assignee != null) {
            this.Assignee = Assignee;
        }
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        if (reviewer != null) {
            this.reviewer = reviewer;
        }
    }

    public String getTextTaskType() {
        String res = "";

        switch (taskType) {
            case 1:
                res = "Code";
                break;
            case 2:
                res = "Test";
                break;
            case 3:
                res = "Design";
                break;
            case 4:
                res = "Review";
                break;
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-15s%-15s%-15s%-15s%-15s", id, requirmentName, getTextTaskType(), date, to - from, Assignee, reviewer);
    }

}
