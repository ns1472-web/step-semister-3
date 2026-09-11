class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    @SuppressWarnings("unused")
    private String otp;
    public MovieBookingProfile() {
    }
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isConfirmed() {
        return confirmed;
    }
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
    public void setOtp(String otp) {
        this.otp = otp;
    }
}
public class w5q4 {
    public static void main(String[] args) {
        MovieBookingProfile profile = new MovieBookingProfile("Rahul Dev");
        profile.setConfirmed(true);
        profile.setOtp("4471");
        System.out.println(profile.getName());
        System.out.println(profile.isConfirmed());
    }
}