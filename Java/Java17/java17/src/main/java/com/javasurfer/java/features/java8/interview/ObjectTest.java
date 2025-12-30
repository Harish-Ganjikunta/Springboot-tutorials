package com.javasurfer.java.features.java8.interview;

import java.util.*;
import java.util.stream.Collectors;

public class ObjectTest {


    private static final List<Student> students;

    private static final List<Department> departments;

    private static final List<Employee> employees;

    static {
        Student student = new Student(1, "Harish", "harish@gmail.com", "1234567890", "Computer Science");
        Student student1 = new Student(2, "Varma", "varma@gmail.com", "1234567890", "Mechanical Engineering");
        Student student2 = new Student(3, "Hari", "hari@gmail.com", "1234567890", "electrical Engineering");
        Student student3 = new Student(4, "Ganjikunta", "ganjikunta@gmail.com", "1234567890", "civil Engineering");
        Student student4 = new Student(5, "Jyothi", "jyoyhi@gmail.com", "1234567890", "Computer Science");
        Student student5 = new Student(6, "Divya", "divya@gmail.com", "1234567890", "Computer Science");
        students = List.of(student, student1, student2, student3, student4, student5);

        Department department = new Department(1, "cse@gmail.com", "Computer Science", "Building A");
        Department department1 = new Department(2, "eee@gmail.com", "Electrical Engineering", "Building B");
        Department department2 = new Department(3, "mech@gmail.com", "Mechanical Engineering", "Building C");
        Department department3 = new Department(4, "civil@gmail.com", "Civil Engineering", "Building D");
        Department department4 = new Department(5, "it@gmail.com", "Information Technology", "Building E");
        Department department5 = new Department(6, "data@gmail.com", "Data Science", "Building F");
        departments = List.of(department, department1, department2, department3, department4, department5);

        employees = List.of(
                new Employee(1,"Alice@gmail.com", "745757","Alice", 30, "HR",25000.0),
                new Employee(2, "Bob@gmail.com", "745757","Bob", 28, "Finance",50000.0),
                new Employee(3, "Anna@gmail.com", "745757","Anna", 25, "IT",1000000.0),
                new Employee(4, "Brian@gmail.com", "745757","Brian", 35, "Marketing",30000.0)
        );
    }

    public static void main(String[] args) {
        System.out.println("ObjectTest is running.");
        //getStudentsEmails();
        //getStudentsEmailsInAString();
        getEmployeeNamesAsSetWithKeyAsFirstLetter();
        filterSortGroupEmployees();
        String value = "Harish".toLowerCase();

        Exception ex = new RuntimeException("test exception");
        Object[] exceps= ex.getStackTrace();
    }

    public static void getStudentsEmails() {
        List<String> studentEmails= students.stream().map(Student::getEmail).toList();
        System.out.println("Student Emails: " + studentEmails);
    }

    public static void getStudentsEmailsInAString() {
        String studentEmailsString= students.stream().map(Student::getEmail).collect(Collectors.joining(","));
        System.out.println("Student Emails: " + studentEmailsString);
    }

    public static void getEmployeeNamesAsSetWithKeyAsFirstLetter(){
        var employeeNamesSet = employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.getName().substring(0, 1).toUpperCase(),
                        Collectors.mapping(Employee::getName, Collectors.toSet())
                ));
        System.out.println("Employee Names Set with Key as First Letter: " + employeeNamesSet);
        Map<Character, Set<String>> groupedNames = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getName().charAt(0),
                        Collectors.mapping(Employee::getName, Collectors.toSet())
                ));
        System.out.println("Grouped Employee Names by First Letter: " + groupedNames);
    }
    /**
     * Filter employees with salary > 50,000.
     * Sort them by salary (descending).
     * Group them by department.
     * Collect all employees in each department
     */

    public static void filterSortGroupEmployees(){
       Map<String,List<Employee>> departmentEmployees =  employees.stream().filter(employee -> employee.getSalary()>50_000).sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).
             collect(Collectors.groupingBy(Employee::getDepartment,Collectors.toList()));
        System.out.println("Department Employees with salary > 50,000: " + departmentEmployees);
       /* Map<String, List<Employee>> grouped = employees.stream()
                .filter(e -> e.getSalary() > 50_000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        LinkedHashMap::new,                      // preserve department insertion order
                        Collectors.toList()                      // collect employees per department
                ));

        grouped.forEach((dept, emps) -> System.out.println(dept + " -> " + emps));*/
    }

}
