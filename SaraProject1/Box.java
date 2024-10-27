public class Box {
    private Room room;
    private Box left;
    private Box right;

    public Box(Room room) {
        this.room = room;
        this.left = null;
        this.right = null;
    }

    public Box getLeftBox() {
        return left;
    }

    public Box getRightBox() {
        return right;
    }

    public Room getRoom() {
        return room;
    }

    public void setLeftBox(Box left) {
        this.left = left;
    }

    public void setRightBox(Box right) {
        this.right = right;
    }
    
    public void disconnect() {
        if (left != null) {
            this.left.setRightBox(right); 
        }
        if (right != null) {
            this.right.setLeftBox(left); 
        }
        this.left = null;
        this.right = null;
    }

}
