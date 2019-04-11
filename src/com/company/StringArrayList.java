package com.company;

public class StringArrayList {

    String[] stringArray = new String[3];
    int currentIndex = 0;

    public static void main(String[] args) {
        StringArrayList list = new StringArrayList();
        list.add("Jen");
        list.add("Asella");
        list.add("Cindy");

        list.printSize();
        list.printAllElement();
        list.printElement(1);

        list.remove("Jen");
        list.printSize();
        list.printAllElement();

        list.add("Jen");
        list.printAllElement();

    }

    void add(String item) {
        if (currentIndex == stringArray.length) {
            String[] newStringArray = new String[stringArray.length + 10];
            for (int i = 0; i < stringArray.length; i++) {
                newStringArray[i] = stringArray[i];
            }

            stringArray = newStringArray;
        }

        stringArray[currentIndex] = item;
        currentIndex++;
    }

    void remove(String item) {
        for (int i = 0; i < currentIndex; i++) {
            if (item.equals(stringArray[i])) {
                for (int j = i; j < currentIndex; j++) {
                    if (j + 1 == stringArray.length) {
                        stringArray[j] = null;
                    } else {
                        stringArray[j] = stringArray[j + 1];
                    }
                }
                currentIndex--;
                break;
            }
        }
    }

    String get(int index) {
        return stringArray[index];
    }

    void printElement(int index) {
        System.out.println("Index " + index + " is " + stringArray[index] + ".");
    }

    void printAllElement() {
        System.out.println("id | Element");
        for (int i = 0; i < currentIndex; i++) {
            System.out.println(i + " | " + get(i));
        }
        System.out.println("--- End ---");
    }

    int size() {
        return currentIndex;
    }

    void printSize() {
        System.out.println("The size of the array is " + size() + ".");
    }
}
