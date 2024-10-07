package myStackAndQueue;

public class MyQueue {

    private MyLinkedList queue = new MyLinkedList();

    public void enqueue(Object element) {
        queue.addLast(element);
    }

    public Object dequeue() {
        return queue.deleteFirst();
    }

    public Object front() {
        return queue.lookHead();
    }

    public int size() {
        return queue.getSize();
    }

    public boolean isEMpty() {
        return queue.isEmpty();
    }
    
    public void printQueue(){
        queue.print();
    }
    
    public Object get(int index){
        return queue.get(index);
    }
}
