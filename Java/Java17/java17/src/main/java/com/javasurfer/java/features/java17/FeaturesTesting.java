package com.javasurfer.java.features.java17;

public class FeaturesTesting {

    /*  //Pattern Matching For Switch Statements are not working in 17

    private static String processPayment(Object object){
        String result = switch(object){
            case CreditCardPayment creditCardPayment -> "Processing String: " + creditCardPayment.cardNumber();
            case Integer i -> "Processing Integer: " + i;
            case Double d -> "Processing Double: " + d;
            default -> "Unknown type";
        };
    }*/


    public static String java12SwitchExpression(int dayNum){
        return switch(dayNum){
            case 1->"Sunday";
            case 2->"Monday";
            case 3->"Tuesday";
            case 4->"Wednesday";
            case 5->"Thursday";
            case 6->"Friday";
            case 7->"Saturday";
            default -> "Invalid Day";
        };
    }


    public static void main(String[] args) {
        System.out.println(java12SwitchExpression(2));
    }
}
