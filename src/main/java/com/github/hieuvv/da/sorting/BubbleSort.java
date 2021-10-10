package com.github.hieuvv.da.sorting;

public class BubbleSort {


    public static void main(String[] args) {

        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
//        int[] numbers = {99, 44, 6, 2, 1};
//        selectionSort(numbers);
//        insertionSortUsingWhile(numbers);

        MergeSort.mergeSort(numbers);


    }

    /**
     * 99, 44, 6, 2, 1,
     * 44 6 2 1 99
     * 6 2 1 44 99
     * 2 1 6 44 99
     * 1 2 6 44 99
     * 1 2 6 44 99
     */
    public static void bubbleSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
            printArray(numbers);
            System.out.println();
        }
    }

    /**
     * 99, 44, 6, 2, 1,
     * 44 99 6 2 1 -> 6 99 44 2 1 -> 2 99 44 6 1 -> 1 99 44 6 2 : i =0
     * 1 44 99 6 2 -? 1 6 99 44 2 -> 1 2 99 44 6 : i = 1
     * 1 2 44 99 6 -> 1 2 6 99 44 : i= 2
     * 1 2 6 44 99 -> 1 2 6 44 99 :i =3
     * 1 2 6 44 99 -> 1 2 6 44 99:i = 4
     */
    public static void selectionSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            int temp = numbers[i];
            for (int j = i + 1; j < length; j++) {
                if (numbers[j] < numbers[i]) {
                    min = j;
                }
            }
            numbers[i] = numbers[min];
            numbers[min] = temp;
            printArray(numbers);
            System.out.println();
        }
    }

    public static void insertionSort(int[] numbers) {

        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            int numberFocus = numbers[i];
            int indexFocus = i;
            for (int j = i - 1; j >= 0; j--) {
                if (numberFocus < numbers[j]) {
                    numbers[indexFocus] = numbers[j];
                    numbers[j] = numberFocus;
                    indexFocus = j;
                } else {
                    break;
                }
            }
        }
        printArray(numbers);
    }

    public static void insertionSortUsingWhile(int[] numbers) {

        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            int numberFocus = numbers[i];
            int indexFocus = i;
            while (indexFocus > 0 && numberFocus < numbers[indexFocus - 1]) {
                numbers[indexFocus] = numbers[indexFocus - 1];
                numbers[indexFocus - 1] = numberFocus;
                indexFocus--;
            }
        }
        printArray(numbers);
    }

    static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
    }
}

class MergeSort {

    static int[] mergeSort(int[] numbers) {

        int length = numbers.length;
        if (length == 1) {
            return numbers;
        }
        // Split array into right and left
        int sizeLeft = length / 2;
        int sizeRight = length - sizeLeft;
        int[] left = new int[sizeLeft];
        int[] right = new int[sizeRight];
        for (int i = 0; i < length; i++) {
            if (i < sizeLeft) {
                left[i] = numbers[i];
            } else {
                right[sizeRight + i - length] = numbers[i];
            }
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        int i = 0;
        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] < right[indexRight]) {
                result[i] = left[indexLeft];
                indexLeft++;
            } else {
                result[i] = right[indexRight];
                indexRight++;
            }
            i++;
        }
        if (indexLeft < left.length) {
            for (int temp = indexLeft; temp < left.length; temp++) {
                result[i++] = left[temp];
            }
        } else {
            for (int temp = indexRight; temp < right.length; temp++) {
                result[i++] = right[temp];
            }
        }

        BubbleSort.printArray(result);
        System.out.println();

        return result;
    }
}
