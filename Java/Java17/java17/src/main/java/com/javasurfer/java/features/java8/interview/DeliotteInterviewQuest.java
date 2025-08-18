package com.javasurfer.java.features.java8.interview;

public class DeliotteInterviewQuest {

    public static void main(String[] args) {
        //stringTest();
        System.out.println("Value from getValue: " + new DeliotteInterviewQuest().getValue());
        /*Parent p = new DeliotteInterviewQuest().new Child();
        p.print();
        System.out.println("Value from Parent: " + p.value);*/
    }

    /**
     * Deliot interview question
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
