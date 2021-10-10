package com.github.hieuvv.da.array;

import java.util.HashMap;
import java.util.Map;

public class ArrayStructure<T> {

    private int length;

    private Map<Integer, T> data;

    public ArrayStructure() {
        data = new HashMap<>();
        length = 0;
    }

    public Object get(Integer index) {  // O(1) complexity
        if (index < 0 || index > length -1) {
            throw new IllegalArgumentException("Array index of bound length" + length);
        }
        return data.get(index);
    }

    public void push(T item) { // O(1) complexity
        data.put(length, item);
        length++;
    }

    public void pop() {  // O(1) complexity
        data.remove(length -1);
        length--;
    }

    public void delete(Integer index) { // O(N) complexity
        shiftItems(index);
    }

    public void shiftItems(int index) {
        for (int i = index; i < length; i++) {
            data.put(i, data.get(i + 1));
        }
        data.remove(length - 1);
        length--;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "ArrayStructure{" +
                "length=" + length +
                ", datas=" + data +
                '}';
    }

    public static void main(String[] args) {

        ArrayStructure arrayStructure = new ArrayStructure<String>();

        System.out.println(arrayStructure.getLength());

        arrayStructure.push("aa");
        arrayStructure.push("hieuvv");

        System.out.println(arrayStructure.toString());

        arrayStructure.pop();

        System.out.println(arrayStructure.toString());

        arrayStructure.push("vo van hieu");

        System.out.println(arrayStructure.toString());

        System.out.println(arrayStructure.get(1));

        arrayStructure.push("bbb");
        arrayStructure.push("ccc");
        arrayStructure.push("ddd");

        System.out.println(arrayStructure.toString());
        arrayStructure.delete(3);
        System.out.println(arrayStructure.toString());

    }
}
