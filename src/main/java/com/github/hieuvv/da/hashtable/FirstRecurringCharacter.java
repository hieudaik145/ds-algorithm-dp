package com.github.hieuvv.da.hashtable;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRecurringCharacter {

    //Given an array = [2,5,1,2,3,5,1,2,4]:
    //It should return 2

    //Given an array = [2,1,1,2,3,5,1,2,4]:
    //It should return 1

    //Given an array = [2,3,4,5]
    //It should return null

    //Solution1 nested loop
    static Integer firstRecurringCharacter(int [] input) {
        int min = -1;
        for (int i = 0; i < input.length; i++) {
            int numberI = input[i];
            for (int j = i+1; j <input.length; j++) {
                int numberJ = input[j];
                if (numberI == numberJ) {
                    if (j <= min || min == -1) {
                        min = j;
                    }
                }
            }
        } // O(n^2)
        if (min == -1) {
            return null;
        }
        return input[min];
    }

    //Solution2 use HashMap
    static Integer firstRecurringCharacter2(int[] input) {

        Set<Integer> data = new HashSet<>(); // O (n) space complexity

        for (int i = 0; i< input.length; i++) {
            int number = input[i];
            if (data.contains(number)) {
                return number;
            } else {
                data.add(number);
            }
        } // O(n) time complexity

        return null;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,5,1,2,3,5,1,2,4};
        System.out.println(firstRecurringCharacter(input));
        System.out.println(firstRecurringCharacter2(input));
    }


}
