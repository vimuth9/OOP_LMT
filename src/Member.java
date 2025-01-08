
public class Member {
    private int memberId;
    private String name;
    private String contact;

    public Member(int memberId, String name, String contact) {
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
    }

    // Getters and Setters

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getContact() { return contact; }

    public String toString() { return memberId + ": " + name + " (" + contact + ")"; }
}


