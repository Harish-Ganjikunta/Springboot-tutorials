package com.javasurfer.java.features.java8.interview;

import java.util.ArrayList;
import java.util.List;

public class OptumIntQues {

    public static void main(String[] args) {
       immutabilityTest();

    }

    public static  void immutabilityTest(){
        // Create an Address object
        Address address = new Address("123 Main St", "Anytown");

        // Create a mutable list of hobbies
        List<String> originalHobbies = new ArrayList<>();
        originalHobbies.add("Reading");
        originalHobbies.add("Gaming");

        // Create an Employee object
        Emp employee = new Emp(101, "Harish", address, originalHobbies);
        System.out.println("Original Employee: " + employee);

        // --- Attempt to modify the Employee's state indirectly ---

        // Modify the original Address object. This will not affect the employee.
        Address originalAddress = new Address("789 Original Rd", "Original City");
        System.out.println("Modified original address: " + originalAddress);
        System.out.println("Employee's address after original modified: " + employee.getAddress());

        // Modify the original hobbies list. This will not affect the employee.
        originalHobbies.add("Traveling");
        System.out.println("Modified original hobbies list: " + originalHobbies);
        System.out.println("Employee's hobbies after original modified: " + employee.getHobbies());

        // Modify the list retrieved from the employee's getter. This also won't work.
        List<String> employeeHobbies = employee.getHobbies();
        employeeHobbies.add("Cooking");
        System.out.println("Modified employee's hobbies list from getter: " + employeeHobbies);
        System.out.println("Employee's original hobbies from another getter call: " + employee.getHobbies());
    }
}
