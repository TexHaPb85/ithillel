package edu.ithillel._common.person;

import java.sql.Timestamp;

import edu.ithillel.reflection.annotations.Hillel;

public class PersonWorker extends Person{
    private String workedId;
    @Hillel(annotationParam2 = "s")
    public Double salary;

    public PersonWorker() {
        super();
    }

    public PersonWorker(String firstName, String lastName, String idCode, Timestamp birthDate, String workedId, Double salary) {
        super(firstName, lastName, idCode, birthDate);
        this.workedId = workedId;
        this.salary = salary;
    }

    private final void somePrivateMethodPersonWorker() {
        System.out.println("somePrivateMethod");
    }

    @Hillel(annotationParam1 = "s", annotationParam2 = "s")
    private void somePrivateMethodPersonWorker(int a) {
        System.out.println("somePrivateMethod");
    }

    private void somePrivateMethodPersonWorker(String b) {
        System.out.println("somePrivateMethod");
    }
    public String getWorkedId() {
        return workedId;
    }

    public void setWorkedId(String workedId) {
        this.workedId = workedId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
