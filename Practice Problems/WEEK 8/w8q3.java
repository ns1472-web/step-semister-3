interface Seat {
    String getSeatNumber();
    double getPrice();
}

class RegularSeat implements Seat {
    private String seatNumber;

    public RegularSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat implements Seat {
    private String seatNumber;

    public PremiumSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat implements Seat {
    private String seatNumber;

    public ReclinerSeat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return 400;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Show {
    private String showTime;
    private boolean started;
    private java.util.ArrayList<String> bookedSeats;

    public Show(String showTime) {
        this.showTime = showTime;
        started = false;
        bookedSeats = new java.util.ArrayList<>();
    }

    public boolean isAvailable(String seatNumber) {
        return !bookedSeats.contains(seatNumber);
    }

    public boolean bookSeat(String seatNumber) {
        if (!isAvailable(seatNumber)) {
            return false;
        }

        bookedSeats.add(seatNumber);
        return true;
    }

    public void releaseSeat(String seatNumber) {
        bookedSeats.remove(seatNumber);
    }

    public void startShow() {
        started = true;
    }

    public boolean hasStarted() {
        return started;
    }
}

class Booking {
    private Customer customer;
    private Show show;
    private java.util.ArrayList<Seat> seats;

    public Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        seats = new java.util.ArrayList<>();
    }

    public boolean addSeat(Seat seat) {
        if (seats.size() >= 6) {
            System.out.println("Maximum 6 seats allowed per booking.");
            return false;
        }

        if (!show.bookSeat(seat.getSeatNumber())) {
            System.out.println("Seat " + seat.getSeatNumber()
                    + " is already booked for this show.");
            return false;
        }

        seats.add(seat);
        return true;
    }

    public double getTotal() {
        double total = 0;

        for (Seat seat : seats) {
            total += seat.getPrice();
        }

        return total;
    }

    public void cancel() {
        if (show.hasStarted()) {
            System.out.println("Cannot cancel booking after the show has started.");
            return;
        }

        for (Seat seat : seats) {
            show.releaseSeat(seat.getSeatNumber());
        }

        System.out.println(customer.getName() + "'s booking cancelled.");
        System.out.println("Seats released.");
        seats.clear();
    }
}

class w8q3 {
    public static void main(String[] args) {
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Show show = new Show("7 PM");

        Booking ashaBooking = new Booking(asha, show);
        ashaBooking.addSeat(new RegularSeat("A1"));
        ashaBooking.addSeat(new RegularSeat("A2"));
        ashaBooking.addSeat(new PremiumSeat("F5"));

        System.out.printf("Booking confirmed for Asha: A1, A2, F5. Total: ₹%.2f%n",
                ashaBooking.getTotal());

        Booking raviBooking = new Booking(ravi, show);
        raviBooking.addSeat(new RegularSeat("A2"));
        raviBooking.addSeat(new ReclinerSeat("R1"));

        System.out.printf("Booking confirmed for Ravi: R1. Total: ₹%.2f%n",
                raviBooking.getTotal());

        ashaBooking.cancel();

        Booking nehaBooking = new Booking(neha, show);
        nehaBooking.addSeat(new RegularSeat("A2"));

        System.out.printf("Booking confirmed for Neha: A2. Total: ₹%.2f%n",
                nehaBooking.getTotal());
    }
}