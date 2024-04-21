package edu.ithillel._common.person;

public abstract class Human {

    private String privateHumanData;
    public String publicHumanData;

    public void liveHumanLive() {
        System.out.println("Human is living...");
    }

    private void somePrivateMethodHuman() {
        System.out.println("somePrivateMethod");
    }
}
