
public class Staff {
    private int staffId;
    private String username;
    private String password;
    public static int staffCount = 0;

    public Staff( String username, String password) {
        this.staffId = ++staffCount;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getStaffId() {
        return staffId;
    }

    public String getUsername() {
        return username;
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public String toString() {
        return staffId + ": " + username;
    }
}


