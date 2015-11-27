package enterprises.orbital.evexmlapi.shared;

import java.util.List;

public interface IStandingSet {

  public List<IStanding> getAgentStandings();

  public List<IStanding> getNPCCorporationStandings();

  public List<IStanding> getFactionStandings();

}
