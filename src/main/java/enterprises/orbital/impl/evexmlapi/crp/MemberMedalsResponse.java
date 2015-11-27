package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MemberMedalsResponse extends ApiResponse {
  private static final long       serialVersionUID = -5240368363115330916L;
  private final List<MemberMedal> medals           = new ArrayList<MemberMedal>();

  public void addMedal(MemberMedal entry) {
    medals.add(entry);
  }

  public List<MemberMedal> getMemberMedals() {
    return medals;
  }
}