
public class Member {
    private int memberId;
    private String name;
    private String contact;
public static int memberCount = 0;
    public Member( String name, String contact) {
        this.memberId = ++memberCount;
        this.name = name;
        this.contact = contact;
    }

    // Getters and Setters

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getContact() { return contact; }

    public String toString() { return memberId + ": " + name + " (" + contact + ")"; }
}


