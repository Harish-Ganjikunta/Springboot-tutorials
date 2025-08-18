package com.javasurfer.java.features.java8.interview;

public class Employee {

    private int id;
    private String email;
    private String phoneNumber;

    private String name;
    private int age;
    private String department;

    public Employee(int id, String email, String phoneNumber, String name, int age, String department) {
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
