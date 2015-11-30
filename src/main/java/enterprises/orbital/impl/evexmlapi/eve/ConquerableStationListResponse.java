package enterprises.orbital.impl.evexmlapi.eve;

import java.util.HashMap;
import java.util.Map;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ConquerableStationListResponse extends ApiResponse {
  private final Map<Long, ApiStation> stations = new HashMap<Long, ApiStation>();

  public void addStation(ApiStation station) {
    stations.put(station.getStationID(), station);
  }

  public Map<Long, ApiStation> getStations() {
    return stations;
  }
}
