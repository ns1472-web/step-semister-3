class MovieTicket {
    private int seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
    MovieTicket(int seatNumber) {
        this.seatNumber = seatNumber;
    }
    int getSeatNumber() {
        return seatNumber;
    }
}
public class w5q1 {
    static String classifyAccess(String fieldModifier, String context) {
        if (fieldModifier.equals("private"))
            return context.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("default"))
            return context.equals("SAME_CLASS") || context.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("protected"))
            return context.equals("DIFFERENT_PACKAGE") ? "DENIED" : "ALLOWED";
        return "ALLOWED";
    }
    static String summarizeBatch(String[][] attempts) {
        int allowed = 0, denied = 0;
        for (String[] a : attempts) {
            if (classifyAccess(a[0], a[1]).equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket(10);
        System.out.println(ticket.getSeatNumber());
        System.out.println(classifyAccess("private", "SAME_CLASS"));
    }
}