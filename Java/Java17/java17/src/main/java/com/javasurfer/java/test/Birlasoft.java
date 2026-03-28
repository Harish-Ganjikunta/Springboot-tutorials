package com.javasurfer.java.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Birlasoft {


    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "1", 85));
        students.add(new Student(2, "Bob", "2", 90));
        students.add(new Student(3, "Charlie", "1", 95));

        Optional<Student> highestGrade = students.stream().filter(student ->student.getGrade().equalsIgnoreCase("1")).max(Comparator.comparingInt(Student::getMarks));
        System.out.println(highestGrade.get());
    }
}
