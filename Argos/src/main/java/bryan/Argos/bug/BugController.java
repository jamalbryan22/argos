package bryan.Argos.bug;

import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bugs")
public class BugController {

  @Autowired
  private final BugService bugService;

  public BugController(BugService bugService){this.bugService=bugService;}

  @PostMapping("")
  public Bug addNewBug(@RequestBody Bug bug, HttpServletResponse response){

    Cookie cookie = null;
    try{
      bug.setBugID(UUID.randomUUID().toString());
      cookie = new Cookie("bugID",bug.getBugID());
      response.addCookie(cookie);
      return bugService.createNewBug(bug);
    }
    catch (Exception e){
      System.out.println("Something went wrong with the add new method:" + e);
    }
    return bug;
  }

}
