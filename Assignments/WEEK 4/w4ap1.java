class Participant {
    String name;
    String teamName;
    boolean registered;
    Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }
    Participant(String name) {
        this(name, "Unassigned");
    }
    void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }
}
public class w4ap1 {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};
        createParticipants(names, teamNames);
    }
    static void createParticipants(String[] names, String[] teamNames) {
        for (int i = 0; i < names.length; i++) {
            Participant participant;
            if (teamNames[i].isEmpty()) {
                participant = new Participant(names[i]);
            } else {
                participant = new Participant(names[i], teamNames[i]);
            }
            participant.printStatus();
        }
    }
}