package enterprises.orbital.evexmlapi.shared;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IStandingSet.class)
public interface IStandingSet {

  public List<IStanding> getAgentStandings();

  public List<IStanding> getNPCCorporationStandings();

  public List<IStanding> getFactionStandings();

}
