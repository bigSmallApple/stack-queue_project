package myStackAndQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class myStackAndQueue {

    public static void main(String[] args) {

        //initializing myStack, myQueue and scanner
        MyStack myStack = new MyStack();
        MyQueue myQueue = new MyQueue();
        Scanner scanner = new Scanner(System.in);

        //This code is for Question 1
        System.out.println("\n");
        System.out.println("Please enter the sentence:");
        String input;
        while (!(input = scanner.nextLine()).equals("")) {
            String[] words = input.split("\\s+"); // Split the sentence into words
            for (String word : words) {
                myStack.push(word);
            }
        }
        while (!myStack.isEMpty()) {
            System.out.printf("%s ", myStack.pop());
        }

        //This code is for Question 2
        System.out.println("\n");
        try {
            FileReader fileReader = new FileReader("Code.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int character;
            while ((character = bufferedReader.read()) != -1) {
                char temp = (char) character;
                // Skip whitespace characters
                if (!Character.isWhitespace(character)) {
                    // Process non-whitespace characters
                    myStack.push(temp);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        while (!myStack.isEMpty()) {
            char temp2 = (char) myStack.pop();
            if (temp2 == '*') {
                System.out.printf("%c ", myStack.pop());
            }
        }

        //This code is for Question 3
        System.out.println("\n");
        int stopDoubleMessage = 0;
        try {
            FileReader fileReader = new FileReader("parenthesis.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int character;
            while ((character = bufferedReader.read()) != -1) {
                char temp = (char) character;
                System.out.print(temp);
                // Skip whitespace characters
                if (!Character.isWhitespace(temp)) {
                    if (temp == '(') {
                        myStack.push(temp);
                    } else if (temp == ')' && !myStack.isEMpty()) {
                        myStack.pop();

                    } else if (temp == ')' && myStack.isEMpty()) {
                        System.out.println("\nExtra right parenthesis or Left parenthesis missing");
                        stopDoubleMessage = 1;
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        if (!myStack.isEMpty()) {
            System.out.println("\nExtra left parenthesis or Right parenthesis missing"); //note that if this happens ")(" the it will say that both left and right are missing
        } else if (stopDoubleMessage != 1) {
            System.out.println("\nLeft and right parentheses are balance");
        }

        //making sure that the stack is empty for next questions
        while (!myStack.isEMpty()) {
            myStack.pop();
        }

//        //This is code for Question 4
        System.out.println("\n");
        int value1;
        int value2;
        int passingValue;
        String inputLine;

        for (int i = 0; i < 3; i++) {
            System.out.println("\n\nEnter the postfix expression (enter blank line to stop): ");
            while (!(inputLine = scanner.nextLine()).isEmpty()) {

                String[] tokens = inputLine.split(" ");
                for (String token : tokens) {

                    try {
                        
                        int number = Integer.parseInt(token);
                        myStack.push(number);

                    } catch (NumberFormatException e) {
                        switch (token) {
                            case "+" -> {
                                value1 = (int) myStack.pop();
                                value2 = (int) myStack.pop();
                                myStack.push(value2 + value1);
                            }
                            case "-" -> {
                                value1 = (int) myStack.pop();
                                value2 = (int) myStack.pop();
                                myStack.push(value2 - value1);
                            }
                            case "*" -> {
                                value1 = (int) myStack.pop();
                                value2 = (int) myStack.pop();
                                myStack.push(value2 * value1);
                            }
                            case "/" -> {
                                value1 = (int) myStack.pop();
                                value2 = (int) myStack.pop();
                                myStack.push(value2 / value1);
                            }
                            case "=" ->
                                System.out.print(myStack.pop());
                            default -> {
                            }
                        }
                    }

                }

            }
        }

        //This is code for Question 5
        Bank bank = new Bank();
        bank.createPersons();
        bank.assignQueue();
        bank.printQueues();
    }

}
