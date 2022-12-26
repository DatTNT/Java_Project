/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import manage.ManageStudent;
import model.Student;

/**
 *
 * @author dattn
 */
public class ViewStudent {

    ManageStudent manage = new ManageStudent();

    void displayCreateStudent() {
        if (manage.getListStudent().size() >= 1) {
            boolean isContinue = checkContinue("Do you want to continue (Y/N)?", "y", Validate.REGEX_YN, "Must be Y/N");
            if (!isContinue) {
                return;
            }
        }

        //input data
        String id = getId();

        //get Student by id
        String name = null;
        Student studentList = manage.getStudentList(id);
        //if student = null => no student in list has id input
        if (studentList == null) {
            name = getName();
        } else {
            //else => there are last one student in list
            System.out.println("Enter name: " + studentList.getName());
        }
        int semester = getSemester();
        int course = getCourse();
        boolean isDuplicate = manage.checkDuplicate(id, name, semester, course);
        //isDuplicate = true ==> error => print error
        if (isDuplicate) {
            System.out.println("DUPLICATE!!");
        } else {
            //else add to list
            manage.addStudentList(id, name, semester, course);
            System.out.println("Success!");
        }
        //checkID - Name
        //check duplicate
        //add to list
    }

    private String getId() {
        String id = Validate.getString("Enter id: ", "Wrong!!!!", Validate.REGEX_STRING);
        return id;
    }

    private String getName() {
        String name = Validate.getString("Enter name: ", "Wrong", Validate.REGEX_STRING);
        return name;
    }

    private int getSemester() {
        int semester = Validate.getInt("Enter semester: ", "Wrong", "Wrong", "Wrong", 1, 10);
        return semester;
        
    }

    private int getCourse() {
        int course = Validate.getInt("Enter your number Course - 1.Java, 2.NET, 3. C/C++)", "Wrong", "Wrong", "Wrong", 1, 3);
        return course;
    }

    private boolean checkContinue(String mess, String inputValue, String regex, String error) {
        String input = Validate.getString(mess, error, regex);
        if (input.equalsIgnoreCase(inputValue)) {
            return true;
        } else {
            System.out.println(error);
        }
        return false;
    }

    void displayFindAndSortStudent() {
        //input name or part of name
        String name = getName();
        //search list student  by name
        ArrayList<Student> listSearch = manage.getListStudentSearch(name);
        //sort
        if (listSearch.isEmpty()) {
            System.out.println("NOT FOUND");
        } else {
            manage.sortListStudent(listSearch);
            //display
            System.out.format("%-15s%-15s%-15s%-15s\n", "ID", "Name", "Semester", "Course");
            for (Student student : listSearch) {
                System.out.println(student);
            }
        }

    }

    void displayUpdateAndDelete() {
        String id = getId();

        ArrayList<Student> listFindIdStudent = manage.getStudentListId(id);

        if (listFindIdStudent.isEmpty()) {
            System.out.println("NOT FOND");
        } else {
            if (checkContinue("Do you want to Update or Delete (U/D)?", "u", Validate.REGEX_UD, "must be dress u or d")) {
                manage.update(listFindIdStudent);
            } else {
                manage.delete(listFindIdStudent);
            }
        }

    }

    void report() {
        manage.reportStudent();
    }

}
