package bryan.Argos.administrator;

import java.util.UUID;

public class Administrator {

  private final UUID administratorID;
  private String email;
  private String password;
  private String firstName;
  private String lastName;


  public Administrator(String email, String password, String firstName, String lastName) {
    this.administratorID = UUID.randomUUID();
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
