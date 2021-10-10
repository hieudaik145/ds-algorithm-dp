package com.github.hieuvv.da.array;

import java.util.Comparator;

public class StringAndArray {

    // Create a function that reverses a string
    // 'Hi My Nam is Hieu Vo'  should be:
    // 'oV ueiH si maN yM iH'
    static String reverse(String str) {

        //check input
        if (str.isBlank() || str.isEmpty() || str.length() < 2) {
            return "hmm that not good";
        }

        String[] backWards = new String[str.length()];
        int totalItems = str.length() - 1;
        for (int i = totalItems; i >=0; i--) {
            backWards[totalItems  - i] = String.valueOf(str.charAt(i));
        }

        return String.join("", backWards);
    }

    static String reverse2(String str) {
        //check input
        if (str.isBlank() || str.isEmpty() || str.length() < 2) {
            return "hmm that not good";
        }

        int totalItems = str.length() - 1;
        String target = "";
        for(int i  = totalItems; i >= 0; i--) {
            target+= str.charAt(i);
        }

        return target;
    }

    static String reverse3(String str) {

        //check input
        if (str.isBlank() || str.isEmpty() || str.length() < 2) {
            return "hmm that not good";
        }
        //check input
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse3("Hi My Nam is Hieu Vo"));
    }
}
