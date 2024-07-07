package org.mj.module3.lesson12;


sealed interface Vehicle permits Bicycle, Car, Truck {
    default void add(String item) {
        System.out.println("Adding " + item + " to " + this);
    }
}

final class Car implements Vehicle {
    private int seats;

    public Car(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                '}';
    }
}

sealed class Truck implements Vehicle permits SemiTruck {
    private int payload;

    public Truck(int payload) {
        this.payload = payload;
    }

    public int getPayload() {
        return payload;
    }

    public void setPayload(int payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload=" + payload +
                '}';
    }
}

non-sealed class Bicycle implements Vehicle {
}

final class SemiTruck extends Truck {

    public SemiTruck(int payload) {
        super(payload);
    }
}

/*class TukTuk implements Vehicle { // Not Allowed

}*/

public class SealedTypeHierarchies {
    public static void main(String[] args) {
    }
}
