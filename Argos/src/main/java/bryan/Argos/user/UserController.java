package bryan.Argos.user;

import bryan.Argos.security.LoginCredentials;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

  UserService userService;

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
  public void addNewUser(@RequestBody User user, HttpServletResponse response){

    User newUser = null;
    Cookie cookie = null;
    try{
      user.setUserID(UUID.randomUUID().toString());
      newUser = userService.createNewUser(user);
      cookie = new Cookie("userID",newUser.getUserID());
      response.addCookie(cookie);
    }
    catch (Exception e){
      System.out.println("Something went wrong with the add new method:" + e);
    }

  }

  @PatchMapping("/update")
  public void updateUser(@RequestBody User user){
    userService.updateUser(user);
  }

  @DeleteMapping
  public void deleteUser(@RequestParam String userID){
    userService.deleteUser(userID);
  }
}
