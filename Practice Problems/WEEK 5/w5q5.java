class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;
    BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }
    String[] getSeatNumbers() {
        return seatNumbers.clone();
    }
    BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] copy = seatNumbers.clone();
        copy[index] = newSeat;
        return new BookingReceipt(bookingId, copy);
    }
}
class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;
    GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
    int getGroupSize() {
        return groupSize;
    }
}
public class w5q5 {
    static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, skipped = 0, group = 0, individual = 0;
        for (BookingReceipt r : receipts) {
            if (r == null)
                skipped++;
            else {
                processed++;
                if (r instanceof GroupBookingReceipt)
                    group++;
                else
                    individual++;
            }
        }
        return processed + " processed | " + skipped + " null skipped | " + group + " group | " + individual + " individual";
    }
    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        GroupBookingReceipt g = new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2);
        System.out.println(b.getSeatNumbers()[1]);
        System.out.println(updated.getSeatNumbers()[1]);
        System.out.println(g.getGroupSize());
        BookingReceipt[] receipts = {g, null, b};
        System.out.println(processNightlySettlement(receipts));
    }
}