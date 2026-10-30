import java.util.*;

interface Chargeable {
    void bookChargingBay();
}

class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;

    Vehicle(String passNumber, String owner, String type, int fee) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;
        this.fee = fee;
    }

    boolean isElectric() {
        return false;
    }
}

class Bike extends Vehicle {
    Bike(String passNumber, String owner, String type) {
        super(passNumber, owner, type, 300);
    }
}

class Car extends Vehicle {
    Car(String passNumber, String owner, String type) {
        super(passNumber, owner, type, 1000);
    }
}

class EBike extends Vehicle implements Chargeable {
    EBike(String passNumber, String owner, String type) {
        super(passNumber, owner, type, 300);
    }

    public boolean isElectric() {
        return true;
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    ECar(String passNumber, String owner, String type) {
        super(passNumber, owner, type, 1000);
    }

    public boolean isElectric() {
        return true;
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class w10q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equals("PASS")) {
                String type = parts[1];
                String passNumber = parts[2];
                String owner = parts[3];

                Vehicle vehicle = null;

                switch (type.toLowerCase().replace("-", "")) {
                    case "bike":
                        vehicle = new Bike(passNumber, owner, type);
                        break;
                    case "car":
                        vehicle = new Car(passNumber, owner, type);
                        break;
                    case "ebike":
                        vehicle = new EBike(passNumber, owner, type);
                        break;
                    case "ecar":
                        vehicle = new ECar(passNumber, owner, type);
                        break;
                }

                if (vehicle != null) {
                    vehicles.put(passNumber, vehicle);
                    System.out.println(passNumber + " (" + type + ") pass fee " + vehicle.fee);
                }
            } else if (parts[0].equals("CHARGE")) {
                String passNumber = parts[1];
                Vehicle vehicle = vehicles.get(passNumber);

                if (vehicle instanceof Chargeable) {
                    ((Chargeable) vehicle).bookChargingBay();
                } else if (vehicle != null) {
                    System.out.println(passNumber + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}