package com.github.hieuvv.da.search;

public class DemoSearch {

    public static void main(String[] args) {

        int[] number = new int[] {1, 3 ,5, 6, 8, 22, 55, 98, 111, 234, 1000};

        binarySearch(number, 1000);

    }

    /* Linear search has time complexity at worst case O(n) */
    static void LinearSearch(String[] arr, String value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)) {
                System.out.println("Found value with index: " + i);
                return;
            }
        }
        System.out.println("The value not found");
    }

    static void binarySearch(int[] numbers, int value) {

        int high = numbers.length - 1;
        int low = 0;
        while (low <= high) {
            int index = (high + low) / 2;
            if (numbers[index] > value) {
                high = index - 1;
            } else if (numbers[index] < value) {
                low = index + 1;
            } else {
                System.out.println("Found value with index: " + index);
                return;
            }
        }
        System.out.println("The value not found");
    }
}
