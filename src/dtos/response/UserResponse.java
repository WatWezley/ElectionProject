package dtos.response;

public class UserResponse {
    private String firstName;
    private String lastName;
    private String userName;

    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Override
    public String toString() {
        return String.format("""
                Id : %s
                FirstName: %s
                LastName: %s
                UserName: %s
                """,getId(),getFirstName(), getLastName(),getUserName());

    }
}
