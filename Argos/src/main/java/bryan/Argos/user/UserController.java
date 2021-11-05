package bryan.Argos.user;

import bryan.Argos.security.LoginCredentials;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public String loginIn(@CookieValue(name = "userID", defaultValue = "null") String userIDCookie, @RequestBody LoginCredentials loginCredentials, HttpServletResponse response) {

    User user = null;
    Cookie cookie = null;

    if(userIDCookie != "null"){
      user = userService.login(userIDCookie);
      if(user != null)
      return user.toString();
    }

    user = userService.login(loginCredentials);

    if (user != null){
      cookie = new Cookie("userID",user.getUserID());
      response.addCookie(cookie);
      return user.toString();
    }
    else
      return "Bad Email or Password";
  }

  @PostMapping("/signup")
  public User addNewUser(@RequestBody User user, HttpServletResponse response){

    Cookie cookie = null;
    try{
      user.setUserID(UUID.randomUUID().toString());
      cookie = new Cookie("userID",user.getUserID());
      response.addCookie(cookie);
      return userService.createNewUser(user);
    }
    catch (Exception e){
      System.out.println("Something went wrong with the add new method:" + e);
    }
    return user;
  }

  @GetMapping()
  public User getUser(@RequestParam String userID){
    return userService.getUser(userID);
  }

  @PatchMapping("/update")
  public User updateUser(@RequestBody User user){
    return userService.updateUser(user);
  }

  @DeleteMapping
  public void deleteUser(@RequestParam String userID){
    userService.deleteUser(userID);
  }
}
