package com.github.hieuvv.da.array;

public class MergeSortedArrays {

    static int[] mergeTwoArraySorted(int[] array1, int[] array2) {
        // check input
        if (array1 == null || array1.length == 0) {
            return array2;
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }

        int array1Item = array1[0];
        int array2Item = array2[0];
        int lengthArray1 = array1.length;
        int lengthArray2 = array2.length;
        int totalItem = lengthArray1 + lengthArray2;
        int[] array = new int[lengthArray1 + lengthArray2];

        int i = 1;
        int j = 1;
        int k = 0;
        while (k < totalItem) {
            if (i == lengthArray1 && j < lengthArray2) {
                array[k] = array2Item;
                array2Item = array2[j++];
            } else if (j == lengthArray2 && i < lengthArray1) {
                array[k] = array1Item;
                array1Item = array1[i++];
            } else if (i == lengthArray1 && j==lengthArray2) {
                if (array1Item < array2Item) {
                    array[k] = array1Item;
                    array[++k] = array2Item;
                } else {
                    array[k] = array2Item;
                    array[++k] = array1Item;
                }
            } else {
                if (array1Item < array2Item) {
                    array[k] = array1Item;
                    array1Item = array1[i++];

                } else {
                    array[k] = array2Item;
                    array2Item = array2[j++];
                }
            }
            k++;
        }
        return array;
    }

    public static void main(String[] args) {

        int[] array1 = new int[]{0, 3, 4, 31, 100, 107};
        int[] array2 = new int[]{4, 6, 30, 101, 105};

        int[] result = mergeTwoArraySorted(array1, array2);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}
