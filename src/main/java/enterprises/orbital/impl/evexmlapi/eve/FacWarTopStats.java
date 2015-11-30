package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enterprises.orbital.evexmlapi.eve.IFacWarTopStats;
import enterprises.orbital.evexmlapi.eve.IKillStat;
import enterprises.orbital.evexmlapi.eve.IVictoryPointStat;

public abstract class FacWarTopStats<K extends KillStat, VP extends VictoryPointsStat, E extends FacWarStat, KE extends IKillStat, VPE extends IVictoryPointStat>
    implements IFacWarTopStats<KE, VPE> {
  private final Map<String, StatsList<? extends E>> stats = new HashMap<String, StatsList<? extends E>>();

  public void addStatsList(StatsList<? extends E> statsList) {
    stats.put(statsList.getName(), statsList);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<KE> getKillsYesterday() {
    List<KE> result = new ArrayList<KE>();
    result.addAll((Collection<? extends KE>) stats.get("KillsYesterday"));
    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<KE> getKillsLastWeek() {
    List<KE> result = new ArrayList<KE>();
    result.addAll((Collection<? extends KE>) stats.get("KillsLastWeek"));
    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<KE> getKillsTotal() {
    List<KE> result = new ArrayList<KE>();
    result.addAll((Collection<? extends KE>) stats.get("KillsTotal"));
    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<VPE> getVictoryPointsYesterday() {
    List<VPE> result = new ArrayList<VPE>();
    result.addAll((Collection<? extends VPE>) stats.get("VictoryPointsYesterday"));
    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<VPE> getVictoryPointsLastWeek() {
    List<VPE> result = new ArrayList<VPE>();
    result.addAll((Collection<? extends VPE>) stats.get("VictoryPointsLastWeek"));
    return result;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<VPE> getVictoryPointsTotal() {
    List<VPE> result = new ArrayList<VPE>();
    result.addAll((Collection<? extends VPE>) stats.get("VictoryPointsTotal"));
    return result;
  }
}