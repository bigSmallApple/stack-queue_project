package myStackAndQueue;

public class Person {
    private String name;
    private int age;
    private int accountNumber;
    private String transaction;

    public Person(String name, int age, int accountNumber, String transaction) {
        this.name = name;
        this.age = age;
        this.accountNumber = accountNumber;
        this.transaction = transaction;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getTransaction() {
        return transaction;
    }
    
    
    
}
