package edu.ithillel._common;

import java.sql.Timestamp;

public class PersonWorker extends Person{
    private String workedId;
    private Double salary;

    public PersonWorker() {
        super();
    }

    public PersonWorker(String firstName, String lastName, String idCode, Timestamp birthDate, String workedId, Double salary) {
        super(firstName, lastName, idCode, birthDate);
        this.workedId = workedId;
        this.salary = salary;
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
