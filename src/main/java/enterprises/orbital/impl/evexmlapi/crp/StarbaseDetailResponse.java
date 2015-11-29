package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import enterprises.orbital.evexmlapi.crp.ICombatSetting;
import enterprises.orbital.evexmlapi.crp.IFuel;
import enterprises.orbital.evexmlapi.crp.IStarbaseDetail;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class StarbaseDetailResponse extends ApiResponse implements IStarbaseDetail {
  // status settings
  private int                   state;
  private Date                  stateTimestamp;
  private Date                  onlineTimestamp;

  // general settings
  private int                   usageFlags;
  private int                   deployFlags;
  private boolean               allowCorporationMembers;
  private boolean               allowAllianceMembers;

  // combat settings
  private long                  useStandingsFrom;
  private ApiCombatSetting      onStandingDrop;
  private ApiCombatSetting      onStatusDrop;
  private ApiCombatSetting      onAggression;
  private ApiCombatSetting      onCorporationWar;
  private Map<Integer, Integer> fuelMap = new HashMap<Integer, Integer>();

  @Override
  public int getUsageFlags() {
    return usageFlags;
  }

  public void setUsageFlags(int usageFlags) {
    this.usageFlags = usageFlags;
  }

  @Override
  public int getDeployFlags() {
    return deployFlags;
  }

  public void setDeployFlags(int deployFlags) {
    this.deployFlags = deployFlags;
  }

  @Override
  public boolean isAllowCorporationMembers() {
    return allowCorporationMembers;
  }

  public void setAllowCorporationMembers(boolean allowCorporationMembers) {
    this.allowCorporationMembers = allowCorporationMembers;
  }

  @Override
  public boolean isAllowAllianceMembers() {
    return allowAllianceMembers;
  }

  public void setAllowAllianceMembers(boolean allowAllianceMembers) {
    this.allowAllianceMembers = allowAllianceMembers;
  }

  @Override
  public ICombatSetting getOnStandingDrop() {
    return onStandingDrop;
  }

  public void setOnStandingDrop(ApiCombatSetting onStandingDrop) {
    this.onStandingDrop = onStandingDrop;
  }

  @Override
  public ICombatSetting getOnStatusDrop() {
    return onStatusDrop;
  }

  public void setOnStatusDrop(ApiCombatSetting onStatusDrop) {
    this.onStatusDrop = onStatusDrop;
  }

  @Override
  public ICombatSetting getOnAggression() {
    return onAggression;
  }

  public void setOnAggression(ApiCombatSetting onAggression) {
    this.onAggression = onAggression;
  }

  @Override
  public ICombatSetting getOnCorporationWar() {
    return onCorporationWar;
  }

  public void setOnCorporationWar(ApiCombatSetting onCorporationWar) {
    this.onCorporationWar = onCorporationWar;
  }

  public void addFuelLevel(FuelLevel fuelLevel) {
    fuelMap.put(fuelLevel.getTypeID(), fuelLevel.getQuantity());
  }

  @Override
  public Collection<IFuel> getFuelMap() {
    Collection<IFuel> result = new ArrayList<IFuel>();
    for (Entry<Integer, Integer> next : fuelMap.entrySet()) {
      final int type = next.getKey();
      final int quantity = next.getValue();
      result.add(new IFuel() {

        @Override
        public int getQuantity() {
          return quantity;
        }

        @Override
        public int getTypeID() {
          return type;
        }

      });
    }
    return result;
  }

  @Override
  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  @Override
  public Date getStateTimestamp() {
    return stateTimestamp;
  }

  public void setStateTimestamp(Date stateTimestamp) {
    this.stateTimestamp = stateTimestamp;
  }

  @Override
  public Date getOnlineTimestamp() {
    return onlineTimestamp;
  }

  public void setOnlineTimestamp(Date onlineTimestamp) {
    this.onlineTimestamp = onlineTimestamp;
  }

  @Override
  public long getUseStandingsFrom() {
    return useStandingsFrom;
  }

  public void setUseStandingsFrom(long useStandingsFrom) {
    this.useStandingsFrom = useStandingsFrom;
  }

}
