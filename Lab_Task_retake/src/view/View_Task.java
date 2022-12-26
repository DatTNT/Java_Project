/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.ManageTask;
import model.Task;

public class View_Task {
    ManageTask manage = new ManageTask();
    Task task = new Task();
    
    void displayAddTask() {
        //input task
        System.out.println("------------Add Task---------------");
        String requirement = getRequirementName();
        int taskType = getTaskType(); 
        String date = getDate();
        double from = getFrom();
        double to = getTo(from);
        String assignee = getAssignee();
        String reviewer = getReviewer();
        int id;
        
        
        //add Task 
        int result = manage.addTask(requirement, taskType, date, from, to, assignee, reviewer);
        
        //if result = -1 => overlaps task
        if (result == -1) {
            System.out.println("Overlaps task");
        }
        // not equal -1 => add successfull
        else {
            System.out.println("Add successful");
           
        }
    }
    
    private String getRequirementName() {
        String requirement = Validate.getString("Requirement Name: ", "Requirement "
                + "Name must be letters or digits", Validate.REGEX_STRING);
        return requirement;
    }
    
    private int getTaskType() {
        int result = Validate.getInt("Enter task type: ", "It must be from 1-4",
                "It must be from 1-4", "It must be digits", 1, 4);
        return result;
    }
     /**
      * get an date from keyboard
      * @return date 
      */
     private String getDate() {
        String date = Validate.getDate("Enter date: ", "date must be format dd-MM-yyyy"
                , "Date does not exist", "Date must be greater or equal to current date");
        return date;
    }

    private double getFrom() {
        double from = Validate.getDouble("Enter from: ","Wrong", "Wrong","Wrong", 8, 17);
        return from;
    }

    private double getTo(double from) {
        double to = Validate.getDouble("Enter to: ","Wrong", "Wrong","Wrong", from + 0.5, 17.5);
        return to;
    }

    private String getAssignee() {
        String assignee = Validate.getString("Enter assignee: ",  "Wrong", Validate.REGEX_STRING);
        return assignee;
    }

    private String getReviewer() {
        String reviewer = Validate.getString("Enter reviewer: ",  "Wrong", Validate.REGEX_STRING);
        return reviewer;
    }

    void displayRemoveList() {
        //input id
        int id = Validate.getInt("Enter id: ",
                "Wrong", "Wrong", "Wrong", Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        //check task have id exist
        Task result = manage.checkTaskExist(id); 
        
        //not found
        if (result == null) {
            System.out.println("NOT FOUND TASK !!");
        }else {
            //found
            manage.removeTask(result);
            System.out.println("DELETE SUCCESSFULL !!");
        }
        
    }

    void displayTaskList() {
        System.out.format("%-10s %-15s %-10s %-15s %-15s %-15s %-15s\n", "Id", "Name","TaskType",
                "Date", "Time", "Assignee", "Reviewer");
        for (Task task : manage.getListTask()) {
            System.out.println(task);
        }
    }

}
