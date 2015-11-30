package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.evexmlapi.shared.IStanding;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class StandingsResponse extends ApiResponse implements IStandingSet {
  private StandingsList agentStandings;
  private StandingsList npcCorporationStandings;
  private StandingsList factionStandings;

  public void addStandingsList(StandingsList standingsList) {
    if (standingsList.getName().equals("agents"))
      agentStandings = standingsList;
    else if (standingsList.getName().equals("NPCCorporations"))
      npcCorporationStandings = standingsList;
    else if (standingsList.getName().equals("factions"))
      factionStandings = standingsList;
    else
      throw new RuntimeException("Unknown standings list type");
  }

  @Override
  public List<IStanding> getAgentStandings() {
    List<IStanding> result = new ArrayList<IStanding>();
    result.addAll(agentStandings);
    return result;
  }

  @Override
  public List<IStanding> getNPCCorporationStandings() {
    List<IStanding> result = new ArrayList<IStanding>();
    result.addAll(npcCorporationStandings);
    return result;
  }

  @Override
  public List<IStanding> getFactionStandings() {
    List<IStanding> result = new ArrayList<IStanding>();
    result.addAll(factionStandings);
    return result;
  }
}