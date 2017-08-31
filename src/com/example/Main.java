package com.example;

import com.github.javafaker.Faker;

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


        System.out.println(teacherClasses);
    }
}
