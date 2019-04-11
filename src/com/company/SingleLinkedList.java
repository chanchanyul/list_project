package com.company;

public class SingleLinkedList {
    Item head;
    int currentSize = 0;

    // main
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        // Item 생성
        Item item1 = new Item();
        item1.name = "A";

        Item item2 = new Item();
        item2.name = "B";

        Item item3 = new Item();
        item3.name = "C";

        Item item4 = new Item();
        item4.name = "D";

        Item item5 = new Item();
        item5.name = "E";

        // Call methods
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.printAll();
        list.printSize();

        list.add(0, item5);
        list.add(10, item5);
        list.printAll();

        list.remove(item2);
        list.remove(item4);
        list.printAll();
        list.printSize();

        list.add(item4);
        list.printAll();
        list.printIndex(1);

    }

    // add, remove: 일단 head 인지 아닌지가 기준이 된다.
    void add(Item addItem) {
        if (head == null) {
            head = addItem;
        } else {
            Item cursor = head; // head != null 이니까.
            while (true) {
                if (cursor.item == null) {
                    cursor.item = addItem;
                    break;
                }
                cursor = cursor.item;
            }
        }
        System.out.println("Added " + addItem.name + "!!!");
        currentSize++;
    }

    // 삽입
    void add(int index, Item addItem) {
        if (index > currentSize) {
            System.out.println("Input cannot be bigger than  " + currentSize);
        } else {
            if (index == 0) {
                Item nextCursor = head;
                head = addItem;
                head.item = nextCursor;
            } else {
                Item cursor = head;
                for (int i = 0; i < index - 1; i++) {
                    cursor = cursor.item;
                }
                Item prevCursor = cursor;
                Item nextCursor = prevCursor.item;
                prevCursor.item = addItem;
                addItem.item = nextCursor;
            }
            System.out.println("Inserted " + addItem.name + " in index " + index + ".");
            currentSize++;
        }
    }

    void remove(Item removeItem) {
        if (head == removeItem) {
            head = head.item;
            currentSize--;
        } else {
            Item prevCursor = head;
            Item currentCursor = head.item;

            while (currentCursor != null) {
                if (currentCursor == removeItem) {
                    prevCursor.item = currentCursor.item;
                    System.out.println("Removed " + removeItem.name + "!!!");
                    currentSize--;
                    break;
                }

                prevCursor = currentCursor;
                currentCursor = currentCursor.item;

                if (currentCursor == null) { // 끝까지 돌았는데도 removeItem 못 찾았을 때.
                    System.out.println(removeItem.name + " does not exist in the list, thus cannot be removed.");
                }
            }


        }

    }

    Item get(int index) {
        Item cursor = head;
        for (int i = 0; i < index; i++) {
            cursor = cursor.item;
        }
        return cursor;
    }

    int size() {
        return currentSize;
    }

    // print methods
    void printIndex(int index) {
        System.out.println("Index " + index + " = " + get(index).name);
    }

    void printAll() {
        System.out.print("[");
        for (int i = 0; i < currentSize; i++) {
            if (i + 1 == currentSize) {
                System.out.print(get(i).name);
            } else {
                System.out.print(get(i).name + ", ");
            }
        }
        System.out.println("]");
    }

    void printSize() {
        System.out.println("Size = " + size());
    }
}

class Item {
    String name;
    Item item;
}

