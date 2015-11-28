package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class StarbaseListResponse extends ApiResponse {
  private final Collection<ApiStarbase> starbases = new HashSet<ApiStarbase>();

  public void addStarbase(ApiStarbase starbase) {
    starbases.add(starbase);
  }

  public Collection<ApiStarbase> getStarbases() {
    return starbases;
  }

  private void addTypeId(int typeID, Map<Integer, Integer> typeIds) {
    int amount = 0;
    if (typeIds.containsKey(typeID)) {
      amount = typeIds.get(typeID);
      typeIds.remove(typeID);
    }
    typeIds.put(typeID, amount + 1);
  }

  @Override
  public String toString() {
    String result = "Current time: " + getCurrentTime() + "\nCached Untill: " + getCachedUntil() + "\nWe currently have " + starbases.size()
        + " starbases in space\n\n";
    Map<Integer, Integer> typeIds = new HashMap<Integer, Integer>();
    for (ApiStarbase starbase : starbases) {
      addTypeId(starbase.getTypeID(), typeIds);
      result += starbase + "\n";
    }
    result += "\n";
    for (Entry<Integer, Integer> entry : typeIds.entrySet()) {
      result += entry.getKey() + " = " + entry.getValue() + "\n";
    }
    return result;
  }
}
