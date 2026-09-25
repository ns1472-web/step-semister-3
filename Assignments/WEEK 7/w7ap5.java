abstract class Drone {
    protected String id;

    public Drone(String id) {
        this.id = id;
    }

    public abstract String fly();
}

interface Trackable {
    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {
    public DeliveryDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return id + " is flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

class ScoutDrone extends Drone {
    public ScoutDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return id + " is scouting";
    }
}

class GroundRobot implements Trackable {
    private String id;

    public GroundRobot(String id) {
        this.id = id;
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}

class w7ap5 {
    static String getLocationIfTrackable(Object object) {
        if (object instanceof Trackable) {
            Trackable item = (Trackable) object;
            return item.getLocation();
        }

        return "Tracking not available";
    }
}