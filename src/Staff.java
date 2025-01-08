
public class Staff {
    private int staffId;
    private String username;
    private String password;

    public Staff(int staffId, String username, String password) {
        this.staffId = staffId;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getStaffId() { return staffId; }
    public String getUsername() { return username; }
    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public String toString() { return staffId + ": " + username; }
}


