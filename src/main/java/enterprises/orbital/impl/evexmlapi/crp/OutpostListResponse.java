package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class OutpostListResponse extends ApiResponse {
  private final Collection<ApiOutpost> outposts = new HashSet<ApiOutpost>();

  public void addOutpost(ApiOutpost outpost) {
    outposts.add(outpost);
  }

  public Collection<ApiOutpost> getOutposts() {
    return outposts;
  }

  private void addStationId(long stationID, Map<Long, Integer> stationIds) {
    int amount = 0;
    if (stationIds.containsKey(stationID)) {
      amount = stationIds.get(stationID);
      stationIds.remove(stationID);
    }
    stationIds.put(stationID, amount + 1);
  }

  @Override
  public String toString() {
    String result = "Current time: " + getCurrentTime() + "\nCached Untill: " + getCachedUntil() + "\nWe currently have " + outposts.size()
        + " outposts in space\n\n";
    Map<Long, Integer> stationIds = new HashMap<Long, Integer>();
    for (ApiOutpost outpost : outposts) {
      addStationId(outpost.getStationID(), stationIds);
      result += outpost + "\n";
    }
    result += "\n";
    for (Entry<Long, Integer> entry : stationIds.entrySet()) {
      result += entry.getKey() + " = " + entry.getValue() + "\n";
    }
    return result;
  }
}
