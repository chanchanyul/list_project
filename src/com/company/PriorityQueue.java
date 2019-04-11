package com.company;

class PriorityQueue {
    String[] arr = new String[5];
    int currentIndex = 0;

    void enqueue() {
        // priority 비교 & 삽입
        // 5개 넘어가면 arr 길이 늘리기
    }

    void dequeue() {
        // 첫 번째 것 꺼내기
        // 0개일 때 처리
    }

    String get(int index) {
        // index 가 currentIndex 넘어갔을 때 Error 처리
        return arr[index];
    }

    int size() {
        return currentIndex + 1;
    }

    // Print methods
    void printElement() {

    }

    void printAllElements() {

    }

    void printSize() {
        System.out.println("The size is " + size());
    }

}

class QueueItem {
    String name;
    int priority;
}