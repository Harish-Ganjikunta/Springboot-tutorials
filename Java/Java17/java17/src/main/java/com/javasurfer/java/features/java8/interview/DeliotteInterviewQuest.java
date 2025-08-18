package com.javasurfer.java.features.java8.interview;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DeliotteInterviewQuest {

    public static void main(String[] args) {
        //stringTest();
        System.out.println("Value from getValue: " + new DeliotteInterviewQuest().getValue());
        /*Parent p = new DeliotteInterviewQuest().new Child();
        p.print();
        System.out.println("Value from Parent: " + p.value);*/
    }
    private static List<Employee> employees;

    static {
                employees = List.of(
                new Employee(1,"Alice@gmail.com", "745757","Alice", 30, "HR"),
                new Employee(2, "Bob@gmail.com", "745757","Bob", 28, "Finance"),
                new Employee(3, "Anna@gmail.com", "745757","Anna", 25, "IT"),
                new Employee(4, "Brian@gmail.com", "745757","Brian", 35, "Marketing")
        );

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
     * Deliotte interview question
     */
    public static void stringTest() {
        final String a = "Hello";

        final String b = "World";

        String c = "HelloWorld";

        String d = a+b;

        System.out.println(c==d);
    }
    int getValue() {

        int i =1;

        try{
            i=i+1;
            return i;
        } catch(Exception ex){
            i=i+2;
        } finally {
            i=i+3;
            //return i;
        }
        return i;

    }

    class Parent {

        int value=1;

        public void print(){
            System.out.println("hello parent");
        }
    }

    //child class

    class Child extends Parent {

        int value = 2;
        public void print(){
            System.out.println("hello child");
        }
    }


}
