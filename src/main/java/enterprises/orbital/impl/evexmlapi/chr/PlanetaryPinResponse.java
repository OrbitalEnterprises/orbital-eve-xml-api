package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class PlanetaryPinResponse extends ApiResponse {
  private static final long           serialVersionUID = -1202677291018603255L;
  private final List<ApiPlanetaryPin> pins             = new ArrayList<ApiPlanetaryPin>();

  public void addPlanetaryPin(ApiPlanetaryPin pin) {
    pins.add(pin);
  }

  public List<ApiPlanetaryPin> getPlanetaryPins() {
    return pins;
  }
}