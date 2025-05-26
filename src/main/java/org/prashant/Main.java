package org.prashant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        optionalTest();

//        StudentCourseMatching obj = new StudentCourseMatching();
//        Endings obj = new Endings();
        GridFind obj = new GridFind();
        obj.mainCaller();
    }

    public static void streamTest() {
        System.out.println("Hello and welcome!");

        Student student1 = new Student("a",1,4);
        Student student2 = new Student("b",2,4);
        Student student3 = new Student("c",3,6);

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);

        List<Student> filteredList = new ArrayList<>();
        for (Student student : students) {
            if (student.isSeniorStudent()) {
                filteredList.add(student);
            }
        }
        List<String> books1 = Arrays.asList(new String[]{"car", "star"});
        List<String> books2 = Arrays.asList(new String[]{"mobile", "bike"});
        List<String> books3 = Arrays.asList(new String[]{"wire", "ball"});
        student1.setBooks(books1);
        student2.setBooks(books2);
        student3.setBooks(books3);

        List<Student> filteredStudents2 = students.stream().filter(Student::isSeniorStudent).toList();

        List<Student> filteredStudents3 = students.stream().filter(s -> s.isSeniorStudent())
                .toList();

        System.out.println(filteredList.equals(filteredStudents2));
        System.out.println(filteredList.equals(filteredStudents3));

        List<Student> filteredStudents4 = students.stream().filter(StudentUtil::isSeniorStudentUtil).toList();


        List<String> books = students.stream().flatMap(s -> s.getBooks().stream()).toList();

        books.forEach(System.out::println);

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
//        boolean isExist2 = list.stream().anyMatch(String::contains("a"));
//
//        boolean isEmpty = list.stream().anyMatch(String::isEmpty);
//        boolean isEmpty = list.stream().anyMatch(String::contains("a"));

    }

    public static void optionalTest() {

//        String str ="car";
//        Optional<String> optStr = Optional.of(str);
//
//        System.out.println(optStr.orElse(""));
//        System.out.

    }
}