package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class SkillQueueResponse extends ApiResponse {
  private static final long             serialVersionUID = -2789547304401193954L;
  private final List<ApiSkillQueueItem> skillQueueItems  = new ArrayList<ApiSkillQueueItem>();

  public void addSkillQueueItem(ApiSkillQueueItem skillQueueItem) {
    skillQueueItems.add(skillQueueItem);
  }

  public List<ApiSkillQueueItem> getSkillQueueItems() {
    return skillQueueItems;
  }
}