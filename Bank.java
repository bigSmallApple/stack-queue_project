package myStackAndQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bank {

    MyQueue elderQ = new MyQueue();
    MyQueue accountQ = new MyQueue();
    MyQueue otherQ = new MyQueue();

    MyLinkedList personList = new MyLinkedList();
    Person person;

    public void createPersons() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("today.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                // Extracting information from each line
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                int accountNumber = Integer.parseInt(parts[2]);
                String transaction = parts[3];

                // Creating a new Person object with the extracted information
                Person person = new Person(name, age, accountNumber, transaction);

                // Place person in personList
                personList.addFirst(person);
               
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void assignQueue() {
        while (!personList.isEmpty()) {

            person = (Person) personList.deleteFirst();

            if (person.getAge() >= 50) {
                elderQ.enqueue(person);
            } else if (person.getTransaction().equals("account")) {
                accountQ.enqueue(person);
            } else {
                otherQ.enqueue(person);
            }

        }
    }

    public void printQueues() {
        System.out.println("\n\nThis is the elderQ");
        for (int i = 0; i < elderQ.size(); i++){
            Person temp = (Person) elderQ.get(i);
            System.out.printf("%s, ", temp.getName());
        }
        
        System.out.println("\n\nThis is the accountQ");
        for (int i = 0; i < accountQ.size(); i++){
            Person temp = (Person) accountQ.get(i);
            System.out.printf("%s, ", temp.getName());
        }
        
        System.out.println("\n\nThis is the otherQ");
        for (int i = 0; i < otherQ.size(); i++){
            Person temp = (Person) otherQ.get(i);
            System.out.printf("%s, ", temp.getName());
        }
        
    }
}
