package com.kuang.method;

import java.util.Scanner;

public class HomeworkCalculator {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter an number: ");
            double sa = scanner.nextDouble();
            System.out.println("Please enter another number: ");
            double sb = scanner.nextDouble();

            System.out.println("Please enter the method ");
            String sc = scanner. next();

            switch (sc){
                case "+":
                    System.out.println(add(sa,sb));
                    break;
                case "-":
                    System.out.println(sub(sa,sb));
                    break;
                case "*":
                    System.out.println(ride(sa,sb));
                    break;
                case "/":
                    System.out.println(div(sa,sb));
                    break;
            }
        }
    }

    public static double add(double a,double b){
        return a+b;
    }

    public static double sub(double a,double b){
        return a-b;
    }

    public static double ride(double a,double b){
        return a*b;
    }
    public static double div(double a,double b){
        return a/b;
    }
}
