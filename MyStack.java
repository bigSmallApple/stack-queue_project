package myStackAndQueue;

public class MyStack {

    private MyLinkedList stack = new MyLinkedList();
    
    public void push(Object element){
        stack.addFirst(element);
    }
    
    public Object pop(){
        return stack.deleteFirst();
    }
    
    public Object top(){
        return stack.lookHead();
    }
    
    public int size(){
        return stack.getSize();
    }
    
    public boolean isEMpty(){
        return stack.isEmpty();
    }
}
