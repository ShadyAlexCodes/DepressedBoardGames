/**
 * @author Xander
 * @createdOn 2/9/2023 at 12:25 PM
 * @projectName CasinoNight
 * @packageName io.github.csc130;
 */
package io.github.csc130;

public class Person {

    String name;
    int balance;
    boolean free;

    public Person() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Person(String name, int balance, boolean free) {
        this.name = name;
        this.balance = balance;
        this.free = free;
    }

    public Person(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
