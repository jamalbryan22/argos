package bryan.Argos.bug;

import org.springframework.beans.factory.annotation.Autowired;

public class BugService {

  @Autowired
  private BugDAO bugDAO;

  public BugService(BugDAO bugDAO){this.bugDAO=bugDAO;}

  public Bug createNewBug(Bug bug) {
    return bugDAO.createNewBug(bug);
  }
}
