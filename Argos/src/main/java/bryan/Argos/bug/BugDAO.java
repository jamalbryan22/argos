package bryan.Argos.bug;

import bryan.Argos.mongodb.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BugDAO {

  @Autowired
  private BugRepository bugRepository;

  public Bug createNewBug(Bug bug) {
    return bugRepository.save(bug);
  }

}
