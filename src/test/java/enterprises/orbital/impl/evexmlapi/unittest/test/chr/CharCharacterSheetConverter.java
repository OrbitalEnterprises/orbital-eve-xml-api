package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterRole;
import enterprises.orbital.evexmlapi.chr.ICharacterSheet;
import enterprises.orbital.evexmlapi.chr.ICharacterTitle;
import enterprises.orbital.evexmlapi.chr.IImplant;
import enterprises.orbital.evexmlapi.chr.IJumpClone;
import enterprises.orbital.evexmlapi.chr.IJumpCloneImplant;
import enterprises.orbital.evexmlapi.chr.ISkill;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharCharacterSheetConverter extends ResponseConverter {

  public static String convert(
                               ICharacterAPI request,
                               ICharacterSheet response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder.append("<characterID>").append(response.getCharacterID()).append("</characterID>\n");
    builder.append("<name>").append(response.getName()).append("</name>\n");
    builder.append("<homeStationID>").append(response.getHomeStationID()).append("</homeStationID>\n");
    builder.append("<DoB>").append(toEveDateFormat(response.getDoB())).append("</DoB>\n");
    builder.append("<race>").append(response.getRace()).append("</race>\n");
    builder.append("<bloodLineID>").append(response.getBloodlineID()).append("</bloodLineID>\n");
    builder.append("<bloodLine>").append(response.getBloodline()).append("</bloodLine>\n");
    builder.append("<ancestryID>").append(response.getAncestryID()).append("</ancestryID>\n");
    builder.append("<ancestry>").append(response.getAncestry()).append("</ancestry>\n");
    builder.append("<gender>").append(response.getGender()).append("</gender>\n");
    builder.append("<corporationName>").append(response.getCorporationName()).append("</corporationName>\n");
    builder.append("<corporationID>").append(response.getCorporationID()).append("</corporationID>\n");
    builder.append("<allianceName");
    if (response.getAllianceName() == null)
      builder.append(" />\n");
    else
      builder.append(">").append(response.getAllianceName()).append("</allianceName>\n");
    builder.append("<allianceID>").append(response.getAllianceID()).append("</allianceID>\n");
    builder.append("<factionName");
    if (response.getFactionName() == null)
      builder.append(" />\n");
    else
      builder.append(">").append(response.getAllianceName()).append("</factionName>\n");
    builder.append("<factionID>").append(response.getFactionID()).append("</factionID>\n");
    builder.append("<cloneTypeID>").append(response.getCloneTypeID()).append("</cloneTypeID>\n");
    builder.append("<cloneName>").append(response.getCloneName()).append("</cloneName>\n");
    builder.append("<cloneSkillPoints>").append(response.getCloneSkillPoints()).append("</cloneSkillPoints>\n");

    builder.append("<freeSkillPoints>").append(response.getFreeSkillPoints()).append("</freeSkillPoints>\n");
    builder.append("<freeRespecs>").append(response.getFreeRespecs()).append("</freeRespecs>\n");
    builder.append("<cloneJumpDate>").append(toEveDateFormat(response.getCloneJumpDate())).append("</cloneJumpDate>\n");
    builder.append("<lastRespecDate>").append(toEveDateFormat(response.getLastRespecDate())).append("</lastRespecDate>\n");
    builder.append("<lastTimedRespec>").append(toEveDateFormat(response.getLastTimedRespec())).append("</lastTimedRespec>\n");
    builder.append("<remoteStationDate>").append(toEveDateFormat(response.getRemoteStationDate())).append("</remoteStationDate>\n");

    builder.append("<rowset name=\"jumpClones\" key=\"jumpCloneID\" columns=\"jumpCloneID,typeID,locationID,cloneName\"");
    if (response.getJumpClones().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IJumpClone nextClone : response.getJumpClones()) {
        builder.append("<row jumpCloneID=\"").append(nextClone.getJumpCloneID());
        builder.append("\" typeID=\"").append(nextClone.getTypeID());
        builder.append("\" locationID=\"").append(nextClone.getLocationID());
        builder.append("\" cloneName=\"").append(nextClone.getCloneName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"jumpCloneImplants\" key=\"jumpCloneID\" columns=\"jumpCloneID,typeID,typeName\"");
    if (response.getJumpCloneImplants().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IJumpCloneImplant nextImplant : response.getJumpCloneImplants()) {
        builder.append("<row jumpCloneID=\"").append(nextImplant.getJumpCloneID());
        builder.append("\" typeID=\"").append(nextImplant.getTypeID());
        builder.append("\" typeName=\"").append(nextImplant.getTypeName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<jumpActivation>").append(toEveDateFormat(response.getJumpActivation())).append("</jumpActivation>\n");
    builder.append("<jumpFatigue>").append(toEveDateFormat(response.getJumpFatigue())).append("</jumpFatigue>\n");
    builder.append("<jumpLastUpdate>").append(toEveDateFormat(response.getJumpLastUpdate())).append("</jumpLastUpdate>\n");

    builder.append("<balance>").append(String.format("%.2f", response.getBalance())).append("</balance>\n");

    builder.append("<rowset name=\"implants\" key=\"typeID\" columns=\"typeID,typeName\"");
    if (response.getImplants().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (IImplant nextImplant : response.getImplants()) {
        builder.append("<row typeID=\"").append(nextImplant.getTypeID());
        builder.append("\" typeName=\"").append(nextImplant.getTypeName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<attributes>\n");
    builder.append("<intelligence>").append(response.getIntelligence()).append("</intelligence>\n");
    builder.append("<memory>").append(response.getMemory()).append("</memory>\n");
    builder.append("<charisma>").append(response.getCharisma()).append("</charisma>\n");
    builder.append("<perception>").append(response.getPerception()).append("</perception>\n");
    builder.append("<willpower>").append(response.getWillpower()).append("</willpower>\n");
    builder.append("</attributes>\n");

    builder.append("<rowset name=\"skills\" key=\"typeID\" columns=\"typeID,skillpoints,level,published\">\n");
    for (ISkill nextSkill : response.getSkills()) {
      builder.append("<row typeID=\"").append(nextSkill.getTypeID());
      builder.append("\" skillpoints=\"").append(nextSkill.getSkillpoints());
      builder.append("\" level=\"").append(nextSkill.getLevel());
      builder.append("\" published=\"").append(nextSkill.isPublished() ? 1 : 0).append("\" />\n");
    }
    builder.append("</rowset>\n");

    // Temporary - until they remove this from the API completely
    builder.append("<rowset name=\"certificates\" key=\"certificateID\" columns=\"certificateID\" />\n");

    Collection<ICharacterRole> corpRoles = new ArrayList<ICharacterRole>();
    Collection<ICharacterRole> corpRolesAtHQ = new ArrayList<ICharacterRole>();
    Collection<ICharacterRole> corpRolesAtBase = new ArrayList<ICharacterRole>();
    Collection<ICharacterRole> corpRolesAtOther = new ArrayList<ICharacterRole>();

    for (ICharacterRole nextRole : response.getRoles()) {
      switch (nextRole.getRoleCategory()) {
      case CORPORATION:
        corpRoles.add(nextRole);
        break;
      case CORPORATION_AT_HQ:
        corpRolesAtHQ.add(nextRole);
        break;
      case CORPORATION_AT_BASE:
        corpRolesAtBase.add(nextRole);
        break;
      case CORPORATION_AT_OTHER:
        corpRolesAtOther.add(nextRole);
        break;
      default:
        assert false;
      }
    }

    builder.append("<rowset name=\"corporationRoles\" key=\"roleID\" columns=\"roleID,roleName\"");
    if (corpRoles.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ICharacterRole nextRole : corpRoles) {
        builder.append("<row roleID=\"").append(nextRole.getRoleID());
        builder.append("\" roleName=\"").append(nextRole.getRoleName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"corporationRolesAtHQ\" key=\"roleID\" columns=\"roleID,roleName\"");
    if (corpRoles.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ICharacterRole nextRole : corpRolesAtHQ) {
        builder.append("<row roleID=\"").append(nextRole.getRoleID());
        builder.append("\" roleName=\"").append(nextRole.getRoleName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"corporationRolesAtBase\" key=\"roleID\" columns=\"roleID,roleName\"");
    if (corpRoles.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ICharacterRole nextRole : corpRolesAtBase) {
        builder.append("<row roleID=\"").append(nextRole.getRoleID());
        builder.append("\" roleName=\"").append(nextRole.getRoleName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"corporationRolesAtOther\" key=\"roleID\" columns=\"roleID,roleName\"");
    if (corpRoles.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ICharacterRole nextRole : corpRolesAtOther) {
        builder.append("<row roleID=\"").append(nextRole.getRoleID());
        builder.append("\" roleName=\"").append(nextRole.getRoleName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("<rowset name=\"corporationTitles\" key=\"titleID\" columns=\"titleID,titleName\"");
    if (response.getTitles().size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ICharacterTitle nextTitle : response.getTitles()) {
        builder.append("<row titleID=\"").append(nextTitle.getTitleID());
        builder.append("\" titleName=\"").append(nextTitle.getTitleName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}
