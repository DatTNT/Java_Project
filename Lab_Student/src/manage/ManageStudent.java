/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Student;
import view.Report;
import view.Validate;

/**
 *
 * @author dattn
 */
public class ManageStudent {

    ArrayList<Student> listStudent;
    ArrayList<Report> listReport;
    static Validate valid = new Validate();

    public ManageStudent() {
        listStudent = new ArrayList<>();
        listReport = new  ArrayList<>();
        listStudent.add(new Student("1", "TienDatD", 1, 1));
        listStudent.add(new Student("1", "TienDatD", 3, 1));
        listStudent.add(new Student("2", "TienDatC", 2, 1));
        listStudent.add(new Student("3", "TienDatB", 1, 2));
        listStudent.add(new Student("4", "TienDatA", 3, 1));
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public Student getStudentList(String id) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean checkDuplicate(String id, String name, int semester, int course) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(id)
                    && student.getName().equalsIgnoreCase(name)
                    && student.getSemester() == semester
                    && student.getCourse() == course) {
                return true;
            }
        }
        return false;
    }

    public void addStudentList(String id, String name, int semester, int course) {
        Student student = new Student(id, name, semester, course);

        listStudent.add(student);
    }

    public ArrayList<Student> getListStudentSearch(String name) {
        name = name.toUpperCase();
        ArrayList<Student> listSearch = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getName().toUpperCase().contains(name)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

    public ArrayList<Student> sortListStudent(ArrayList<Student> listSearch) {
        Collections.sort(listSearch, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName()); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        return listSearch;
    }

    public ArrayList<Student> getStudentListId(String id) {
        id = id.toUpperCase();
        ArrayList<Student> listSearch = new ArrayList<>();
        for (Student student : listStudent) {
            if (student.getId().toUpperCase().contains(id)) {
                listSearch.add(student);
            }
        }
        return listSearch;
    }

    public void update(ArrayList<Student> listFindIdStudent) {
        //Print listFoundIdStudent
        System.out.format("%-10s%-10s%-15s%-15s%-15s\n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listFindIdStudent.size(); i++) {
            System.out.format("%-10s %s\n", i + 1, listFindIdStudent.get(i));

        }
        int choice = valid.getInt("Enter no", "wrong", "wrong", "wrong", 1, getListStudent().size() - 1);
        Student studentChoice = listFindIdStudent.get(choice - 1);
        String idUpdate = studentChoice.getId();
        String nameUpdate = studentChoice.getName();
        int semesterUpdate = studentChoice.getSemester();
        int courseUpdate = studentChoice.getCourse();

        //update
        if (checkUpdate("id")) {
            idUpdate = getId();
        }
        if (checkUpdate("name")) {
            nameUpdate = getName();
        }
        if (checkUpdate("semester")) {
            semesterUpdate = getSemester();
        }
        if (checkUpdate("course")) {
            courseUpdate = getCourse();
        }

        //check not update
        if (checkNotUpdate(idUpdate, nameUpdate, semesterUpdate, courseUpdate, studentChoice)) {
            System.out.println("Not update");
        } else if (checkDuplicate(idUpdate, nameUpdate, semesterUpdate, courseUpdate)) {
            System.out.println("Duplicate");
        } else {
            studentChoice.setId(idUpdate);
            updateAllName(idUpdate, nameUpdate);
            studentChoice.setSemester(semesterUpdate);
            studentChoice.setCourse(courseUpdate);
        }

    }

    public void delete(ArrayList<Student> listFindIdStudent) {
        //Print listFoundIdStudent
        System.out.format("%-10s%-10s%-15s%-15s%-15s\n", "No", "ID", "Name", "Semester", "Course");
        for (int i = 0; i < listFindIdStudent.size(); i++) {
            System.out.format("%-10s %s\n", i + 1, listFindIdStudent.get(i));

        }

        //delete id user want
        int choice = Validate.getInt("Enter no", "wrong", "wrong", "wrong", 1, getListStudent().size() - 1);
        Student studentChoice = listFindIdStudent.get(choice - 1);

        listStudent.remove(studentChoice);
        System.out.println("Delete Success");
    }

    private boolean checkUpdate(String id) {
        String res = Validate.getString("Do you want to update " + id + "? (y/n)", "Wrong", Validate.REGEX_YN);
        if (res.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
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

    private boolean checkNotUpdate(String idUpdate, String nameUpdate, int semesterUpdate, int courseUpdate, Student studentChoice) {
        if (idUpdate.equalsIgnoreCase(studentChoice.getId())
                && nameUpdate.equalsIgnoreCase(studentChoice.getName())
                && semesterUpdate == studentChoice.getSemester()
                && courseUpdate == studentChoice.getCourse()) {
            return true;
        } else {
            return false;
        }
    }

    private void updateAllName(String idUpdate, String nameUpdate) {
        for (Student student : listStudent) {
            if (student.getId().equalsIgnoreCase(idUpdate)) {
                student.setName(nameUpdate);
            }
        }
    }

    public void reportStudent() {
        int totalCourse;
        listReport.clear();
        for (Student checkStudent1 : listStudent) {
            if (!checkExitReport(checkStudent1)) {
                totalCourse = 0;
                for (Student checkStudent2 : listStudent) {
                    if (checkStudent1.getId().equalsIgnoreCase(checkStudent2.getId())
                            && checkStudent1.getCourse() == checkStudent2.getCourse()) {
                        totalCourse++;
                    }
                }
                Report report = new Report(checkStudent1.getId(), checkStudent1.getName(), totalCourse, checkStudent1.getCourse());
                listReport.add(report);
            }
        }
        System.out.format("%-15s%-15s%-15s\n","Name", "Course","TotalCourse");
        for (Report student : listReport) {
            System.out.println(student);
        }
    }

    private boolean checkExitReport(Student checkStudent1) {
        for (Report report : listReport) {
            if (report.getId().equalsIgnoreCase(checkStudent1.getId())
                    && report.getCourse() == checkStudent1.getCourse()) {
                return true;
            }
        }
        return false;    
    }
}
