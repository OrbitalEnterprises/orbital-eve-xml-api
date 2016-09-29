package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import enterprises.orbital.evexmlapi.chr.ISkill;
import enterprises.orbital.evexmlapi.chr.ISkillInfo;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class SkillInfoResponse extends ApiResponse implements ISkillInfo {
  private static final Logger          log    = Logger.getLogger(SkillInfoResponse.class.getName());
  private long                         freeSkillPoints;
  private final Set<ApiCharacterSkill> skills = new HashSet<ApiCharacterSkill>();

  public void setFreeSkillPoints(
                                 long freeSkillPoints) {
    this.freeSkillPoints = freeSkillPoints;
  }

  @Override
  public long getFreeSkillPoints() {
    return freeSkillPoints;
  }

  public void addCollector(
                           CharacterSheetRowsetDataCollector c) {
    // Copy collector objects based on type
    if (c.type.equals("skills")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        ApiCharacterSkill newSkill = new ApiCharacterSkill();
        newSkill.setTypeID(next.getTypeID());
        newSkill.setLevel(next.getLevel());
        newSkill.setSkillpoints(next.getSkillpoints());
        newSkill.setPublished(next.isPublished());
        skills.add(newSkill);
      }
    } else
      log.warning("Ignoring unknown collection type: " + c.type);
  }

  @Override
  public Set<ISkill> getSkills() {
    Set<ISkill> result = new HashSet<ISkill>();
    result.addAll(skills);
    return result;
  }

}
