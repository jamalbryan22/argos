package bryan.Argos.payload.request;

import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;


  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @NotBlank
  @Size(min = 2, max = 25)
  private String first_name;

  @NotBlank
  @Size(min = 2, max = 25)
  private String last_name;

  @NotBlank
  @Min(value = 13, message = "must be at least 13 years old")
  @Max(value = 120, message = "must be at under 120 years old")
  private String age;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_state;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_country;

  @NotBlank
  @Size(min = 2, max = 25)
  private String user_city;

  @NotBlank
  @Size(min = 5, max = 10)
  private String user_zip;

  private Set<String> role;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getUser_state() {
    return user_state;
  }

  public void setUser_state(String user_state) {
    this.user_state = user_state;
  }

  public String getUser_country() {
    return user_country;
  }

  public void setUser_country(String user_country) {
    this.user_country = user_country;
  }

  public String getUser_city() {
    return user_city;
  }

  public void setUser_city(String user_city) {
    this.user_city = user_city;
  }

  public String getUser_zip() {
    return user_zip;
  }

  public void setUser_zip(String user_zip) {
    this.user_zip = user_zip;
  }

  public Set<String> getRole() {
    return role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }
}
