package com.example;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 15; i++) {

            String firstFake = faker.name().firstName();
            String lastFake = faker.name().lastName();

            Student student = new Student();

            student.setFirstName(firstFake);
            student.setLastName(lastFake);

            student.setId(i);
            student.setGrade(1);
            students.add(student);

        }

        for (int i = 0; i < 3; i++) {

            String firstFake = faker.name().firstName();
            String lastFake = faker.name().lastName();

            Teacher teacher = new Teacher();

            teacher.setFirstName(firstFake);
            teacher.setLastName(lastFake);

            teacher.setId(i);
            teacher.setGrade(1);
            teachers.add(teacher);
        }

        HashMap<Teacher, HashSet<Student>> teacherClasses = new HashMap<>();

        for (int teacherIndex = 0; teacherIndex < teachers.size(); teacherIndex++) {
            Teacher teacher = teachers.get(teacherIndex);
            Integer studentMultiplyer = teacherIndex + 1;
            HashSet<Student> classes = new HashSet<>();

            for (int studentIndex = (students.size()/teachers.size()) * teacherIndex; studentIndex < 5 * studentMultiplyer; studentIndex++) {
                classes.add(students.get(studentIndex));
            }
            teacherClasses.put(teacher, classes);
        }
//        System.out.println("****************************************** \n");
//        for (HashMap.Entry teacher: teacherClasses.entrySet()) {
//            System.out.println("Teacher: " + teacher.getKey() + "\n" + "Students: \n" + teacher.getValue().toString() + "\n" + "*******************************************" + "\n");
//        }

        String output = "";

        output += ClassHTMLTemplate.header;

        for (Teacher teacher: teacherClasses.keySet() ) {
            String teacherRow = ClassHTMLTemplate.personRow;
            teacherRow = teacherRow.replace("{{type}}", "Teacher");
            teacherRow = teacherRow.replace("{{id}}", teacher.getId().toString());
            teacherRow = teacherRow.replace("{{grade}}", teacher.getGrade().toString());
            teacherRow = teacherRow.replace("{{firstName}}", teacher.getFirstName().toString());
            teacherRow = teacherRow.replace("{{lastName}}", teacher.getLastName().toString());
            output += teacherRow;
            HashSet<Student> studentsInClass = teacherClasses.get(teacher);
            for (Student student: studentsInClass) {
                String studentRow = ClassHTMLTemplate.personRow;
                studentRow = studentRow.replace("{{type}}", "Student");
                studentRow = studentRow.replace("{{id}}", student.getId().toString());
                studentRow = studentRow.replace("{{grade}}", student.getGrade().toString());
                studentRow = studentRow.replace("{{firstName}}", student.getFirstName().toString());
                studentRow = studentRow.replace("{{lastName}}", student.getLastName().toString());
                output += studentRow;
            }
        }

        output += ClassHTMLTemplate.footer;

        try {
            File file = new File("output.html");
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(output);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output);
    }
}
