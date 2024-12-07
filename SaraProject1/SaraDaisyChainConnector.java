public class SaraDaisyChainConnector {
    private Box head;  
    private int size;

    public SaraDaisyChainConnector() {
        this.head = null;
        this.size = 0;
    }

    public void add(Room room) {
        Box newBox = new Box(room);
        if (head == null) {
            head = newBox;
            head.setLeftBox(head);
            head.setRightBox(head);
        } else {
            Box tail = head.getLeftBox();
            tail.setRightBox(newBox);
            newBox.setLeftBox(tail);
            newBox.setRightBox(head);
            head.setLeftBox(newBox);
        }
        size++;
    }

    public Box getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    public Box get(int index) {
        if (index < 0 || index >= size) {
            return null;  
        }

        Box current = head;
        for (int i = 0; i < index; i++) {
            current = current.getRightBox();  
        }
        return current;
    }
    
    public void remove(Box box) {
        if (box != null) {
            if (box == head) {
                head = box.getRightBox(); 
            }
            box.disconnect();
            size--;
        }
    }

}
