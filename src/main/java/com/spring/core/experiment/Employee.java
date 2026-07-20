package com.spring.core.experiment;

public class Employee extends Person {
    private String employeeId;

    public Employee(String name, int age, String employeeId) {
        // Call the constructor of the superclass (Person) to initialize name and age
        // always call the superclass constructor first before initializing subclass fields
        // waiting for flexible constructor feature in Java to allow calling super() after initializing subclass fields
        super(name, age);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
