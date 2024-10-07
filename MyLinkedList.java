package myStackAndQueue;

import java.util.NoSuchElementException;

public class MyLinkedList {

    Node head;
    Node tail;
    int size;

    //constructor
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }
    
    //adding element to front
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;

        size++;

        if (tail == null) {
            tail = head;
        }
    }

    //add element to end
    public void addLast(Object element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;

    }

    public Object deleteFirst() {
        if (head != null) {
            Object deletedElement = head.element;
            head = head.next;
            size--;
            return deletedElement;
        }
        throw new NoSuchElementException("The list is empty,");
    }

    //Insert Into 
    public void insrtInto(int index, Object element) {

        if (index == 0) {
            addFirst(element);
        } else if (index >= size) {
            addLast(element);
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(element);
            (current.next).next = temp;
            size++;
        }

    }
    
    public Object get(int index){
        if (size < index){
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++){
            current = current.next;
        } 
        return current.element;
    }
    

    //--- searches for a value and returns the index ---//
    //Iteratively , returns -1 if element is not found ###DOESN'T WORK###
    public int searchList(Object element) {
        Node current = head;
        int indexValue = 0;

        while (current.element != null) {
            if ((current.element).equals(element)) {
                return indexValue;
            }
            current = current.next;
            indexValue++;
        }
        return -1;
    }

    //Recursively, returns -1 if element is not found
    public int searchRecursively(Object element) {
        return searchingPart(head, element, 0);
    }

    public int searchingPart(Node node, Object element, int index) {
        if (node == null) {
            return -1;
        }

        if (node.element == element) {
            return index;
        }

        return searchingPart(node.next, element, index + 1);
    }

    //checks if empty
    public boolean isEmpty() {   //is this list empty? True if it is, Flase if there is an elemet
        if (head == null) {
            return true;
        }
        return false;
    }

    //finds the largest value
    public Object getLargest() {

        if (head == null) {
            System.out.println("The list is empty");
            return null; // Return null to indicate that the list is empty
        }

        Object largest = head.element;
        Node current = head.next;

        while (current != null) {
            // adding Comparable so you could compare the objects
            if (((Comparable) current.element).compareTo(largest) > 0) {
                largest = current.element;
            }
            current = current.next;
        }

        return largest;
    }

    //counts the number of negatives
    public int countNegative() {
        int counter = 0;
        Node current = head;

        while (current != null) {

            //checking if the object is a number
            if (current.element instanceof Number number) {
                if (number.doubleValue() < 0) {
                    counter++;
                }

            } else {
                // Handle the case when the object is not a number
                throw new IllegalArgumentException("Object is not a number");

            }
            current = current.next;
        }
        return counter;
    }

    //sorts the list (bubble sort)
    public void sortList() {
        // Node current will point to head
        Node current = head, nextNode = null;

        Object temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                // nextNode will point to node next to current
                nextNode = current.next;

                while (nextNode != null) {
                    // If current node's data is greater than nextNode node data, swap them
                    if (((Comparable) current.element).compareTo(nextNode.element) > 0) {

                        temp = current.element;
                        current.element = nextNode.element;
                        nextNode.element = temp;
                    }

                    nextNode = nextNode.next;
                }
                current = current.next;
            }
        }
    }

    //printing the thing
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println(); //to space things out
    }
    
    public Object lookHead(){
        return head.element;
    }

}
