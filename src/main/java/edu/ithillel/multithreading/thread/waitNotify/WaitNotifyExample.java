package edu.ithillel.multithreading.thread.waitNotify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/** in one thread we call wait on some object and this thread will sleep and do nothing till in another thread
 * we won`t call notify(All)() on same object on which wait() was called
 *
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        List<String> commands = Collections.synchronizedList(new ArrayList<>());
        new Thread(new MessagesSupplier(commands)).start();
        new Thread(new MessagesReceiver(commands)).start();
    }


}

class MessagesSupplier implements Runnable {
    List<String> commandsToProcess;
    Scanner scanner;

    public MessagesSupplier(List<String> commandsToProcess) {
        this.commandsToProcess = commandsToProcess;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("enter command:");
            synchronized (commandsToProcess) {
                commandsToProcess.add(scanner.nextLine());
//                commandsToProcess.notify();
                commandsToProcess.notifyAll();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class MessagesReceiver implements Runnable {
    List<String> commandsToProcess;

    public MessagesReceiver(List<String> commandsToProcess) {
        this.commandsToProcess = commandsToProcess;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (commandsToProcess) {
                if (commandsToProcess.isEmpty()) {
                    try {
                        System.out.println("no commands");
                        commandsToProcess.wait();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("command: " + commandsToProcess.remove(0));
                }
            }
        }
    }
}
