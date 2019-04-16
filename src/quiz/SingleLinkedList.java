package quiz;

public class SingleLinkedList {
    Item head;
    int currentSize = 0;

    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();

        Item item1 = new Item();
        item1.name = "A";

        Item item2 = new Item();
        item2.name = "B";

        Item item3 = new Item();
        item3.name = "C";

        Item item4 = new Item();
        item4.name = "D";

        list.add(item1);
        list.add(item2);
        list.printElement(1);
        list.printAll();
        list.printSize();

        list.add(item3);
        list.printElement(1);
        list.printAll();
        list.printSize();


        list.remove(item2);
        list.remove(item4);
        list.printElement(1);
        list.printAll();
        list.printSize();
    }

    void add(Item addItem){
        // head null 일 때
        // null 아닐 경우 cursor 돌면서 item null 일 때까지 iterate

        if (head == null){
            head = addItem;
            currentSize++;
        }
        else {
            Item cursor = head;

            while(true){
                if(cursor.item == null){
                    cursor.item = addItem;
                    currentSize++;
                    break;
                }

                cursor = cursor.item;
            }
        }

    }

    void remove(Item removeItem){
        // head 일 때
        // head 아닐 경우 cursor 돌면서 같으면 제외 (prevCursor 필요)

        if(head == removeItem){
            head = head.item;
            currentSize--;
            System.out.println("Removed" + removeItem.name);
        }
        else {
            Item prevCursor = head;
            Item currentCursor = head.item;

            while(currentCursor != null){
                if(currentCursor == removeItem){
                    prevCursor.item = currentCursor.item;
                    currentSize--;
                    break;
                }
                prevCursor = currentCursor;
                currentCursor = currentCursor.item;
            }

            if(currentCursor == null){
                System.out.println("Error: Could not find "+ removeItem.name + ", thus cannot remove it.");
            }
        }
    }

    Item get(int index){
        Item cursor = head;
        for(int i=0; i < index; i++){
            cursor = cursor.item;
        }

        return cursor;
    }

    int size(){
       return  currentSize;
    }


    // Print methods
    void printAll(){
        System.out.println("Print All ----");
        for(int i=0; i < currentSize; i++){
            System.out.print(get(i).name + ", ");
        }
    }

    void printSize(){
        System.out.println("Size = " + size());
    }

    void printElement(int index){
        System.out.println("Index " + index + " = " + get(index).name);
    }

}

class Item {
    String name;
    Item item;
}
