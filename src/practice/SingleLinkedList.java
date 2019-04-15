package practice;

public class SingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        Item item1 = new Item();
        item1.name = "A";

        Item item2 = new Item();
        item2.name = "B";

        Item item3 = new Item();
        item3.name = "C";

        Item item4 = new Item();
        item4.name = "C";

        list.add(item1);
        list.add(item2);
        list.add(item3);

        list.printAll();
        System.out.println(list.get(1).name);
        System.out.println(list.size());

        list.remove(item4);
        list.printAll();
        System.out.println(list.size());
    }

    Item head;
    int currentSize = 0;

    void add(Item addItem){
        if (head == null){ // head 가 비어있는지 아닌지 판단, 등록, +1
            head = addItem;
            currentSize++;
        }
        else {
            Item cursor = head; // head 는 비어있지 않으므로
//            while (cursor.item != null) {
//                cursor = cursor.item;
//            }
//            cursor.item = addItem;
//            currentSize++;
            while (true){
                if (cursor.item == null){
                    cursor.item = addItem;
                    break; // 1. 계속 (while true) cursor 이동 2. item이 null 이면 - 커서 이동 전에 확인해야 함. 3. item 등록 후 탈출 4. 사이즈+1
                }
                cursor = cursor.item;
            }
            currentSize++;
        }
    }

    void remove(Item removeItem){
        // head 1. == removeItem 인지 확인 2. head.item 이 head 가 됨
        // 아닐 경우 1. cursor 이동하면서 2. removeItem 과 같은 순간 3. 앞노드의 아이템으로 뒷노드 연결 -> 앞노드 기억해야 함 (prevCursor) 4. size--
        // 주의: iterate 하다가 현 커서가 null 이 되면 NPE 발생하므로 이 부분을 조건에 걸어야 함 (while)
        if (head == removeItem){
            head = head.item;
            currentSize--; // CAUTION
        }
        else {
            Item prevCursor = head;
            Item cursor = head.item; // head.item이 더 정확

            while (cursor != null){
                if (cursor == removeItem){
                    prevCursor.item = cursor.item;
                    currentSize--;
                    break;
                }
                prevCursor = cursor;
                cursor = cursor.item;
            }

            // 존재하지 않을 때, 즉 cursor == null 에 도달할 때까지 removeItem 못 찾을 때.

        }

    }

    int size(){
        return currentSize;
    }

    Item get(int index){
        Item cursor = head;
        for(int i=0; i < index; i++){
            cursor = cursor.item;
        }
        return cursor;

    }

    void printAll(){
        Item cursor = head;

        System.out.print("List = ");
        for(int i=0; i < currentSize; i++){
            System.out.print(cursor.name + ", ");
            cursor = cursor.item;
        }

    }


}

class Item {
    String name;
    Item item;
}
