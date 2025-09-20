package com.javasurfer.java.features.java8.interview;

public class B extends A {
    int i = 30;
    int j = 40;

    void m1() {
        System.out.println(i);
    }

    void m2() {
        System.out.println(j);
    }


    public static void main(String[] args) {
        A a = new B();
        //B b = new A(); // Compile time error

        a.m1();
        a.m2();
         System.out.println(a.i);
         System.out.println(a.j);
    }

}