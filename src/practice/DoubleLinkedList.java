package practice;

public class DoubleLinkedList {
    Node head;
    int currentSize;

    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();

        Node node1 = new Node();
        node1.name = "A";

        Node node2 = new Node();
        node2.name = "B";

        Node node3 = new Node();
        node3.name = "C";

        Node node4 = new Node();
        node4.name = "D";


        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.printElement(1);
        list.printSize();
        list.printAll();

        list.remove(node1);
        list.remove(node4);
        list.printElement(1);
        list.printSize();
        list.printAll();
    }

    void add(Node addNode){
        if(head == null){
            head = addNode;
            currentSize++;
        }
        else {
            //Node 돌면서 nextNode cursor 로 등록, null일 경우 등록
            Node cursor = head;

            while(true){
                if(cursor.nextNode == null){
                    cursor.nextNode = addNode;
                    addNode.prevNode = cursor;

                    currentSize++;
                    break;
                }

                cursor = cursor.nextNode;
            }
        }
        System.out.println("Added new node: name = " + addNode.name);

    }

    void remove(Node removeNode){
        if(head == removeNode){
            head = head.nextNode;
            head.prevNode = null;
            currentSize--;

            System.out.println("Removed node: name = " + removeNode.name);
        }
        else {
            Node cursor = head;
            while(cursor != null){
                if(cursor == removeNode){
                    cursor.prevNode.nextNode = cursor.nextNode;
                    cursor.nextNode.prevNode = cursor.prevNode;
                    currentSize--;

                    System.out.println("Removed node: name = " + removeNode.name);
                    break;
                }

                cursor = cursor.nextNode;
            }

            if(cursor == null){
                System.out.println("Node " + removeNode.name + " does not exist, thus cannot be removed");
            }

        }
    }

    Node get(int index){
        Node cursor = head;
        for(int i=0; i < index; i++){
            cursor = cursor.nextNode;
        }

        return cursor;
    }

    int size(){ return currentSize; }

    // Print methods
    void printSize() {
        System.out.println("Size = " + size());
    }

    void printAll(){
        Node cursor = head;
        for(int i=0; i < currentSize; i++){
            System.out.print(get(i).name + ", ");

            cursor = cursor.nextNode;
        }
        System.out.println("// End");
    }

    void printElement(int index){
        if(index >= currentSize){
            System.out.println("Error: Node " + index + " does not exist!");
        }
        else {
            System.out.println("Node " + index + " = " + get(index).name);
        }
    }
}

class Node {
    String name;
    Node prevNode;
    Node nextNode;
}
