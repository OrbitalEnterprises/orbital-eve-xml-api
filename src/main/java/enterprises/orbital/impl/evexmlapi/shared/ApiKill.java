package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.shared.IKill;
import enterprises.orbital.evexmlapi.shared.IKillAttacker;
import enterprises.orbital.evexmlapi.shared.IKillItem;

public class ApiKill implements IKill {
  private long                        killID;
  private long                        solarSystemID;
  private Date                        killTime;
  private int                         moonID;
  private ApiKillVictim               victim;
  private final List<ApiKillAttacker> attackers = new ArrayList<ApiKillAttacker>();
  private final List<ApiKillItem>     items     = new ArrayList<ApiKillItem>();

  @Override
  public long getKillID() {
    return killID;
  }

  public void setKillID(long killID) {
    this.killID = killID;
  }

  @Override
  public long getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(long solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public Date getKillTime() {
    return killTime;
  }

  public void setKillTime(Date killTime) {
    this.killTime = killTime;
  }

  @Override
  public int getMoonID() {
    return moonID;
  }

  public void setMoonID(int moonID) {
    this.moonID = moonID;
  }

  @Override
  public ApiKillVictim getVictim() {
    return victim;
  }

  public void setVictim(ApiKillVictim victim) {
    this.victim = victim;
  }

  public void addKillDetail(ApiKillAttacker attacker) {
    attackers.add(attacker);
  }

  @Override
  public List<IKillAttacker> getAttackers() {
    List<IKillAttacker> result = new ArrayList<IKillAttacker>();
    result.addAll(attackers);
    return result;
  }

  public void addKillDetail(ApiKillItem item) {
    items.add(item);
  }

  @Override
  public List<IKillItem> getItems() {
    List<IKillItem> result = new ArrayList<IKillItem>();
    result.addAll(items);
    return result;
  }
}