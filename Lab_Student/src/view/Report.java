/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author dattn
 */
public class Report {
    private String id, name;
    private int totalCourse;
    private int course;

    public Report(String id, String name, int totalCourse, int course) {
        this.id = id;
        this.name = name;
        this.totalCourse = totalCourse;
        this.course = course;
    }
    
 
    
     public String getCourseString() {
        String res = "";
        switch (course) {
            case 1:
                res = "Java";
                break;
            case 2:
                res = ".NET";
                break;
            case 3:
                res = "C/C++";
                break;
        }
        return res;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s", name,getCourseString(),totalCourse);
    }
     
     
}
