package com.github.hieuvv.da.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * There are three rule when create recursion algorithm
 * 1. Identify the base case
 * 2. identify the recursive case
 * 3. Get closer and closer and return when needed. Usually you have 2 returns
 */
public class DemoRecursion {

    public static void main(String[] args) {

//        System.out.println(inception(0));

//        System.out.println(findFactorialIterative(5));
//
//        System.out.println(findFactorialRecursive(5));

//        int[] answer = fibonacciRecursive(144, new int[] {0, 1});
//        if (answer == null) {
//            System.out.println("Not found fibonacci");
//        } else {
//            System.out.println(answer[0]  + "\t" + answer[1]);
//        }
//        System.out.println(fibonacciIterative(144));

//        System.out.println(findFibonacciIterative2(6));
//        System.out.println(findFibonacciRecursive2(6));

        System.out.println(reversesStringIterative("yoyo mastery"));



    }

    static String inception(int number){
        System.out.println(number);
        if (number > 3) {
            return "done!";
        }
        number++;
        return inception(number);
    }

    // Write two function that finds the factorial of any number.
    // One should use recursive, the other should just use for loop

    // Big  O O{n)
    static int findFactorialRecursive(int number) {
        if (number == 2) {
            return 2;
        }

        return number * findFactorialRecursive(number -1);
    }

    // Big O => O(n)
    static int findFactorialIterative(int number) {
        int answer = 1;

        if (number == 2) {
            answer = 2;
        }
        for (int i = number; i > 1; i--) {
            answer *= i;
        }
        return answer;
    }

    // Given a number N return the index value of the Fibonacci
    //sequence, where the sequence is:
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
    // the pattern of the sequence is that each value is the sum of
    // the 2 previous values, that means that for N=5 ->2+3
   static String fibonacciIterative(int number) {
        int[] twoSequenceFibonacci = new int[] {0, 1};

        while (twoSequenceFibonacci[0] + twoSequenceFibonacci[1] <= number) {
            if (twoSequenceFibonacci[0] + twoSequenceFibonacci[1]  == number) {
                return "answer: " + twoSequenceFibonacci[0] + "\t" + twoSequenceFibonacci[1];
            }
            twoSequenceFibonacci =  new int[] {twoSequenceFibonacci[1], twoSequenceFibonacci[0] + twoSequenceFibonacci[1]};
        }
        return "answer: null";
    }

   static int[] fibonacciRecursive(int number, int answer[]) {

        if ((answer[0] + answer[1]) == number) {
            return answer;
        }

        if ((answer[0] + answer[1]) > number) {
            return null;
        }

        return fibonacciRecursive(number, new int[] {answer[1], answer[0] + answer[1]});
    }

    static int findFibonacciIterative2(int number) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);

        for (int i = 2; i < number + 1; i++) {
            arr.add(arr.get(i - 2) + arr.get(i - 1));
        }

        return arr.get(number);
    }

    static int findFibonacciRecursive2(int number) {

        if (number < 2) {
            return number;
        }

        return findFibonacciRecursive2(number - 1) + findFibonacciRecursive2(number -2);
    }

    //Implement a function that reverses a string using iteration...and then recursion!
    //Give an input "yoyo mastery" should return "yretsam oyoy"
    static String reversesStringIterative(String str) {

        String answer = "";
        int length = str.length();
        for (int i = length - 1; i>=0; i--) {
            answer+= str.charAt(i);
        }
        return answer;
    }




}
