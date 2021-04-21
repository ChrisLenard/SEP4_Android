package via.sep4.Model.Data;

public class User {
    /**
     * @author Kristóf Lénárd
     * @version 1.0
     * This class is responsible for storing Users. It does not store passwords to ensure higher secrecy.
     */

    private String username;
    private boolean isValidated;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }

    @Override
    public String toString() {

        String s = "Current user: " + username + ", Validation status: ";
        if (isValidated)
        {
            s += "valid.";
        }
        else s += "not valid.";
        return s;
    }
}
