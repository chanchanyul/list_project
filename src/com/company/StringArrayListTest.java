package com.company;

public class StringArrayListTest {
    String[] stringArray = new String[3];
    int currentIndex = 0;

    // Main
    public static void main(String[] args) {
        StringArrayListTest list = new StringArrayListTest();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.printSize();
        list.printAll();

        list.printOne(2);


        list.remove("a");
        list.printSize();
        list.printAll();

        list.add(1, "a");
        list.printAll();
    }

    void add(String item) {
        if (currentIndex == stringArray.length) {
            String[] newStringArray = new String[stringArray.length + 10];
            for (int i = 0; i < currentIndex; i++) {
                newStringArray[i] = stringArray[i];
            }
            stringArray = newStringArray;
        }

        stringArray[currentIndex] = item;
        currentIndex++;
    }

    void add(StringArrayListTest list) {
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
    }

    void add(String[] arr) {

    }

    void add(int index, String item) {
        if (index >= currentIndex) {
            System.out.println("Index" + index + "does not exist!");
        } else {
            if (currentIndex == stringArray.length) {
                String[] newStringArray2 = new String[stringArray.length + 10];
                for (int i = 0; i < currentIndex; i++) {
                    newStringArray2[i] = stringArray[i];
                }
                stringArray = newStringArray2;
            }

            for (int i = currentIndex; i > index - 1; i--) {
                stringArray[i] = stringArray[i - 1];
            }
            stringArray[index] = item;
            currentIndex++;
        }
    }

    void remove(String item) {
        for (int i = 0; i < currentIndex; i++) {
            if (stringArray[i] == item) {
                for (int j = i; j < currentIndex; j++) {
                    if (j + 1 == currentIndex) {
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

    ;

    int size() {
        return currentIndex;
    }

    String get(int index) {
        return stringArray[index];
    }

    // Print methods
    void printSize() {
        System.out.println("The length of the list is " + size() + ".");
    }

    void printOne(int index) {
        System.out.println("Index " + index + " is " + get(index) + ".");
    }

    void printAll() {
        System.out.print("[");
        for (int i = 0; i < currentIndex; i++) {
            if (i + 1 == currentIndex) {
                System.out.print(stringArray[i]);
            } else {
                System.out.print(stringArray[i] + ", ");
            }
        }
        System.out.println("]");
    }
}
