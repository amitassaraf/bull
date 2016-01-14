package org.bull.tasks;

/**
 *
 * The base class for all tasks
 *
 * Created by amit on 13/01/16.
 */
public class Task extends Thread {

    /* --- Static methods --- */

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
