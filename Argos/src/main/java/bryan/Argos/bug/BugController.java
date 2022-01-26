package bryan.Argos.bug;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/bugs")
public class BugController {

  private final BugService bugService;

  @Autowired
  public BugController(BugService bugService){this.bugService = bugService;}

  @PostMapping("")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public Bug createBug(@RequestBody Bug newBug){
    if(newBug.getDateResolved() == null){
      newBug.setDateResolved(null);
    }
    return bugService.createNewBug(newBug);
  }

  @GetMapping("")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public Optional<Bug> getBug(@RequestParam String bugID){
    System.out.println(bugID);
    return bugService.findByBugID(bugID);
  }


  @GetMapping("/all-user-bugs")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public List<Bug> getAllUserBugs(@RequestParam String creatorID){
    return bugService.findByCreatorID(creatorID);
  }

  @GetMapping("/all-project-bugs")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public List<Bug> getAllProjectBugs(@RequestParam String projectID){
    return bugService.findBugsByReferenceProjectID(projectID);
  }

  @PatchMapping("")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public Bug updateBug(@RequestBody Bug bugUpdates){
    return bugService.updateBug(bugUpdates);
  }

  @DeleteMapping("")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public void deleteBug(@RequestParam String bugID){
    bugService.deleteBug(bugID);
  }





}
