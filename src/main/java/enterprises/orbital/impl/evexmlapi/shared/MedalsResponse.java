package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MedalsResponse extends ApiResponse {
  private final List<Medal> medals = new ArrayList<Medal>();

  public void addMedal(Medal entry) {
    medals.add(entry);
  }

  public List<Medal> getMedals() {
    return medals;
  }
}