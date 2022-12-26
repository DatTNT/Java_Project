/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.ArrayList;
import model.Task;

public class ManageTask {
    ArrayList<Task> listTask;
    
    /**
     * Constructor default
     */
    public ManageTask() {
        listTask = new ArrayList<>();
        listTask.add(new Task(1,"TienDat", 1, "04-12-2022", 8, 17, "asdasdasd", "asdsadzxc"));
        listTask.add(new Task(2,"Hehe", 1, "04-12-2022", 8, 17, "asdzxcvbqa", "xzcxz"));
        listTask.add(new Task(3,"hoho", 1, "04-12-2022", 8, 17, "asdaswqrtcv", "vcxbt6y"));
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }
    
    public int addTask(String requirement, int taskType, String date, double from,
            double to, String assignee, String reviewer) {
        int id;
        //check duplicate => duplicate => return -1 
        if (checkOverlaps(date, assignee, from, to)) {
            return -1;
        } //else return id
        else {
            if(listTask.isEmpty()){
                id = 1;
            }else{
                id = getId() + 1;
            }
            //create instance
            Task task = new Task(id,requirement, taskType, date, from, to, assignee, reviewer);
            //add to list
            listTask.add(task);
            //return
            return task.getId();
        }
        
    }
    
    //ham de kiem tra xem tat ca cac thuoc tinh nhap vao co ko bi overlaps ko
    // => true => bi overlaps
    // => false => ko bi overlaps
    public boolean checkOverlaps(String date, String assignee, double from, double to) {

        //parameter: ki hieu la 2
        //task in list: ki hieu la 1
        for (Task task : listTask) {
            //if date and assignee of task equal to parameter then compare to plan To
            if (task.getDate().compareTo(date) == 0 && task.getAssignee().compareTo(assignee) == 0) {

                /*NOTE
            	 * from2 : parameter (user add on method "add task")
            	 * from1 : from of task already in list 
            	 * to2   : parameter ( user add on method "add task")
            	 * to1   : to of task already in list
            	 * */
                //if from1 > from2 && to2 > from1
                if (from < task.getFrom() && to > task.getFrom()) {
                    return true;
                }
                //if from2 = from1  => return true
                if (from == task.getFrom()) {
                    return true;
                }
                // if from1 < from2 < to1=> return true
                if (from > task.getFrom()
                        && from < task.getTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Task checkTaskExist(int id) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void removeTask(Task result) {
        listTask.remove(result);
    }

    public int getId() {
        Task task = listTask.get(listTask.size() - 1);
        return task.getId();
    }
    
    
    
}
